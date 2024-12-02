package info;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PathologyLabTests {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	CostCalculatorPage costCalculatorPage;
	AddPatientPage addPatientPage;

	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://gor-pathology.web.app/");
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		costCalculatorPage = new CostCalculatorPage(driver);
		addPatientPage = new AddPatientPage(driver);
	}

	@Test
	public void testLogin() {
		loginPage.loginToApp("test@kennect.io", "Qwerty@1234");
		Assert.assertTrue(driver.getCurrentUrl().contains("/home"), "Login Failed");
	}

	@Test
	public void testHomePage() {
		loginPage.loginToApp("test@kennect.io", "Qwerty@1234");
		Assert.assertTrue(homePage.isTodoListVisible(), "Todo list is not visible");
	}

	@Test
	public void testCostCalculator() {
		loginPage.loginToApp("test@kennect.io", "Qwerty@1234");
		homePage.clickCostCalculator();
		costCalculatorPage.selectTest1();
		costCalculatorPage.selectTest2();
		costCalculatorPage.applyDiscount("10");
		costCalculatorPage.clickCalculate();
		Assert.assertTrue(costCalculatorPage.isTotalCostDisplayed(), "Cost calculation failed");
	}

	@Test
	public void testAddPatient() {
		loginPage.loginToApp("test@kennect.io", "Qwerty@1234");
		homePage.clickAddPatient();
		addPatientPage.setPatientName("John Doe");
		addPatientPage.setPatientAge("30");
		addPatientPage.clickSubmit();
		Assert.assertTrue(homePage.isTodoListVisible(), "New patient not added to list of todos");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
