package Tests;

import Pages.ElementsMenu;
import Pages.LoadDemoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// Test for Elements Menu
public class Tests {

    WebDriver driver;

    @BeforeTest
    public void LoadTheDemoPage() {
        driver = new ChromeDriver();
        new LoadDemoPage().LoadPage(driver);
    }

    @Test
    public void checkTitleAfterLoadingTheDemoPage() {
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "https://demoqa.com/");
    }

    @Test
    public void goToElementsMenu() {
        ElementsMenu elementsMenu = new ElementsMenu(driver);
        elementsMenu.goToElements();
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "https://demoqa.com/elements");
    }

    @Test
    public void goToTextBoxAndEnterCredentialsAndClickSubmitButton() {
        ElementsMenu elementsMenu = new ElementsMenu(driver);
        elementsMenu.goToTextBox();
        String title = driver.getCurrentUrl();
        Assert.assertEquals(title, "https://demoqa.com/text-box");
        elementsMenu.enterCredentials();
        elementsMenu.clickSubmitButtonAndCheckEmail();
    }

    @AfterTest
    public void closeDemoPage() {
        driver.quit();
    }
}
