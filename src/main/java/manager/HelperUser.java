package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//*[.=' Log in ']"));

    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }

    public void buttonYalla() {
        click(By.xpath("//button[@type='submit']"));
    }

    public String getMessage() {
        pause(1000);
        return wd.findElement(By.xpath("//div[@class='error']")).getText();
    }
    public String getMessage1() {
        pause(1000);
       WebElement string= wd.findElement(By.xpath("//h1[@class='title']"));
       String message = string.getText();
        System.out.println(message);
       return message;

    }


    public void submitOk() {
        click(By.xpath("//button[@type='button']"));
    }

    public void logout() {
        click(By.xpath("//*[.=' Logout ']"));
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));

    }
}