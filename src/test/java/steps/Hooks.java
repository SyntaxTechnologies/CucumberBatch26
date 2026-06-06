package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    //this hooks class will be used to open and close the browser before and after each scenario
    //this hooks class must be inside steps package because in runner class we have mentioned the glue as steps, so it will only look for the classes inside steps package


     //pre condition
     @Before
     public void start(){
         //pre condition is opening the browser and launching the application,
         // so we can call the method from common methods class to do that
            openBrowserAndLaunchApplication();
     }

     @After
     public void end(Scenario scenario){
            //scenario class holds the information about the scenario that is currently running

            byte[] pic;
            if(scenario.isFailed()){
                pic = takeScreenshot("failed/"+scenario.getName());
            }else{
                pic = takeScreenshot("passed/"+scenario.getName());
            }
            //it will attach the screenshot to the report, the first parameter is the byte array of the screenshot,
         // the second parameter is the type of the file, and the third parameter is the name of the file
            scenario.attach(pic,"image/png",scenario.getName());
            //post condition is closing the browser, so we can call the method from common methods class to do that
            closeBrowser();
     }
         //closing the browser after each scenario, so we can call the method from common methods class to do that
}
