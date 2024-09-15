package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class P007_AddProductToCartPage extends CommonMethods{
	
	public P007_AddProductToCartPage() {
		
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	
    @FindBy(css = "li[data-attr-value='44']")
    WebElement productSize;

    @FindBy(css = "#add-to-cart-button-27")
    WebElement addToCartButton;

    @FindBy(xpath = "(//button[@class='button-flat text-white continue-shopping-button'])[1]")
    WebElement goToCartButton;
    
    public void addProductToCart() throws InterruptedException {
    	
        waitUntilElementVisible(productSize); 
        hoverClickElement(productSize); 
        timeOut(2000); 

        hoverClickElement(addToCartButton); 
        timeOut();

        hoverClickElement(goToCartButton); 
        timeOut(5000); 
    }

}
