package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

   // public static WebDriver driver;

  //  LoginPage loginPage = new LoginPage();

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {
        openBrowserAndLaunchApplication();
      //  driver = new ChromeDriver();
        //get method is used to navigate to the application
        //driver.get("http://148.72.132.33:8081/");
        //to maximize the window
        //driver.manage().window().maximize();
        //implicitly wait is used to wait for the elements to be present in the DOM before throwing an exception
        //driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
       // WebElement usernameField = driver.findElement(By.xpath("//*[@name='username']"));
       // WebElement passwordField = driver.findElement(By.xpath("//*[@name='password']"));
       // usernameField.sendKeys("hrm_user");
       // passwordField.sendKeys("Hrm_user@123");
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"),loginPage.passwordField);

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
      //  WebElement loginButton = driver.findElement(By.xpath("//*[@type='submit']"));
        //loginButton.click();
        click(loginPage.loginButton);
    }

    @Then("user is able to login successfully")
    public void user_is_able_to_login_successfully() {
        System.out.println("Test passed");
    }

}