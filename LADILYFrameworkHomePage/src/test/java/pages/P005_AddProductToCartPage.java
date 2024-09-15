package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class P005_AddProductToCartPage extends CommonMethods {
	
	public P005_AddProductToCartPage() {
		
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	
    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Add to cart'])[1]")
    WebElement addToCartPageButton;
    
    @FindBy(xpath = "//label[normalize-space()='60 ml']")
    WebElement productSize;
    
    @FindBy(css = "#add-to-cart-button-2")
    WebElement addToCartButton;
    
    @FindBy(xpath = "(//button[@id='continueshopping'])[1]")
    WebElement goToContinueShoppingButton;
    
    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Add to cart'])[5]")
    WebElement addToCartMoreButton;
    
    @FindBy(xpath = "(//button[@class='button-flat text-white continue-shopping-button'])[3]")
    WebElement goToCartMoreButton;
    
    @FindBy(xpath = " //tbody/tr[1]/td[5]")
    WebElement deleteCartItemButton;
    
 
    
    
    
//    @FindBy(xpath = "(//button[@class='button-flat text-white continue-shopping-button'])[1]")
//    WebElement goToCartButton;
    
    
    
    public void addProductToCart() throws InterruptedException {
    	
    	scrollTheWindow(0,900);
    	scrollToElement(addToCartPageButton);
    	hoverClickElement(addToCartPageButton); 
        timeOut(3000); 
        
        waitUntilElementVisible(productSize);
        scrollToElement(productSize);
        hoverClickElement(productSize); 
        timeOut(2000); 

        scrollToElement(addToCartButton);
        hoverClickElement(addToCartButton); 
        timeOut();
        
        hoverClickElement(goToContinueShoppingButton); 
        timeOut(5000); 
        
        scrollToElement(addToCartMoreButton);
        hoverClickElement(addToCartMoreButton); 
        timeOut();
        
        hoverClickElement(goToCartMoreButton); 
        timeOut(5000);
        
        

//        hoverClickElement(goToCartButton); 
//        timeOut(5000); 

    }
    
    public void deleteCartItem() {
    	
    	hoverClickElement(deleteCartItemButton);
    	timeOut(3000);
    }

}
