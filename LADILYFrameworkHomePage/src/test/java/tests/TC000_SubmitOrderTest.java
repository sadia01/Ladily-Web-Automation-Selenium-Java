package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import drivers.BaseDriver;
import drivers.PageDriver;
import pages.P002_SignUpNavigationPage;
import pages.P003_CreateAccountPage;
import pages.P004_CreateAccountSuccessPage;
import pages.P005_AddProductToCartPage;
import pages.P006_CheckoutProductPage;
import pages.P008_OrderConfirmationPage;

public class TC000_SubmitOrderTest extends BaseDriver {
	
	@BeforeClass
	public void startURL() {
		
		PageDriver.getCurrentDriver().get(baseURL);
		PageDriver.getCurrentDriver().manage().window().maximize();
	}
	
	@Test
	public void submitOrder() throws InterruptedException {

		P002_SignUpNavigationPage navigationPage = new P002_SignUpNavigationPage();
		navigationPage.navigateToLoginPage();
		navigationPage.navigateToSignUpPage();
		
		P003_CreateAccountPage createAccountPage = new P003_CreateAccountPage();
		createAccountPage.fillCreateAccountForm();
		
		P004_CreateAccountSuccessPage successPage = new P004_CreateAccountSuccessPage();
		successPage.clickContinueShopping();
		
		P005_AddProductToCartPage addProductToCartPage = new P005_AddProductToCartPage();
		addProductToCartPage.addProductToCart();
		addProductToCartPage.deleteCartItem();
		

		P006_CheckoutProductPage checkoutProductPage = new P006_CheckoutProductPage();
		checkoutProductPage.checkoutProduct();
		
		P008_OrderConfirmationPage orderConfirmationPage = new P008_OrderConfirmationPage();

		String confirmationMessage = orderConfirmationPage.getConfirmationMessage();
		Assert.assertEquals(confirmationMessage, "Your order has been successfully processed!");

		orderConfirmationPage.clickOrderDetailsPageLink();
		orderConfirmationPage.clickOrderList();
		orderConfirmationPage.logout();


	}

}
