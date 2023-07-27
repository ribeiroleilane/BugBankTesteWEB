package elementos;

import org.openqa.selenium.By;

public class Elementos {
	
	public By btnRegistrar = By.xpath("//button[@class='style__ContainerButton-sc-1wsixal-0 ihdmxA button__child']");
	public By cadastrarEmail = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input");
	public By nome = By.xpath("//input[@name='name']");
	public By cadastrarSenha = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input");
	public By confirmacaoSenha = By.xpath("//input[@name='passwordConfirmation']");
	public By btnContaComSaldo = By.id("toggleAddBalance");
	public By btnCadastrar = By.xpath("//button[@class='style__ContainerButton-sc-1wsixal-0 CMabB button__child']");
	public By btnFechar = By.id("btnCloseModal");
	public By email = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/form/div[1]/input");
	public By senha = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/form/div[2]/div/input");
	public By btnAcessar = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/form/div[3]/button[1]");
	public By Transferencia = By.id("btn-TRANSFERÊNCIA");
	public By numeroDaConta = By.xpath("//input[@name='accountNumber']");
	public By digitoConta = By.xpath("//input[@name='digit']");
	public By valorTransferencia = By.xpath("//input[@name='transferValue']");
	public By btnTransferirAgora = By.xpath("//button[@type='submit']");
	public By btnVoltar = By.id("btnBack");
	public By extrato = By.id("btn-EXTRATO");
	public By mensagemContaCriada = By.xpath("//p[@id='modalText']");	
	public By btnSair = By.id("btnExit");
}
