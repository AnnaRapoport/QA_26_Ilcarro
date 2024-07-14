package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        pause(1000);
        click(By.xpath("//*[.=' Log in ']"));

    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }
    public void fillLoginForm(User user) {
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
    }

    public void submit() {
        click(By.xpath("//button[@type='submit']"));
    }

    public String getErrorText() {
        pause(1000);
        String res=  wd.findElement(By.cssSelector("div.error")).getText();
        System.out.println(res);
        return res;
    }
    public String getMessage() {
        pause(10000);
        return wd.findElement(By.className("message")).getText();
        //        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
//                String text = element.getText();
//                return text;


    }
    public boolean isYallaButtonNotActive(){
        boolean res =  isElementPresent(By.cssSelector("button[disabled]"));

        WebElement element= wd.findElement(By.cssSelector("button[type='submit']"));
        boolean result =element.isEnabled();
        return res && !result;
    }


    public void submitOk() {
        if (isElementPresent(By.xpath("//button[@type='button']"))){
            click(By.xpath("//button[@type='button']"));
        }
    }

    public void logout() {
          click(By.xpath("//*[.=' Logout ']"));
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));

    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"),user.getName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public void openRegistrationForm() {
        click(By.xpath("//*[.=' Sign up ']"));
    }

    public void checkBox() {
        //click(By.xpath("//*[@id='terms-of-use']"));
       // click(By.cssSelector("label[for='terms-of-use']"));

        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.getElementById('terms-of-use').click()");
    }
}