package selenium.study;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssXpathExamples {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        WebElement username = chromeDriver.findElement(By.xpath("//input[@name=\"username\"]"));
        WebElement password = chromeDriver.findElement(By.xpath("//input[@name=\"password\"]"));
//        WebElement username = chromeDriver.findElement(By.cssSelector("input[name=\"username\"]"));
//        WebElement password = chromeDriver.findElement(By.cssSelector("input[name='password']"));
        username.sendKeys("Admin");
        password.sendKeys("admin","1","2","3");
    }
}