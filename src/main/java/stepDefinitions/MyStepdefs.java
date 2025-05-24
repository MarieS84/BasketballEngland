package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyStepdefs {
    private WebDriver driver;
    private String uniqueEmail = "svensson-test" + System.currentTimeMillis() + "@gmail.com";

    @Given("I am using {string} as browser")
    public void iAmUsingAsBrowser(String browser) {
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        }else if(browser.equals("edge")){
            driver = new EdgeDriver();
        }
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @Given("I fill in date of birth is {string}")
    public void iFillInDateOfBirthIs(String dateOfBirth) {
        WebElement dateField = driver.findElement(By.id("dp"));
        dateField.sendKeys(dateOfBirth);
        driver.findElement(By.tagName("h2")).click(); //Clicking somewhere on the page to close dropdown
    }

    @And("I fill in first name {string}")
    public void iFillInFirstName(String firstName) {
        WebElement dateField = driver.findElement(By.name("Forename"));
        dateField.sendKeys(firstName);
    }

    @And("I fill in last name {string}")
    public void iFillInLastName(String lastName) {
        WebElement dateField = driver.findElement(By.name("Surname"));
        dateField.sendKeys(lastName);
    }

    @And("I fill in email address")
    public void iFillInEmailAddress() {
        WebElement dateField = driver.findElement(By.name("EmailAddress"));
        dateField.sendKeys(uniqueEmail);
    }

    @And("confirm email address")
    public void confirmEmailAddress() {
        WebElement dateField = driver.findElement(By.name("ConfirmEmailAddress"));
        dateField.sendKeys(uniqueEmail);
    }

    @And("I choose password {string}")
    public void iChoosePassword(String password) {
        WebElement dateField = driver.findElement(By.name("Password"));
        dateField.sendKeys(password);
    }

    @And("I retype password {string}")
    public void iRetypePassword(String confirmPassword) {
        WebElement dateField = driver.findElement(By.name("ConfirmPassword"));
        dateField.sendKeys(confirmPassword);
    }

    @And("I choose the role {string}")
    public void iChooseTheRole(String role) {
        WebElement label = driver.findElement(By.cssSelector("label[for='" + role + "']"));
        label.click();
    }

    @And("I confirm terms & conditions")
    public void iConfirmTermsConditions() {
        WebElement label = driver.findElement(By.cssSelector("label[for='sign_up_25']"));
        label.click();
    }

    @And("I am of legal age")
    public void iAmOfLegalAge() {
        WebElement label = driver.findElement(By.cssSelector("label[for='sign_up_26']"));
        label.click();
    }

    @And("I adhere to code of ethics")
    public void iAdhereToCodeOfEthics() {
        WebElement label = driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']"));
        label.click();
    }

    @When("I confirm and join")
    public void iConfirmAndJoin() {
        WebElement confirmButton = driver.findElement(By.name("join"));
        confirmButton.click();
    }

    @Then("I receive a membership number")
    public void iReceiveAMembershipNumber() {
        By membershipNumberLocator = By.cssSelector("h2.bold.margin-bottom-40");
        WebElement membershipNumber = waitForElement(membershipNumberLocator, 2);
        Assert.assertFalse(membershipNumber.getText().isEmpty());
    }


    @Then("I get the warning message {string}")
    public void iGetTheWarningMessage(String expected) {
        WebElement errorMessage = driver.findElement(By.cssSelector("span[data-valmsg-for='Surname']"));
        Assert.assertEquals(expected, errorMessage.getText());
    }

    @Then("I get the password warning message {string}")
    public void iGetThePasswordWarningMessage(String expected) {
        WebElement errorMessage = driver.findElement(By.cssSelector("span[data-valmsg-for='ConfirmPassword']"));
        Assert.assertEquals(expected, errorMessage.getText());
    }

    @Then("I get the terms & conditions warning message {string}")
    public void iGetTheTermsConditionsWarningMessage(String expected) {
        WebElement termsError = driver.findElement(By.cssSelector("span[for='TermsAccept']"));
        Assert.assertEquals(expected, termsError.getText());
    }

    private WebElement waitForElement(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
