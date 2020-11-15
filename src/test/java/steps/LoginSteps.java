package steps;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import iCarros.IndexPage;
import iCarros.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {
	private static WebDriver driver;
	private IndexPage indexPage = new IndexPage(driver);
	private LoginPage loginPage;
	
	@Before
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C:\\driversExternos\\chromedriver\\86\\chromedriver.exe");

		driver = new ChromeDriver();
	}

	@Dado("que eu estou na tela de login")
	public void que_eu_estou_na_tela_de_login() {
		indexPage.carregarPaginaInicial();
		loginPage = indexPage.clicarLogin();

		assertEquals(loginPage.obterTitulo(), "Acesso");
	}

	@Quando("clico no botao ENTRAR")
	public void clico_no_botao_entrar() {
		loginPage.clicarBotaoEntrar();
	}

	@Entao("acesso o sistema")
	public void acesso_o_sistema() {
		indexPage = loginPage.indexPage();
	    assertEquals(indexPage.obterTitulo(), "Encontre aqui seu próximo carro");
		//assertFalse(loginPage.existe_botaoEntrar());
	}
	
	@Quando("informo {string} e {string}")
	public void informo_e(String usuario, String senha) {
		loginPage.preencherEmail(usuario);
	    loginPage.preencherSenha(senha);
	    
	    /*assertEquals(loginPage.obterTextoEmail(), usuario);
	    assertEquals(loginPage.obterTextoSenha(), senha);*/
	}

	@Entao("a {string} eh exibida")
	public void a_eh_exibida(String mensagem) {
	    assertEquals(loginPage.obterTextoAviso(), mensagem);
	}

	@Entao("eh exibida um aviso solicitando dados")
	public void eh_exibida_um_aviso_solicitando_dados() {
	    assertEquals(loginPage.obterErroSenha(), "Insira sua senha.");
	    assertEquals(loginPage.obterErroEmail(), "Insira seu e-mail.");
	}
	
	@Entao("eh exibida o {string} para o campo e-mail")
	public void eh_exibida_o_para_o_campo_e_mail(String email) {
		
	    assertEquals(loginPage.obterErroEmail(), "Insira seu e-mail.");
	}

	@Entao("eh exibida o {string} para o campo senha")
	public void eh_exibida_o_para_o_campo_senha(String senha) {
		assertEquals(loginPage.obterErroSenha(), "Insira sua senha.");
	}
	
	@Quando("clico no botao {string}")
	public void clico_no_botao(String botao) {
	    
	}

	@Quando("informo os dados")
	public void informo_os_dados() {
	    
	}
	
	@AfterClass
	public void finalizar()
	{
		driver.quit();
	}
}
