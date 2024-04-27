package Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logins {
    WebDriver driver;   	
    @Given("Open the Firefox and launch the application")
	public void open_the_firefox_and_launch_the_application() {
	    System.out.println("Given Executed...");
    System.setProperty("webdriver.chrome.driver","C:\\Users\\Sahil\\Downloads\\chrome-win64\\chrome-win64\\chromedriver.exe");
    driver= new ChromeDriver();					
    driver.manage().window().maximize();			
    driver.get("https://www.saucedemo.com/");	
	}

	@When("Enter the Username and Password")
	public void enter_the_username_and_password() {
    System.out.println("When Executed...");
    WebElement ur=driver.findElement(By.name("user-name"));
    ur.sendKeys("standard_user");
    WebElement ps=driver.findElement(By.name("password"));
    ps.sendKeys("secret_sauce1");
    }

	@Then("Reset the credential")
	public void reset_the_credential() {
		System.out.println("Then Executed...");
		WebElement l=driver.findElement(By.name("login-button"));
	    l.click();
	    String expectedURL="https://www.saucedemo.com/inventory.html";
	    String actualURL=driver.getCurrentUrl();
	    System.out.println("Actual URL"+actualURL);
	    Assert.assertEquals(expectedURL,actualURL);
	    }

}