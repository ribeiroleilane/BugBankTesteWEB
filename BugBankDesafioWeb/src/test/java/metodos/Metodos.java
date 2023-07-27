package metodos;


import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import driver.Drivers;
import elementos.Elementos;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Metodos extends Drivers {
	
	Elementos elementos = new Elementos();

	
	public static void abrirNavegador() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions chromeOptions = new ChromeOptions();
	//chromeOptions.addArguments("--headless");
	chromeOptions.addArguments("--start-maximized");
	driver = new ChromeDriver(chromeOptions);
	driver.get("https://bugbank.netlify.app/");
}
	
	public void escrever(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);
	}

	public void clicar(By elemento) {
		driver.findElement(elemento).click();
	}
	
	public void validarAlert(String msgEsperada) {
		try {
			Alert alert = driver.switchTo().alert();
			String criacaoConta = alert.getText();
			assertTrue(criacaoConta.contains(msgEsperada));
		} catch (Exception e) {
			System.err.println("*********Erro ao validar alert*********");
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
		
	
		
	}

	
}
