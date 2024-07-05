package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase  {
@BeforeMethod
public void precondition(){
    if(app.getHelperUser().isLoggedIn()){
        app.getHelperUser().logout();

    }
}
@Test
    public void loginSuccess() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("cola@mail.ru", "Aa12345$");
        app.getHelperUser().buttonYalla();
        Assert.assertTrue(app.getHelperUser().isLoggedIn());
        app.getHelperUser().submitOk();
        Assert.assertTrue(app.getHelperUser().isLogOut());
    }
    @Test
    public void loginSuccessModel(){
app.getHelperUser().openLoginForm();
app.getHelperUser().fillLoginForm("cola@mail.ru","Aa12345$");
app.getHelperUser().buttonYalla();
        Assert.assertTrue(app.getHelperUser().isLoggedIn());
        app.getHelperUser().submitOk();
        Assert.assertTrue(app.getHelperUser().isLogOut());

    }
}
