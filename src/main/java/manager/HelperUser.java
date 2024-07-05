package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }
  public void openLoginForm(){
       click(By.xpath("//*[.=' Log in ']"));

  }
public void fillLoginForm(String email,String password){
        type(By.xpath("//input[@id='email']"),email);
        type(By.xpath("//input[@id='password']"),password);
}
public void buttonYalla(){
        click(By.xpath("//button[@type='submit']"));
}
    public boolean isLoggedIn(){
        return isElementPresent(By.xpath("//h2[@class='message']"));
}

public void submitOk(){
   click(By.xpath("//button[@type='button']"));
}
public boolean isLogOut(){
        return isElementPresent(By.xpath("//*[.=' Logout ']"));
}
public void logout(){
        click(By.xpath("//*[.=' Logout ']"));
}
    }
