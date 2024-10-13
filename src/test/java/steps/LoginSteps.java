package steps;

import io.cucumber.java.en.*;
import com.AppiumSetup;
import org.openqa.selenium.By; // Import this to find elements


public class LoginSteps {

    @Given("the app is launched")
    public void theAppIsLaunched() throws Exception {
        AppiumSetup.setup();  // Panggil setup untuk memulai Appium dan aplikasi
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersCredentials(String username, String password) {
        // Find the username/email field and enter the provided username
        AppiumSetup.driver.findElement(By.id("com.example:id/emailField")).sendKeys(username);

        // Find the password field and enter the provided password
        AppiumSetup.driver.findElement(By.id("com.example:id/passwordField")).sendKeys(password);
    }

    @And("the user clicks the login button")
    public void theUserClicksLogin() {
        // Find the login button and click it
        AppiumSetup.driver.findElement(By.id("com.example:id/loginButton")).click();
    }

    @Then("the user is logged in successfully")
    public void theUserIsLoggedInSuccessfully() {
        // Optionally, assert if login was successful (for example, by checking the presence of a home page element)
        boolean isLoggedIn = AppiumSetup.driver.findElement(By.id("com.example:id/homePage")).isDisplayed();
        assert isLoggedIn;
    }
}
