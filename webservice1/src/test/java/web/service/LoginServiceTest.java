package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginServiceTest {
	
	private WebDriver driver;
    
    private void setupWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("C:\\Users\\ADEEPTHA HETTI\\Downloads\\ASHAN\\Deelaka Rathnayake\\selenium\\SIT707-Software Quality & Testing\\8.1P-resources\\8.1P-resources - D\\pages\\login.html"); 
    }
    
    private void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }

    private void performLogin(String username, String password, String dob) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("passwd"));
        WebElement dobField = driver.findElement(By.id("dob"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        dobField.clear();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + dob + "';", dobField);
        submitButton.click();
    }
    
    @Test
    public void testValidLogin() {
        setupWebDriver();
        performLogin("ahsan", "ahsan_pass", "1990-01-10");
        Assert.assertEquals("Login Success", driver.getTitle());
        tearDown();
    }

    @Test
    public void testInvalidUsername() {
        setupWebDriver();
        performLogin("wrongUser", "ahsan_pass", "1990-01-10");
        Assert.assertEquals("Login Fail", driver.getTitle());
        tearDown();
    }

    @Test
    public void testInvalidPassword() {
        setupWebDriver();
        performLogin("ahsan", "wrongPass", "1990-01-10");
        Assert.assertEquals("Login Fail", driver.getTitle());
        tearDown();
    }

    @Test
    public void testInvalidDOB() {
        setupWebDriver();
        performLogin("ahsan", "ahsan_pass", "2000-01-01");
        Assert.assertEquals("Login Fail", driver.getTitle());
        tearDown();
    }

    @Test
    public void testEmptyUsername() {
        setupWebDriver();
        performLogin("", "ahsan_pass", "1990-01-10");
        Assert.assertEquals("Login Fail", driver.getTitle());
        tearDown();
    }

    @Test
    public void testAllFieldsEmpty() {
        setupWebDriver();
        performLogin("", "", "");
        Assert.assertEquals("Login Fail", driver.getTitle());
        tearDown();
    }

    @Test
    public void testBoundaryUsername() {
        setupWebDriver();
        performLogin("ahs", "ahsan_pass", "1990-01-10"); // "ahs" is not a valid username in the database
        Assert.assertEquals("Login Fail", driver.getTitle());
        tearDown();
    }
}

