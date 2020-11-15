package steps;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import iCarros.IndexPage;
import iCarros.LoginPage;

public class BaseTestes {
	
	private static WebDriver driver;
	protected IndexPage indexPage;

	// instanciar o driver
	@BeforeClass
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C:\\driversExternos\\chromedriver\\86\\chromedriver.exe");

	}
	
/*
	
	@BeforeMethod
	public void carregarPaginaPrincipal() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("BEFORE EACH");
		driver.get("https://www.icarros.com.br/principal/index.jsp");
		
		indexPage = new IndexPage(driver);
		//paginaInicial = new PaginaInicial(driver);
	}
	
	/*@BeforeSuite
	public void carregarPaginaPrincipal2() 
	{
		inicializar();
		System.out.println("BEFORE SUITE");
		driver.get("https://www.icarros.com.br/principal/index.jsp");
		
		paginaInicial = new PaginaInicial(driver);
	}
	
	@AfterMethod
	public void finalizar()
	{
		//driver.quit();
	}
}
*/

	// navegar até a página inicial
	@BeforeMethod
	public void carregarPaginaInicial() {

		driver = new ChromeDriver();
		
		driver.get("https://www.icarros.com.br/principal/index.jsp");

		// criaruma nova homePage criando um driver
		indexPage = new IndexPage(driver);
	}

	@AfterClass
	public static void finalizar() {
		//driver.quit();
	}

}
