package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLoggedIn()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("cola@mail.ru", "Aa12345$");
        app.getHelperUser().buttonYalla();
        Assert.assertEquals(app.getHelperUser().getMessage1(), "Logged in success");
        app.getHelperUser().submitOk();

    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("cola@mail.ru", "Aa12345$");
        app.getHelperUser().buttonYalla();
        Assert.assertEquals(app.getHelperUser().getMessage1(), "Logged in success");
        app.getHelperUser().submitOk();

    }

    @Test
    public void loginWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("colamail.ru", "Aa12345$");
        app.getHelperUser().buttonYalla();
        Assert.assertEquals(app.getHelperUser().getMessage(), "It'snot look like email");


    }

    @Test
    public void loginEmptyPassword() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("cola@mail.ru", "");
        app.getHelperUser().buttonYalla();
        Assert.assertEquals(app.getHelperUser().getMessage(), " Password is required ");

    }

    @Test
    public void loginUnregUser() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("fanta@mail.ru", "Aa12345$");
        app.getHelperUser().buttonYalla();
        Assert.assertEquals(app.getHelperUser().getMessage1(), "Login or Password incorrect");
        app.getHelperUser().submitOk();
}
    }
