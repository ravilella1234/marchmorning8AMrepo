package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(linkText="Sign in")WebElement signIn;
	@FindBy(id="email")WebElement customerEmail;
	@FindBy(id="passwd")WebElement customerPassword;
	@FindBy(id="SubmitLogin")WebElement submitLogin;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]")WebElement actualError;
	
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void customerLogin() throws Exception
	{
		signIn.click();
		Thread.sleep(2000);
		customerEmail.sendKeys("qatest8758786@gmail.com");
		customerPassword.sendKeys("password");
		submitLogin.click();
	}
	
	public String verifyError()
	{
		return actualError.getText();
	}
	

}
