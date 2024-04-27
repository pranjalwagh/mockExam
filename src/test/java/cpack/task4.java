package cpack;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class task4 {
	
	WebDriver driver = new ChromeDriver();
	
	@Given("I open the login page")
	public void i_open_the_login_page() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
	}

	@When("I enter username and password form gien sheet {string} and rownumber {int}")
	public void i_enter_username_and_password_form_gien_sheet_and_rownumber(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	    ExcelReader reader = new ExcelReader();
	    List<Map<String,String>> testData = 
	    		reader.getData("D:\\worldline\\Tasks\\Task 4 Data Provider with Cucumber BDD\\task.xlsx", SheetName);
	    
	    String username = testData.get(RowNumber).get("username");
	    String password = testData.get(RowNumber).get("password");
	    
	    driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("I click the login button")
	public void i_click_the_login_button() {
		driver.findElement(By.id("submit")).click();
	}

	@Then("I should be logged in")
	public void i_should_be_logged_in() {
		String successMessage = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[1]/h1")).getText();
        assertEquals("Logged In Successfully", successMessage);
	}

}
