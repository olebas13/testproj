import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class SignUpTest extends BaseTest {

    SignUpPage page = new SignUpPage();

    @Test
    public void typeInvalidYear() {
        page
                .open()
                .setMonth("May")
                .typeDay("20")
                .typeYear("84")
                .setShare(true);
        page.getError("Please enter a valid year.").shouldBe(visible);
        page.getError("When were you born.").shouldNotBe(visible);
    }

    @Test
    public void typeInvalidEmail() {
        page
                .open()
                .typeEmail("test@mail.test")
                .typeConfirmEmail("wrong@mail.test")
                .typeName("TestName")
                .clickSignUpButton();
        page.getError("Email address doesn't match.").shouldBe(visible);
    }

    @Test
    public void signUpWithEmptyPassword() {
        page
                .open()
                .typeEmail("test@mail.test")
                .typeConfirmEmail("test@mail.test")
                .typeName("TestName")
                .clickSignUpButton();
        page.getError("Please choose a password.").shouldBe(visible);
    }

    @Test
    public void typeInvalidValues() {
        page
                .open()
                .typeEmail("rghsdfg")
                .typeConfirmEmail("wrong@test.mail")
                .typePassword("1234/-/-")
                .typeName("Name")
                .setSex("Male")
                .setShare(false)
                .clickSignUpButton();
        page.getErrors().shouldHave(size(6));
        page.getErrorByNumber(3).shouldHave(text("Please enter your birth month."));
    }
}
