package iCarros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	private By titulo = By.cssSelector("h1.text");
	private By botaoEntrar = By.id("entrar");
	private By campoSenha = By.id("password");
	private By campoEmail = By.id("username");
	private By aviso = By.cssSelector(".alert p");
	private By errorEmail = By.id("username-error");
	private By errorSenha = By.id("password-error");
	private By entrarFacebook = By.id("prd_facebook");
	private By entrarGoogle = By.id("prd_google");
	
	public String obterTitulo() 
	{
		esperar(titulo);
		return driver.findElement(titulo).getText();
	}
	
	public void clicarBotaoEntrar() 
	{
		esperar(botaoEntrar);
		driver.findElement(botaoEntrar).click();
	}
	
	public void preencherEmail(String email) 
	{
		preencher(email,campoEmail);
	}
	
	public void preencherSenha(String senha) 
	{
		preencher(senha, campoSenha);
	}
	
	public void preencher(String texto, By elemento) 
	{
		esperar(elemento);
		driver.findElement(elemento).sendKeys(texto);
	}
	
	public void esperar(By elemento) 
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elemento));
	}
	
	public String obterTextoAviso() 
	{
		esperar(aviso);
		return driver.findElement(aviso).getText();
	}
	
	public String obterTextoEmail() 
	{
		esperar(campoEmail);
		return driver.findElement(campoEmail).getText();
	}
	
	public String obterTextoSenha() 
	{
		esperar(campoSenha);
		return driver.findElement(campoSenha).getText();
	}
	
	public Boolean existe_botaoEntrar() 
	{
		return existe(botaoEntrar);
	}
	
	public Boolean existe(By elemento) 
	{
		//esperar(elemento);
		return driver.findElement(elemento).isDisplayed();
	}
	
	public String obterErroSenha() 
	{
		esperar(errorSenha);
		return driver.findElement(errorSenha).getText();
	}
	
	public String obterErroEmail() 
	{
		esperar(errorEmail);
		return driver.findElement(errorEmail).getText();
	}
	
	public IndexPage indexPage() 
	{
		return new IndexPage(driver);
	}
}
