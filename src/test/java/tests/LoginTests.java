package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");//Logged in


    }
    @Test
    public void loginSuccess1() {
        User user =new User().setEmail("cola@mail.ru").setPassword("Aa12345$");
//        user.setEmail("cola@mail.ru");
//        user.setPassword("Aa12345$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");//Logged in


    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("cola@mail.ru", "Aa12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");//Logged in

    }

    @Test
    public void loginWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("colamail.ru", "Aa12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue( app.getHelperUser().isYallaButtonNotActive());


    }

//    @Test
//    public void loginEmptyPassword() {
//        app.getHelperUser().openLoginForm();
//        app.getHelperUser().fillLoginForm("cola@mail.ru", "");
//        app.getHelperUser().buttonYalla();
//        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password is required");
//        Assert.assertTrue( app.getHelperUser().isYallaButtonNotActive());
//    }

    @Test
    public void loginWrongPassword() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("cola@mail.ru", "Aa123");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "\"Login or Password incorrect\"");//Login failed


    }

    @Test
    public void loginUnregUser() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("fanta@mail.ru", "Aa12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "\"Login or Password incorrect\"");// Login failed

}
@AfterTest
    public void afterTest() {
        app.getHelperUser().submitOk();
    }
    }
