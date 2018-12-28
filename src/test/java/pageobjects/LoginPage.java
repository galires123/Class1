package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;

public class LoginPage extends BasePage{
	@FindBy(css="[data-test='username']")
	@CacheLookup
	private WebElement userField;
	@FindBy(css="[data-test='password']")
	@CacheLookup
	private WebElement passwordField;
	@FindBy(css=".login-button")
	@CacheLookup
	private WebElement btnLogin;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Parameters(value = "loginNegData")
	public void login(String user,String password) {
		fillText(userField, user);
		fillText(passwordField, password);
		click(btnLogin);
	}

	@Parameters(value = "GetData")
	public void addData(String user, int num) {
		System.out.println("The name is + " + user + "psw" + num);
	}
	
	public void login() {
	Faker faker = new Faker();
	String user= faker.name().fullName();
	String password = faker.internet().password();
	
	fillText(userField, user);
	fillText(passwordField, password);
	click(btnLogin);		
	}

}
