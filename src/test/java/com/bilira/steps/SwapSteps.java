package com.bilira.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bilira.testbase.BaseClass;
import com.bilira.utils.CommonMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SwapSteps extends CommonMethods  {

	@Given("user is logged in with valid credentials")
	public void user_is_logged_in_with_valid_credentials() {
		driver.findElement(By.id("login-username")).sendKeys("testuser");
	    driver.findElement(By.id("login-password")).sendKeys("password123");
	    driver.findElement(By.id("login-button")).click();

	}

	@And("user navigates to Swap page")
	public void user_navigates_to_swap_page() {
		 driver.findElement(By.id("nav-swap")).click();

	}

	@When("the user selects {string} as the source currency")
	public void the_user_selects_as_the_source_currency(String string) {
		driver.findElement(By.id("source-currency")).sendKeys("USDT");
	}

	@When("the user selects {string} as the target currency")
	public void the_user_selects_as_the_target_currency(String string) {
		driver.findElement(By.id("target-currency")).sendKeys("BTC");
	}

	@When("the user enters {string} as the amount to swap")
	public void the_user_enters_as_the_amount_to_swap(String string) {
		driver.findElement(By.id("swap-amount")).sendKeys("100");
	}

	@When("the user requests a quote")
	public void the_user_requests_a_quote() {
		driver.findElement(By.id("get-quote")).click();

	}

	// eger end pointten 200 dönüyor mu test etmek istersek:
	//public void validateExchangeRateAPI() {
//    Response response = given()
//            .baseUri("cryptoswap.com")
//            .queryParam("source", "USDT")
//            .queryParam("target", "BTC")
//            .queryParam("amount", "100")
//            .when()
//            .get("/swap-rate")
//            .then()
//            .statusCode(200)  
//            .extract().response(); 

	@When("the user confirms the swap")
	public void the_user_confirms_the_swap() {
		driver.findElement(By.id("confirm-swap")).click();

	}

	@Then("the swap is executed successfully")
	public void the_swap_is_executed_successfully() {
		WebElement balance = driver.findElement(By.id("updated-balance"));
		Assert.assertTrue(balance.isDisplayed());

	}

	@Then("the transaction appears in the swap history")
	public void the_transaction_appears_in_the_swap_history() {
		driver.findElement(By.id("nav-history")).click();
		String transaction = driver.findElement(By.xpath("//td[contains(text(),'USDT to BTC')]")).getText();
		Assert.assertTrue(transaction.contains("USDT to BTC"));
	}
	

		
		

		@Then("the system displays minimum limit error message")
		public void the_system_displays_minimum_limit_error_message() {
			 WebElement errorMessage = driver.findElement(By.id("error-message"));
			    Assert.assertEquals("Minimum swap limit not met", errorMessage.getText());
		}
}
