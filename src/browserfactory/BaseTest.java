package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        //Open URL
        driver.get(baseUrl);
        //Maximize the window
        driver.manage().window().maximize();
        //Time out for hold the page
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));

    }
    public void closeBrowser(){
        driver.quit();
    }
}


