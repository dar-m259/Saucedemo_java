package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void lockedOutUserError() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.errorMsgVisible());
        assertEquals(loginPage.getErrorMsgText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void wrongUsernameError() {
        loginPage.open();
        loginPage.login("Standard_user", "secret_sauce");

        assertTrue(loginPage.errorMsgVisible());
        assertEquals(loginPage.getErrorMsgText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void wrongPasswordError() {
        loginPage.open();
        loginPage.login("standard_user", "secretsauce");

        assertTrue(loginPage.errorMsgVisible());
        assertEquals(loginPage.getErrorMsgText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void emptyUsernameFieldError() {
        loginPage.open();
        loginPage.login("", "secret_sauce");

        assertTrue(loginPage.errorMsgVisible());
        assertEquals(loginPage.getErrorMsgText(), "Epic sadface: Username is required");
    }

    @Test
    public void emptyPasswordFieldError() {
        loginPage.open();
        loginPage.login("standard_user", "");

        assertTrue(loginPage.errorMsgVisible());
        assertEquals(loginPage.getErrorMsgText(), "Epic sadface: Password is required");
    }

    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.currentUrl(), "https://www.saucedemo.com/inventory.html");
        assertTrue(productsPage.currentUrl().contains("inventory.html"));

        assertTrue(productsPage.pageTitleVisible());
        assertEquals(productsPage.getTitleText(), "Products");

    }
}
