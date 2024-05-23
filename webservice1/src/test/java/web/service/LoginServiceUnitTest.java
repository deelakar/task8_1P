package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {
    
    private void sleep(long sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during sleep: " + e.getMessage());
        }
    }
    
    @Test
    public void testLoginSuccess() {
        System.out.println("Testing login with correct credentials.");
        boolean result = LoginService.login("ahsan", "ahsan_pass", "1990-01-10");
        Assert.assertTrue("Login should be successful", result);
        sleep(1);  // Simulating time delay as in Selenium setup
    }
    
    @Test
    public void testLoginFailureInvalidUsername() {
        System.out.println("Testing login with incorrect username.");
        boolean result = LoginService.login("incorrectUser", "ahsan_pass", "1990-01-10");
        Assert.assertFalse("Login should fail due to invalid username", result);
        sleep(1);  // Simulating time delay
    }

    @Test
    public void testLoginFailureInvalidPassword() {
        System.out.println("Testing login with incorrect password.");
        boolean result = LoginService.login("ahsan", "wrongPass", "1990-01-10");
        Assert.assertFalse("Login should fail due to incorrect password", result);
        sleep(1);  // Simulating time delay
    }

    @Test
    public void testLoginFailureInvalidDOB() {
        System.out.println("Testing login with incorrect DOB.");
        boolean result = LoginService.login("ahsan", "ahsan_pass", "2000-01-01");
        Assert.assertFalse("Login should fail due to incorrect date of birth", result);
        sleep(1);  // Simulating time delay
    }

    @Test
    public void testLoginWithEmptyFields() {
        System.out.println("Testing login with empty fields.");
        boolean result = LoginService.login("", "", "");
        Assert.assertFalse("Login should fail due to empty fields", result);
        sleep(1);  // Simulating time delay
    }

    @Test
    public void testLoginWithNullValues() {
        System.out.println("Testing login with null values.");
        boolean result = LoginService.login(null, null, null);
        Assert.assertFalse("Login should fail due to null values", result);
        sleep(1);  // Simulating time delay
    }
}
