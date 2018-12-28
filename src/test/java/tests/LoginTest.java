package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.DataProviderPage;
import pageobjects.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void lg1_loginFailed() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "111");		
	}
	
	@Test
	public void lg11_loginFailed() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "333");
	}
	
	///////////////////////////////// Home Work 1 ///////////////////////////////////
	@Test //Faker
	public void lg12_loginFacker_Failed() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
	}

	//DataProvider
	@Test(dataProviderClass= DataProviderPage.class, dataProvider="loginNegData")
	public void lg13_loginDataProvider_Failed(String username, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
	}
	
	//DataProvider
	@Test(dataProviderClass= DataProviderPage.class, dataProvider="GetData")
	public void lg14_loginDataProvider_Failed(String username, int password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.addData(username, password);
	}
	
	
	//Parameters
	@Test @Parameters({"user1", "pass1"}) // @Optional
	public void lg14_loginPrameters_Failed(String user1, String pass1) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(user1, pass1);
	}
	
	@Test @Parameters({"user2", "pass2"}) // @Optional
	public void loginAsadmin(String user2, String pass2) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(user2, pass2);
		System.out.println("The Admin user is: " + user2 + "Pasw" + pass2);
	}
	
	//DataProvider + Faker
	@Test(dataProviderClass= DataProviderPage.class, dataProvider="loginFaker")
	public void lg15_loginDataProviderFaker_Failed(String username, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
	}
	
	///////////////////////////////// END Home Work 1 ///////////////////////////////////
	
	@Test
	public void lg2_loginSucced() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
	}
	
}
