package teste;

import static org.junit.Assert.assertEquals;

import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import driver.Drivers;
import elementos.Elementos;
import homePage.CriarConta;
import metodos.Metodos;

public class ValidarTransferencia extends Drivers {

    private ExtentReports extent;
    private ExtentTest test;
    Metodos metodos = new Metodos();
    Elementos el = new Elementos();
    CriarConta conta = new CriarConta();
    private String abaOriginal;
    private String numeroDaConta;
    private String digito;

    @Before
    public void abrirNavegador() throws InterruptedException {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/extent-report.html");
        sparkReporter.config().setDocumentTitle("Relatório de Testes");
        sparkReporter.config().setReportName("Testes Automatizados");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        Metodos.abrirNavegador();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        abaOriginal = driver.getWindowHandle();

        metodos.clicar(el.btnRegistrar);
        metodos.escrever(el.cadastrarEmail, conta.emailPrimeiraConta);
        metodos.escrever(el.nome, conta.nomePrimeiraConta);
        metodos.escrever(el.cadastrarSenha, conta.senhaPrimeiraConta);
        metodos.escrever(el.confirmacaoSenha, conta.confirmarSenhaPrimeiraConta);
        metodos.clicar(el.btnContaComSaldo);
        metodos.clicar(el.btnCadastrar);

        String textoCompleto = driver.findElement(By.id("modalText")).getText();
        String[] partes = extrairNumeroDaConta(textoCompleto).split("-");
        numeroDaConta = partes[0];
        digito = partes[1];
        System.out.println("Número da conta: " + numeroDaConta);
        System.out.println("Dígito: " + digito);

        metodos.clicar(el.btnFechar);

        abrirNovaAba();

        driver.get("https://bugbank.netlify.app");
        metodos.clicar(el.btnRegistrar);
        metodos.escrever(el.cadastrarEmail, conta.emailSegundaConta);
        metodos.escrever(el.nome, conta.nomeSegundaConta);
        metodos.escrever(el.cadastrarSenha, conta.senhaSegundaConta);
        metodos.escrever(el.confirmacaoSenha, conta.confirmarSenhaSegundaConta);
        metodos.clicar(el.btnContaComSaldo);
        metodos.clicar(el.btnCadastrar);

        metodos.clicar(el.btnFechar);

        voltarParaAbaOriginal();
    }

    public String extrairNumeroDaConta(String textoCompleto) {
        String padraoRegex = "\\b\\d+-\\d+\\b";
        String numeroDaConta = "";

        java.util.regex.Matcher matcher = Pattern.compile(padraoRegex).matcher(textoCompleto);
        if (matcher.find()) {
            numeroDaConta = matcher.group();
        }

        return numeroDaConta;
    }

    private void abrirNovaAba() {
        ((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(abaOriginal)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    private void voltarParaAbaOriginal() {
        driver.switchTo().window(abaOriginal);
    }

    public void validarTransferenciaEnviada() {
        WebElement mensagemElement = driver.findElement(By.id("textBalanceAvailable"));
        String mensagem = mensagemElement.getText();
        String mensagemEsperada = "R$ 240,00";
        assertEquals(mensagemEsperada, mensagem);
    }

    public void validarTransferenciaRecebida() {
        WebElement mensagemElement = driver.findElement(By.id("textBalanceAvailable"));
        String mensagem = mensagemElement.getText();
        String mensagemEsperada = "R$ 1.760,00";
        assertEquals(mensagemEsperada, mensagem);
    }

    @Test
    public void transferenciaEntreContas() {
        test = extent.createTest("Transferência Entre Contas", "Teste de transferência de valores entre contas");
        metodos.escrever(el.email, conta.emailSegundaConta);
        metodos.escrever(el.senha, conta.senhaSegundaConta);
        metodos.clicar(el.btnAcessar);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        metodos.clicar(el.Transferencia);

        metodos.escrever(el.numeroDaConta, numeroDaConta);
        metodos.escrever(el.digitoConta, digito);
        metodos.escrever(el.valorTransferencia, conta.valorDaTransferencia);

        metodos.clicar(el.btnTransferirAgora);

        wait.until(ExpectedConditions.elementToBeClickable(el.btnFechar)).click();
        wait.until(ExpectedConditions.elementToBeClickable(el.btnVoltar)).click();
        wait.until(ExpectedConditions.elementToBeClickable(el.extrato)).click();

        validarTransferenciaEnviada();

        wait.until(ExpectedConditions.elementToBeClickable(el.btnSair)).click();
        metodos.escrever(el.email, conta.emailPrimeiraConta);
        metodos.escrever(el.senha, conta.confirmarSenhaPrimeiraConta);
        wait.until(ExpectedConditions.elementToBeClickable(el.btnAcessar)).click();
        wait.until(ExpectedConditions.elementToBeClickable(el.extrato)).click();

        validarTransferenciaRecebida();

        test.log(Status.PASS, "Teste executado com sucesso");
    }

    @After
    public void fecharNavegador() {
        driver.quit();
        extent.flush();
    }
}