package info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By username = By.name("username");
	By password = By.name("password");
	By loginButton = By.xpath("//button[text()='Login']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUsername(String strUsername) {
		driver.findElement(username).sendKeys(strUsername);
	}

	public void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public void loginToApp(String strUsername, String strPassword) {
		this.setUsername(strUsername);
		this.setPassword(strPassword);
		this.clickLogin();
	}
}
