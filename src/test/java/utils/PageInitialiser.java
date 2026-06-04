package utils;

import pages.AddEmployeePage;
import pages.EmployeeSearchPage;
import pages.LoginPage;

public class PageInitialiser {

    public static AddEmployeePage addEmployeePage;
    public static EmployeeSearchPage employeeSearchPage;
    public static LoginPage loginPage;



    public static void initializePageObjects(){
        addEmployeePage = new AddEmployeePage();
        employeeSearchPage = new EmployeeSearchPage();
        loginPage = new LoginPage();
    }



}
