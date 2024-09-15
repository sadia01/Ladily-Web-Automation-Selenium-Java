package tests;

import org.testng.Assert;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import drivers.BaseDriver;
import drivers.PageDriver;
import pages.P001_LogInPage;
import pages.P005_AddProductToCartPage;
import pages.P007_CheckoutProductLoginPage;
import pages.P008_OrderConfirmationPage;

public class TC001_LogInTest extends BaseDriver {

	@BeforeClass
	public void startURL() {
		
		PageDriver.getCurrentDriver().get(baseURL);
		PageDriver.getCurrentDriver().manage().window().maximize();
	}
	
	@Test
	public void loginSubmitOrder() throws InterruptedException {

		P001_LogInPage loginPage = new P001_LogInPage();
		loginPage.navigateToLoginPage();
		loginPage.fillLoginDetails();
		
		P005_AddProductToCartPage addProductToCartPage = new P005_AddProductToCartPage();
		addProductToCartPage.addProductToCart();
		addProductToCartPage.deleteCartItem();
		

		P007_CheckoutProductLoginPage checkoutProductLoginPage = new P007_CheckoutProductLoginPage();
		checkoutProductLoginPage.checkoutProduct();
		
		P008_OrderConfirmationPage orderConfirmationPage = new P008_OrderConfirmationPage();

		String confirmationMessage = orderConfirmationPage.getConfirmationMessage();
		Assert.assertEquals(confirmationMessage, "Your order has been successfully processed!");

		orderConfirmationPage.clickOrderDetailsPageLink();
		orderConfirmationPage.clickOrderList();
		orderConfirmationPage.logout();


	}

}
