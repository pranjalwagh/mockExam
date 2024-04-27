package Features;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class task2 {
	
	WebDriver driver = new ChromeDriver();
	
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		driver.get("https://practicetestautomation.com/");
		driver.manage().window().maximize();
	}

	@When("User navigate to Login Page")
	public void user_navigate_to_login_page() {
		driver.findElement(By.id("menu-item-20")).click();
		driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div[1]/div[1]/p/a")).click();
	}

	@Then("User enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
		driver.findElement(By.id("username")).sendKeys(string);
        driver.findElement(By.id("password")).sendKeys(string2);
	}

	@Then("Keeping case as Valid")
	public void keeping_case_as_valid() {
		// No action required for this step in Selenium
	}

	@Then("User should get logged in")
	public void user_should_get_logged_in() {
		driver.findElement(By.id("submit")).click();
	}

	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() {
		String successMessage = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[1]/h1")).getText();
        assertEquals("Logged In Successfully", successMessage);
	}

	@Then("user will be asked to go back to login page")
	public void user_will_be_asked_to_go_back_to_login_page() {
		driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a")).click();
	}

	@Then("Provide correct credentials")
	public void provide_correct_credentials() {
		// No action required for this step
		
	}

	@Then("Keeping case as Invalid")
	public void keeping_case_as_invalid() {
		// No action required for this step

	}
}
