package iCarros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IndexPage {
	private WebDriver driver;
	
	public IndexPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	private By botaoLogin = By.cssSelector("#userLogin div a");
	private By usuarioLogado = By.cssSelector(".dropdown__box--username");
	private By titulo = By.className("hero__title");
	
	public void carregarPaginaInicial() {
		driver.get("https://www.icarros.com.br/principal/index.jsp");	
	}
	
	public LoginPage clicarLogin() 
	{
		esperar(botaoLogin);
		driver.findElement(botaoLogin).click();
		
		return new LoginPage(driver);
	}
	
	public String obterUsuario() 
	{
		esperar(usuarioLogado);
		return driver.findElement(usuarioLogado).getText();
	}
	
	public String obterTitulo() 
	{
		esperar(titulo);
		return driver.findElement(titulo).getText();
	}
	
	public void esperar(By elemento) 
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elemento));
	}

}
