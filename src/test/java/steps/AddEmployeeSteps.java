package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import utils.CommonMethods;
import utils.ExcelReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    //AddEmployeePage addEmployeePage = new AddEmployeePage();

    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmpOption = driver.findElement(By.xpath("(//*[text()='Add Employee'])[1]"));
        click(addEmpOption);
    }

    @When("user enters employee first name and middle name and last name")
    public void user_enters_employee_first_name_and_middle_name_and_last_name() {
     //   WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
     //   WebElement middleNameloc = driver.findElement(By.xpath("//*[@name='middleName']"));
     //   WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));

        sendText("khalid",addEmployeePage.firstNameloc);
        sendText("ms", addEmployeePage.middleNameloc);
        sendText("heela", addEmployeePage.lastNameloc);

    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
       WebElement saveButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
         click(saveButton);
    }

    @Then("user is able to see employee added successfully")
    public void user_is_able_to_see_employee_added_successfully() {
        System.out.println("employee added succesfully");
    }

    @When("user enters employee {string} and {string} and {string} values")
    public void user_enters_employee_and_and_values(String firstname, String middlename, String lastname) {
    //    WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
        //    WebElement middleNameloc = driver.findElement(By.xpath("//*[@name='middleName']"));
        //WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));

        sendText(firstname, addEmployeePage.firstNameloc);
        sendText(middlename, addEmployeePage.middleNameloc);
        sendText(lastname, addEmployeePage.lastNameloc);
    }


    @When("user enters employee value {string} and {string} and {string}")
    public void user_enters_employee_value_and_and(String firstname, String middlename, String lastname) {
        WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
        WebElement middleNameloc = driver.findElement(By.xpath("//*[@name='middleName']"));
        WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));

        sendText(firstname, addEmployeePage.firstNameloc);
        sendText(middlename, addEmployeePage.middleNameloc);
        sendText(lastname, addEmployeePage.lastNameloc);
    }

    @When("user enters employee value for firstname , middlename and lastname and save the employees.")
    public void user_enters_employee_value_for_firstname_middlename_and_lastname_and_save_the_employees
            (io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
           List<Map<String, String>> employeeData = dataTable.asMaps();

           //we are using for each loop to get the data from the list of maps and we are sending the data to the web elements and saving the
        // employee and then again clicking on add employee option to add another employee
           for(Map<String, String> employee : employeeData){
               WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
                WebElement middleNameloc = driver.findElement(By.xpath("//*[@name='middleName']"));
                WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));

                sendText(employee.get("firstname"), firstNameloc);
                sendText(employee.get("middlename"), middleNameloc);
                sendText(employee.get("lastname"), lastNameloc);

                WebElement saveButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
                click(saveButton);

                Thread.sleep(2000);
                WebElement addEmpOption = driver.findElement(By.xpath("(//*[text()='Add Employee'])[1]"));
                click(addEmpOption);
                Thread.sleep(2000);
           }
    }

    @When("user enters employee value for firstname , middlename and lastname using excel file and save the employees")
    public void user_enters_employee_value_for_firstname_middlename_and_lastname_using_excel_file_and_save_the_employees() throws IOException, InterruptedException {

        List<Map<String,String>> employeeData = ExcelReader.read();

        for (Map<String,String> employee:employeeData){
            WebElement firstNameloc = driver.findElement(By.xpath("//*[@name='firstName']"));
            WebElement middleNameloc = driver.findElement(By.xpath("//*[@name='middleName']"));
            WebElement lastNameloc = driver.findElement(By.xpath("//*[@name='lastName']"));

            //make sure these keys are exactly the same as the column names in the excel file
            sendText(employee.get("firstName"), firstNameloc);
            sendText(employee.get("middleName"), middleNameloc);
            sendText(employee.get("lastName"), lastNameloc);

            WebElement saveButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
            click(saveButton);

            Thread.sleep(2000);
            WebElement addEmpOption = driver.findElement(By.xpath("(//*[text()='Add Employee'])[1]"));
            click(addEmpOption);
            Thread.sleep(2000);
        }
    }
}
