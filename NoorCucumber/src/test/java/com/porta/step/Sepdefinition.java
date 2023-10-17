package com.porta.step;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Sepdefinition {

	public static WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait wait;

	@Given("launch makemytrip portal")
	public void launch_makemytrip_portal() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		// System.setProperty("Webdriver.edge.driver","C:\\Users\\noorb\\eclipse-workspace\\NOORBASHA\\src\\msedgedriver.exe");
		// driver = new EdgeDriver(options);
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");

	}

	@When("^we enter From location HYD and To locaion as MAA$")
	public void we_enter_From_location_HYD_and_To_locaion_as_MAA() throws Throwable {
		js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@data-cy='closeModal']")));
		// driver.findElement(By.xpath("//span[@data-cy='closeModal']"))

		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("HYD");
		Thread.sleep(1000);
		Actions ac = new Actions(driver);

		ac.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

		// driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("MAA");
		Thread.sleep(1000);
		ac.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		// driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(Keys.DOWN);

	}

	@Then("^select departure date as and return date$")
	public void select_departure_date_as_and_return_date() throws Throwable {
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@id='departure']")));

		driver.findElement(By.xpath("//div[@aria-label='Thu Oct 26 2023']")).click();

		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[@data-cy='returnDefaultText']")));

		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@aria-label='Tue Oct 31 2023']")));

	}

	@Then("click on search")
	public void click_on_search() {
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p//a[contains(@class,'Search')]")));

	}

	@Then("verify search page is displayed as expeced")
	public void verify_search_page_is_displayed_as_expeced() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
				"//div[@class='flightsContainer makeFlex spaceBetween']//*[@class='font24 blackFont whiteText appendBottom20 journey-title makeFlex spaceBetween bottom']/span"))));
		String txt = driver.findElement(By.xpath(
				"//div[@class='flightsContainer makeFlex spaceBetween']//*[@class='font24 blackFont whiteText appendBottom20 journey-title makeFlex spaceBetween bottom']/span"))
				.getText();

		Assert.assertEquals(txt, "Flights from Hyderabad to Chennai, and back");

		driver.close();

	}

}
