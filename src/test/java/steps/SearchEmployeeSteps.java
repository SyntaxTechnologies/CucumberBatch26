package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.EmployeeSearchPage;
import utils.CommonMethods;

public class SearchEmployeeSteps extends CommonMethods {

   // EmployeeSearchPage employeeSearchPage = new EmployeeSearchPage();

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimOption = driver.findElement(By.xpath("(//*[text()='PIM'])[1]"));
       // pimOption.click();
        click(pimOption);
    }

    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
        WebElement empListOption = driver.findElement(By.xpath("//*[text()='Employee List']"));
        //empListOption.click();
        click(empListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
       // WebElement empIdSearchField = driver.findElement(By.xpath("(//*[@class='oxd-input oxd-input--active'])[2]"));
       // empIdSearchField.sendKeys("0914");
        sendText("0914", employeeSearchPage.empIdSearchField);
    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
       // WebElement searchButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
       // searchButton.click();
        click(employeeSearchPage.searchButton);
    }

    @Then("user is able to see the employee details")
    public void user_is_able_to_see_the_employee_details() {
        System.out.println("Employee can be seen");
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
     //   WebElement empNameSearchField = driver.findElement(By.xpath("(//*[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input)[1]"));
      //  empNameSearchField.sendKeys("Adam");
        sendText("adam", employeeSearchPage.empNameSearchField);
    }

}
