import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewTest extends BaseTest {

    @Test
    public void lockedOutUserError() {

        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        boolean errorIsVisible = driver.findElement(By.cssSelector(".error-message-container")).isDisplayed();
        String errorText = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();

        assertTrue(errorIsVisible);
        assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.");

    }

    @Test
    public void correctLogin() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
        assertTrue(currentUrl.contains("inventory.html"));

        boolean pageTitleIsVisible = driver.findElement(By.cssSelector("[data-test='title']")).isDisplayed();
        String errorText = driver.findElement(By.cssSelector("[data-test='title']")).getText();

        assertTrue(pageTitleIsVisible);
        assertEquals(errorText, "Products");
    }
}
