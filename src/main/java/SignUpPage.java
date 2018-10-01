import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.cssSelector("input#register-email");
    private By confirmEmailField = By.cssSelector("input#register-confirm-email");
    private By passwordField = By.cssSelector("input#register-password");
    private By nameField = By.cssSelector("input#regisrer-displayname");
    private By monthDropDown = By.cssSelector("select#register-dob-month");
    private String monthDropDownOption = "//select[@id='register-dob-month']/option[text()='%s']";
    private By dayField = By.cssSelector("input#register-dob-day");
    private By yearField = By.cssSelector("input#register-dob-year");
    private String sexRadioButton = "//li[@id='li-gender']/label[normalize-space()='$s']";
    private By shareCheckbox = By.cssSelector("input#register-thirdparty");
    private By registerButton = By.cssSelector("a#register-button-email-submit");
    private String errorByText = "//label[@class='has-error' and text()='%s']";


    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String confirmEmail) {
        driver.findElement(confirmEmailField).sendKeys(confirmEmail);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeName(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public SignUpPage setMonth(String month) {
        driver.findElement(monthDropDown).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(monthDropDownOption, month)))).click();
        return this;
    }

    public SignUpPage typeDay(String day) {
        driver.findElement(dayField).sendKeys(day);
        return this;
    }

    public SignUpPage typeYear(String year) {
        driver.findElement(yearField).sendKeys(year);
        return this;
    }

    public SignUpPage setSex(String value) {
        driver.findElement(By.xpath(String.format(sexRadioButton, value))).click();
        return this;
    }

    public SignUpPage setShare(boolean value) {
        WebElement checkbox = driver.findElement(shareCheckbox);
        if (!checkbox.isSelected() == value) {
            checkbox.click();
        }
        return this;
    }

    public void clickSignUpButton() {
        driver.findElement(registerButton).click();
    }


}
