package assignment;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MockAssignment {
	
	WebDriver driver = new ChromeDriver();
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
	}

	@When("they enter {string} and {string}")
	public void they_enter_and(String string, String string2) {
	    driver.findElement(By.id("username")).sendKeys(string);
        driver.findElement(By.id("password")).sendKeys(string2);
	}

	@When("they click the login button")
	public void they_click_the_login_button() {
		driver.findElement(By.id("submit")).click();
	}

	@Then("they should be redirected to the dashboard")
	public void they_should_be_redirected_to_the_dashboard() {
		String successMessage = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[1]/h1")).getText();
        assertEquals("Logged In Successfully", successMessage);
	}
}
