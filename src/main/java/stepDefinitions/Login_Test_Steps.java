package stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class Login_Test_Steps {
    Logger logger = Logger.getLogger(Login_Test_Steps.class.getName());

    WebDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\cucumber\\src\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php?controller=authentication");
    }

    @Given("^A user is on login page$")
    public void userCanLogin() {
        Assert.assertEquals(webDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication");
    }

    @When("^Provide Username and Password$")
    public void provideUserNameandPassword() {
        WebElement userName = webDriver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement password = webDriver.findElement(By.xpath("//*[@id=\"passwd\"]"));

        userName.sendKeys("sample@gmail.com");
        password.sendKeys("pa88w0rd");
    }

    @Then("^User able to login successfully$")
    public void successfullLoginWithWrongDetails() throws InterruptedException {
        WebElement submit = webDriver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));

        Assert.assertEquals(submit.isDisplayed(), true);

        submit.click();

        WebElement toastErr = webDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));

        Assert.assertEquals(toastErr.getText(), "Authentication failed.");
        close();
    }

    @After
    public void close() {
        webDriver.close();
    }
}
