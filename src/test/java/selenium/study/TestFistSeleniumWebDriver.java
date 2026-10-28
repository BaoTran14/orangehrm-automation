package selenium.study;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestFistSeleniumWebDriver {
    public static void main(String[] args) {
        // Version < 4.1.0 (not sure), manage webdriver version manually
//        System.setProperty("webdriver.chrome.driver", "src/test/resouces/drivers/chromedriver.exe");
//        System.setProperty("webdriver.edge.driver", "src/test/resouces/drivers/msedgedriver.exe");
//        ChromeDriver chromeDriver = new ChromeDriver(); // Open browser(chrome)
//        chromeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // Access website address (google)
//        chromeDriver.quit();
//        EdgeDriver edgeDriver = new EdgeDriver();
//        edgeDriver.get("https://www.google.com/");
        // Version < 4.1.0 (not sure), manage webdriver version automatically using WebDriverManage lib
//        WebDriverManager.chromedriver().setup();
//        ChromeDriver chromeDriver = new ChromeDriver();
//        chromeDriver.get("https://www.google.com/"); // Access website address (google)
        // Using version >= 4.1.0, automatically manage web driver version without extra WebDriverManger lib in pom
        ChromeDriver chromeDriver = new ChromeDriver(); //chromeDriver called session
//        ChromeDriver chromeDriver_1 = new ChromeDriver(); //chromeDriver_1 called session
//        chromeDriver.get("https://www.google.com/"); // Access website address (google)

        // Set browser window size
        chromeDriver.manage().window().maximize();
//        String tab_1 = chromeDriver.getWindowHandle();

        // Handle tabs & window
//        chromeDriver.switchTo().newWindow(WindowType.TAB); // Open new empty tab & focus to new tab
//        chromeDriver.get("https://www.google.com/");
//        chromeDriver.close();
//        chromeDriver.switchTo().newWindow(WindowType.WINDOW); // Open new window but still in same session
//        chromeDriver.get("https://www.google.com/");
        chromeDriver.switchTo().newWindow(WindowType.TAB);
        chromeDriver.get("https://www.bing.com/");
        System.out.println(chromeDriver.getTitle() + " at tab " + chromeDriver.getWindowHandle());
        String currentURL = chromeDriver.getCurrentUrl();
        System.out.println("current url " + currentURL);
        // Take screenshot
        File screenshoot = chromeDriver.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshoot, new File("./screenshot/image.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Get all opened/active tab
        List<String> activeWindowList = new ArrayList<>(chromeDriver.getWindowHandles());
        System.out.println("All tabs/widnow" + activeWindowList);
        // Switch between tab
        chromeDriver.switchTo().window(activeWindowList.getFirst());
//        chromeDriver.switchTo().window(tab_1);
        chromeDriver.get("https://www.google.com/");
        System.out.println(chromeDriver.getTitle() + " at tab" + chromeDriver.getWindowHandle());
//        chromeDriver.quit();

        // Get current url
        currentURL = chromeDriver.getCurrentUrl();
        System.out.println("current url " + currentURL);

        // Get page source
        String pageSource = chromeDriver.getPageSource();
        System.out.println("Page source is \n" + pageSource);

        //Navigate feature
        chromeDriver.navigate().to("https://github.com/");
        chromeDriver.navigate().back();
        chromeDriver.navigate().forward();
        chromeDriver.navigate().refresh();

        // Take full screenshot with external lib AShot
        Screenshot shot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(500))
                .takeScreenshot(chromeDriver);
        try {
            ImageIO.write(shot.getImage(), "JPG", new File("./screenshot/full_page.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}