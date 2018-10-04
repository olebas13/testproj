package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;

@DefaultUrl("https://www.spotify.com/int/signup")
public class SignUpPage extends PageObject {

    private By emailField = By.cssSelector("#register-email");
    private By confirmEmailField = By.cssSelector("#register-confirm-email");
    private By passwordField = By.cssSelector("#register-password");
    private By nameField = By.cssSelector("#register-displayname");
    private By monthDropDown = By.cssSelector("#register-dob-month");
    private String monthDropDownOption = "//select[@id='register-dob-month']/option[text()='%s']";
    private By dayField = By.cssSelector("#register-dob-day");
    private By yearField = By.cssSelector("#register-dob-year");
    private String sexRadioButton = "//li[@id='li-gender']//label[normalize-space()='Male']/input";
    private By shareCheckbox = By.cssSelector("#register-thirdparty");
    private By registerButton = By.cssSelector("a#register-button-email-submit");
    private String errorByText = "//label[@class=\"has-error\" and text()=\"%s\"]";
    By errorLabel = By.xpath("//label[@class='has-error' and string-length(text())>0]");

    public SignUpPage typeEmail(String email) {
        find(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String confirmEmail) {
        find(confirmEmailField).sendKeys(confirmEmail);
        return this;
    }

    public SignUpPage typePassword(String password) {
        find(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeName(String name) {
        find(nameField).sendKeys(name);
        return this;
    }

    public SignUpPage setMonth(String month) {
        find(monthDropDown).click();
        find(By.xpath(format(monthDropDownOption, month))).waitUntilVisible().click();
        return this;
    }

    public SignUpPage typeDay(String day) {
        find(dayField).sendKeys(day);
        return this;
    }

    public SignUpPage typeYear(String year) {
        find(yearField).sendKeys(year);
        return this;
    }

    public SignUpPage setSex(String value) {
        find(By.xpath(format(sexRadioButton, value))).click();
        return this;
    }

    public SignUpPage setShare(boolean value) {
        WebElement checkbox = find(shareCheckbox);
        if (!checkbox.isSelected() == value) {
            checkbox.click();
        }
        return this;
    }

    public void clickSignUpButton() {
        find(registerButton).click();
    }

    public List<WebElementFacade> getErrors() {
        return findAll(errorLabel);
    }

    public String getErrorByNumber(int number) {
        return getErrors().get(number - 1).getText();
    }

    public boolean isErrorVisible(String message) {
        return findAll(By.xpath(format(errorByText, message))).size() > 0
                && findAll(By.xpath(format(errorByText, message))).get(0).isDisplayed();
    }

}
