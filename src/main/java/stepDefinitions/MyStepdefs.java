package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MyStepdefs {
    private WebDriver driver;

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

    @And("I fill in email address {string}")
    public void iFillInEmailAddress(String email) {
        WebElement dateField = driver.findElement(By.name("EmailAddress"));
        dateField.sendKeys(email);
    }

    @And("confim email address {string}")
    public void confimEmailAddress(String confirmEmail) {
        WebElement dateField = driver.findElement(By.name("ConfirmEmailAddress"));
        dateField.sendKeys(confirmEmail);
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
    public void iChooseTheRole(String arg0) {
    }

    @And("I confirm terms & conditions")
    public void iConfirmTermsConditions() {
    }

    @And("I confirm I'm over {int}")
    public void iConfirmIMOver(int arg0) {
    }

    @And("I adhere to code of ethics")
    public void iAdhereToCodeOfEthics() {
    }

    @When("I confirm and join")
    public void iConfirmAndJoin() {
    }

    @Then("I receive a membership number")
    public void iReceiveAMembershipNumber() {
    }
}
