import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    private WebDriver webDriver;
    private String path;
   
    @BeforeEach
    public void setUp() {
        
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");//linux_64

        // Get file
        File file = new File("src/main/java/com/revature/index.html");
        path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);

        // Open the HTML file
        webDriver.get(path);
    }
    
    @AfterEach
    void teardown() {
        webDriver.quit();
    }

 @Test
    public void testHelloWorldMessage() {
       
        webDriver.get(path);
        WebElement outputElement = webDriver.findElement(By.id("output"));
        String actualMessage = outputElement.getText();
        webDriver.quit();
        String expectedMessage = "Hello, World!";
        Assertions.assertEquals(expectedMessage, actualMessage, "Message mismatch");

}

}


  
