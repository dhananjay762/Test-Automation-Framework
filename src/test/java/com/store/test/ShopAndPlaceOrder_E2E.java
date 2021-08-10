package com.store.test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.store.pages.CartPage;
import com.store.pages.HomePage;
import com.store.pages.ShoppingPage;
import com.store.pages.SignInPage;
import com.store.utility.Keywords;

public class ShopAndPlaceOrder_E2E extends Keywords{
	
	HomePage home = new HomePage();
	SignInPage sign = new SignInPage();
	ShoppingPage shop = new ShoppingPage();
	CartPage cart = new CartPage();
	
	@BeforeClass
	@Parameters("browser")
	public void start(String browser) {
		setup(browser);
		navigateToURL(TEST_URL);
	}
	
	@Test
	public void login() {
		home.goToLogin();
		sign.enterCredentials("johntestsmith01@gmail.com", "pass=54321");
		sign.clickSignIn();
	}
	
	@Test(dependsOnMethods = {"login"})
	public void chooseProduct() {
		home.selectDressesMenu();
		shop.clickOnCasualDressMenu();
		shop.clickOnMoreForProduct();
	}
	
	@Test(dependsOnMethods = {"chooseProduct"})
	public void placeOrder() {
		shop.chooseQuantity(3);
		shop.selectSize("M");
		shop.addToCart();
		shop.doCheckout();
		
	}
	
	@Test(dependsOnMethods = {"placeOrder"})
	public void checkout() {
		cart.proceedToCheckout();
		cart.proceedToCheckout();
		cart.acceptTermsOfCondition();
		cart.proceedToCheckout();
		cart.paymentByCheque();
		cart.confirmMyOrder();
		cart.verifySuccessMessage("Your order on My Store is complete.");
	}
	
	@Test(dependsOnMethods = {"checkout"})
	public void logout() {
		home.signOut();
	}

	@AfterClass
	public void close() {
		closeBrowser();
	}

}
