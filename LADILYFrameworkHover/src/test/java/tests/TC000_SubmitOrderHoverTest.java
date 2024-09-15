package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import drivers.BaseDriver;
import drivers.PageDriver;
import pages.P002_SignUpNavigationPage;
import pages.P003_CreateAccountPage;
import pages.P004_CreateAccountSuccessPage;
import pages.P005_HoverCategoriesPage;
import pages.P006_SelectProductPage;
import pages.P007_AddProductToCartPage;
import pages.P008_CheckoutProductPage;
import pages.P009_OrderConfirmationPage;

public class TC000_SubmitOrderHoverTest extends BaseDriver {
	
	@BeforeClass
	public void startURL() {
		
		PageDriver.getCurrentDriver().get(baseURL);
		PageDriver.getCurrentDriver().manage().window().maximize();
	}
	
	@Test
	public void submitOrderHover() throws InterruptedException {

		P002_SignUpNavigationPage navigationPage = new P002_SignUpNavigationPage();
		navigationPage.navigateToLoginPage();
		navigationPage.navigateToSignUpPage();
		
		P003_CreateAccountPage createAccountPage = new P003_CreateAccountPage();
		createAccountPage.fillCreateAccountForm();
		
        P004_CreateAccountSuccessPage successPage = new P004_CreateAccountSuccessPage();
        successPage.clickContinueShopping();
        
		P005_HoverCategoriesPage categoriesPage = new P005_HoverCategoriesPage();

		categoriesPage.hoverOverAllCategories();
		categoriesPage.hoverOverSubMenu();
		categoriesPage.hoverOverSubSelectMenu();
		categoriesPage.selectMenu();
		
        P006_SelectProductPage selectProductPage = new P006_SelectProductPage();
        selectProductPage.selectRating();
        selectProductPage.selectProduct();
        
		P007_AddProductToCartPage addProductToCartPage = new P007_AddProductToCartPage();
		addProductToCartPage.addProductToCart();
		
		P008_CheckoutProductPage checkoutProductPage = new P008_CheckoutProductPage();
		checkoutProductPage.checkoutProduct();
		
		P009_OrderConfirmationPage orderConfirmationPage = new P009_OrderConfirmationPage();
		String confirmationMessage = orderConfirmationPage.getConfirmationMessage();
		Assert.assertEquals(confirmationMessage, "Your order has been successfully processed!");

		orderConfirmationPage.clickOrderDetailsPageLink();
		orderConfirmationPage.clickOrderList();
		orderConfirmationPage.logout();
		
		

	}

}
