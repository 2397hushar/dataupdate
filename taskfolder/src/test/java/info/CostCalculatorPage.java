package info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CostCalculatorPage {
	WebDriver driver;
	By test1 = By.name("test1");
	By test2 = By.name("test2");
	By discount = By.name("discount");
	By calculateButton = By.className("calculate-cost");
	By totalCost = By.className("total-cost");

	public CostCalculatorPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectTest1() {
		driver.findElement(test1).click();
	}

	public void selectTest2() {
		driver.findElement(test2).click();
	}

	public void applyDiscount(String discountValue) {
		driver.findElement(discount).sendKeys(discountValue);
	}

	public void clickCalculate() {
		driver.findElement(calculateButton).click();
	}

	public boolean isTotalCostDisplayed() {
		return driver.findElement(totalCost).getText().contains("Total Cost:");
	}
}
