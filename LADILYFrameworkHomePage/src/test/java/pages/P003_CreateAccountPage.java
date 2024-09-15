package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utilities.CommonMethods;

public class P003_CreateAccountPage extends CommonMethods {

	public P003_CreateAccountPage() {

		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindAll({

			@FindBy(id = "FirstName") })
	WebElement firstNameInput;

	@FindAll({

			@FindBy(name = "LastName") })
	WebElement lastNameInput;

	@FindAll({

			@FindBy(css = "#Email") })
	WebElement emailInput;

	@FindAll({

			@FindBy(css = "#Phone") })
	WebElement phoneInput;

	@FindAll({

			@FindBy(xpath = "//input[@name='Password']") })
	WebElement passwordInput;

	@FindAll({

			@FindBy(css = "svg[id='registration-icon-toggle']") })
	WebElement passwordEyeIcon;

	@FindAll({

			@FindBy(css = "input[name='ConfirmPassword']") })
	WebElement confirmPasswordInput;

	@FindAll({

			@FindBy(css = "svg[id='registration-confirm-icon-toggle']") })
	WebElement confirmPasswordEyeIcon;

	@FindAll({

			@FindBy(xpath = "//button[@name='register-button']") })
	WebElement registerButton;
	
	@FindBy(css = "//li[normalize-space()='The specified email already exists']")
	WebElement emailExistMessage;



	public void fillCreateAccountForm() throws InterruptedException {

		sendText(firstNameInput, firstNameGenerate());
		sendText(lastNameInput, lastNameGenerate());
		sendText(emailInput, emailGenerate());
		scrollTheWindow(0, 500);
		timeOut();

		sendText(phoneInput, bdPhoneNumberGenerate());
		sendText(passwordInput, "sadia1234");
		passwordEyeIcon.click();
		timeOut(2000);
		sendText(confirmPasswordInput, "sadia1234");
		confirmPasswordEyeIcon.click();
		timeOut(2000);
		hoverClickElement(registerButton);
		timeOut();

	}
	
    public String getEmailExistMessage() {
    	
        return emailExistMessage.getText();
    }

}
