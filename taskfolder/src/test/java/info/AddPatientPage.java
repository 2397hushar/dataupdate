package info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddPatientPage {
	WebDriver driver;
	By patientName = By.name("patientName");
	By patientAge = By.name("patientAge");
	By submitButton = By.xpath("//button[text()='Submit']");

	public AddPatientPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setPatientName(String name) {
		driver.findElement(patientName).sendKeys(name);
	}

	public void setPatientAge(String age) {
		driver.findElement(patientAge).sendKeys(age);
	}

	public void clickSubmit() {
		driver.findElement(submitButton).click();
	}
}
