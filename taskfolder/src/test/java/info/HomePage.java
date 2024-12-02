package info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	By todoList = By.className("todo-list");
	By costCalculatorLink = By.xpath("//a[contains(text(),'Cost Calculator')]");
	By addPatientLink = By.xpath("//a[contains(text(),'Add Patient')]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isTodoListVisible() {
		return driver.findElement(todoList).isDisplayed();
	}

	public void clickCostCalculator() {
		driver.findElement(costCalculatorLink).click();
	}

	public void clickAddPatient() {
		driver.findElement(addPatientLink).click();
	}
}
