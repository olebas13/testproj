import org.junit.Assert;
import org.junit.Test;

public class SignUpTest extends BaseTest {

    SignUpPage page = new SignUpPage(driver);

    @Test
    public void typeInvalidYear() {
        page
                .setMonth("May")
                .typeDay("20")
                .typeYear("84")
                .setShare(true);

        Assert.assertTrue(page.isErrorVisible("Please enter a valid year."));
        Assert.assertFalse(page.isErrorVisible("When were you born?"));
    }

    @Test
    public void typeInvalidEmail() {
        page
                .typeEmail("test@mail.test")
                .typeConfirmEmail("wrong@mail.test")
                .typeName("TestName")
                .clickSignUpButton();
        Assert.assertTrue(page.isErrorVisible("Email address doesn't match."));
    }

    @Test
    public void signUpWithEmptyPassword() {
        page
                .typeEmail("test@mail.test")
                .typeConfirmEmail("test@mail.test")
                .typeName("TestName")
                .clickSignUpButton();
        Assert.assertTrue(page.isErrorVisible("Please choose a password."));
    }

    @Test
    public void typeInvalidValues() {
        page
                .typeEmail("rghsdfg")
                .typeConfirmEmail("wrong@test.mail")
                .typePassword("1234/-/-")
                .typeName("Name")
                .setSex("Male")
                .setShare(false)
                .clickSignUpButton();
        Assert.assertEquals(6, page.getErrors().size());
        Assert.assertEquals("Please enter your birth month.", page.getErrorByNumber(3));
    }
}
