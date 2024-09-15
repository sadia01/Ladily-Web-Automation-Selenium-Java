package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class P005_HoverCategoriesPage extends CommonMethods {
	

	public P005_HoverCategoriesPage() {
		
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	
	@FindBy(css = "#all-cat-btn")
    WebElement allCategoriesButton;

    @FindBy(xpath = "(//a[@class='flex-grow-1'][normalize-space()='Skin Care'])[1]")
    WebElement subMenuOption;

    @FindBy(xpath = "(//a[@class='flex-grow-1'][normalize-space()='Cleansers'])[1]")
    WebElement subSelectMenuOption;

    @FindBy(xpath = "(//a[@class='flex-grow-1'][normalize-space()='Face Wash'])[1]")
    WebElement selectMenuOption;
    
    public void hoverOverAllCategories() throws InterruptedException {
    	hoverElement(allCategoriesButton); 
        timeOut(1000); 
    }

    public void hoverOverSubMenu() throws InterruptedException {
    	hoverElement(subMenuOption); 
        timeOut(1000); 
    }

    public void hoverOverSubSelectMenu() throws InterruptedException {
    	hoverElement(subSelectMenuOption); 
        timeOut(1000); 
    }

    public void selectMenu() throws InterruptedException {
        hoverClickElement(selectMenuOption);
        timeOut(); 
    }

}
