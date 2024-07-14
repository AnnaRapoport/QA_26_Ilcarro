package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLoggedIn()) {
            app.getHelperUser().logout();
        }
    }


    @Test
    public void registrationValid() {
        int i = new Random().nextInt(1000)+1000;
        System.out.println(i);
        System.out.println(System.currentTimeMillis());
        int z= (int)((System.currentTimeMillis()/1000)%3600);

        User user= new User()
                .setName("Alice")
                .setLastName("Snow")
                .setEmail("ali"+z+"@mail.ru")
                .setPassword("Aa12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkBox();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");
    }
    @Test
    public void registrationWrongEmail() {
        int i = new Random().nextInt(1000)+1000;
        System.out.println(i);
        System.out.println(System.currentTimeMillis());
        int z= (int)((System.currentTimeMillis()/1000)%3600);

        User user= new User()
                .setName("Alice")
                .setLastName("Snow")
                .setEmail("ali"+z+"mail.ru")
                .setPassword("Aa12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkBox();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Wrong email format\n" + "Wrong email format");

    }
    @Test
    public void registrationWrongPassword() {
        int i = new Random().nextInt(1000)+1000;
        System.out.println(i);
        System.out.println(System.currentTimeMillis());
        int z= (int)((System.currentTimeMillis()/1000)%3600);

        User user= new User()
                .setName("Alice")
                .setLastName("Snow")
                .setEmail("ali"+z+"@gmail.com")
                .setPassword("Aa12345");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkBox();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password must contain minimum 8 symbols\n" + "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
    }
    @Test
    public void registrationEmptyName() {
        int i = new Random().nextInt(1000) + 1000;
        System.out.println(i);
        System.out.println(System.currentTimeMillis());
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);

        User user = new User()
                .setName("")
                .setLastName("Snow")
                .setEmail("ali" + z + "@gmail.com")
                .setPassword("Aa12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkBox();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Name is required");
    }
    @Test
    public void registrationExistUser() {
        int i = new Random().nextInt(1000) + 1000;
        System.out.println(i);
        System.out.println(System.currentTimeMillis());
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);

        User user = new User()
                .setName("Anna")
                .setLastName("Rapoport")
                .setEmail("cola@gmail.com")
                .setPassword("Aa12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkBox();
        app.getHelperUser().submit();
        // Assert.assertEquals(app.getHelperUser().getErrorText(), "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"User already exists\"");
    }


    @AfterMethod
    public void postCondition() {
        app.getHelperUser().submitOk();
    }
}
