package Features;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class assignment {

	WebDriver driver = new ChromeDriver();
	
	@Given("I am on the Login page URL {string}")
	public void i_am_on_the_login_page_url(String string) {
		driver.get(string);
		driver.manage().window().maximize();
	}

	@Then("I click on sign in button and wait for sign in page")
	public void i_click_on_sign_in_button_and_wait_for_sign_in_page() {
		WebElement signInButton = driver.findElement(By.id("nav-link-accountList-nav-line-1")); 
		signInButton.click();
	}

	@Then("I should see Sign In Page")
	public void i_should_see_sign_in_page() {
		if (driver.getCurrentUrl().equals("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fref%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0")) {
            System.out.println("Sign In Page.");
        } else {
            System.out.println("Page Not Found");
        }
		
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String string) {
		WebElement usernameField = driver.findElement(By.id("ap_email")); 
        usernameField.sendKeys(string);
	}

	@When("I Click on Continue button")
	public void i_click_on_continue_button() {
		WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String string) {
		WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys(string);
        
	}

	@When("click on login button")
	public void click_on_login_button() {
		WebElement loginButton = driver.findElement(By.id("signInSubmit"));
        loginButton.click();
	}

	@Then("I am logged in")
	public void i_am_logged_in() {
		if (driver.getCurrentUrl().equals("https://www.amazon.in/?ref_=nav_ya_signin")) {
            System.out.println("Logged in successfully.");            
        } else {
            System.out.println("Login failed");
        }
	}

	@Then("I clear cart items if any")
	public void i_clear_cart_items_if_any() {
		WebElement chart = driver.findElement(By.id("nav-cart-count")); 
	    chart.click();
        WebElement deleteItemButton = driver.findElement(By.xpath("//*[@id=\"sc-active-3e1c1d01-d117-4e46-8291-a186a5ce836a\"]/div[4]/div/div[3]/div[1]/span[2]"));
        if (deleteItemButton.isDisplayed()) {
            deleteItemButton.click();
            System.out.println("Cart items cleared successfully.");
        } else {
            System.out.println("No items in the cart to clear.");
        }
	}

	@Then("I choose Electronics>Headphones and headphones list out")
	public void i_choose_electronics_headphones_and_headphones_list_out() {
		WebElement electronicsCategory = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]"));
        electronicsCategory.click();
        WebElement headphonesSubcategory = driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[1]/ul/li[18]/span/a"));
        headphonesSubcategory.click();
        WebElement headphonesHeadphone = driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[1]/ul/li[8]/span/a"));
        headphonesHeadphone.click();
        WebElement headphonesOnear = driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[1]/ul/li[5]/span/a"));
        headphonesOnear.click();
	}

	@Then("I add first available headphone to cart")
	public void i_add_first_available_headphone_to_cart() {
		WebElement firstHeadphone = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/span/div/div/div[2]/div[2]/h2/a"));
        firstHeadphone.click();
        Set<String> s = driver.getWindowHandles();
        ArrayList ar = new ArrayList(s);
        System.out.println(ar.get(0));
        System.out.println(ar.get(1));        
        driver.switchTo().window((String)ar.get(1));
		WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
        addToCartButton.click();
        driver.navigate().back();
	}

	@Then("I search {string} and add second available item to cart")
	public void i_search_and_add_second_available_item_to_cart(String string) {
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(string);
        searchBox.submit();
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"a-autoid-6-announce\"]"));
        addToCartButton.click();
	}

	@Then("I Select cart from home and remove the earlier added headphones")
	public void i_select_cart_from_home_and_remove_the_earlier_added_headphones() {
		 WebElement cartIcon = driver.findElement(By.xpath("//*[@id=\"nav-cart-count-container\"]"));
	        cartIcon.click();
	        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"sc-active-23ea3c9d-046f-4268-b841-e6be6f779fc0\"]/div[4]/div/div[3]/div[1]/span[2]/span/input"));
	        deleteButton.click();
	}

	@Then("I Reduce the Quantity of the macbook pro product to one and proceed to checkout")
	public void i_reduce_the_quantity_of_the_macbook_pro_product_to_one_and_proceed_to_checkout() {
		WebElement quantityInput = driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]"));
        quantityInput.click();
        WebElement quantitySelect = driver.findElement(By.xpath("//*[@id=\"a-popover-1\"]/div/div/ul/li[2]"));
        quantitySelect.click();
	}

	@Then("I Click on Sign out")
	public void i_click_on_sign_out() {
		WebElement signOutButton = driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]/span"));
        signOutButton.click();
	}

	@Then("I got log out from the application and land on sign in page")
	public void i_got_log_out_from_the_application_and_land_on_sign_in_page() {
		if (driver.getCurrentUrl().equals("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0")) {
            System.out.println("Logged out from the application and landed on the sign-in page.");
        } else {
            System.out.println("Logout failed");
        }
	}
}
