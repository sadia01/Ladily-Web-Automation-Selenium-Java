package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class P006_SelectProductPage extends CommonMethods {
	
	public P006_SelectProductPage() {
		
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(xpath = "(//li[@class='item mb-2'])[3]")
    WebElement ratingElement;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCartButton;
    
    public void selectRating() throws InterruptedException {
    	
        scrollTheWindow(0, 500);
        scrollToElement(ratingElement); 
        hoverClickElement(ratingElement); 
        timeOut(5000); 
    }

    public void selectProduct() throws InterruptedException {
        scrollToElement(addToCartButton); 
        hoverClickElement(addToCartButton); 
        timeOut(6000); 
    }
}
