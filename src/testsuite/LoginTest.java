package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter username
        WebElement Username = driver.findElement(By.name("username"));
        Username.sendKeys("Admin");


        //Enter password
        WebElement Password = driver.findElement(By.name("password"));
        Password.sendKeys("admin123");
        //Click on 'LOGIN' button
         driver.findElement(By.className("orangehrm-login-button")).click();
         //Verify the ‘Dashboard’ text is display
        String expectedMessage = "Dashboard";
        WebElement actualTextElement = driver.findElement(By.xpath("//h6"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Not redirected to Login page", expectedMessage, actualText);
    }

        @After
        public void tearDown(){
            closeBrowser();
    }
}

