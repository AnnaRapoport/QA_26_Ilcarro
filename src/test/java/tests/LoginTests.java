package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase  {

    @Test
    public void loginSuccess(){
app.getHelperUser().openLoginForm();
app.getHelperUser().fillLoginForm("cola@mail.ru","Aa12345$");
app.getHelperUser().buttonYalla();
        Assert.assertTrue(app.getHelperUser().isLoggedIn());

    }
}
