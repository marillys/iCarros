package steps;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import iCarros.IndexPage;
import iCarros.LoginPage;

public class Teste extends BaseTestes{
	
	LoginPage loginPage;
	
	@Test
	public void Login() 
	{
		loginPage = indexPage.clicarLogin();
		
		assertEquals(loginPage.obterTitulo(), "Acesso");
	}
	
}
