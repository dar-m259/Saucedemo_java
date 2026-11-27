package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Страница с продуктами для авторизованного пользователя */

public class ProductsPage {
    private final By title = By.cssSelector("[data-test='title']");
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean pageTitleVisible() {
        return driver.findElement(title).isDisplayed();
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public String currentUrl() {
        return  driver.getCurrentUrl();
    }
}
