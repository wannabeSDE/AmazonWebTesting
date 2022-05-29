package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.CommonUtility;
import utilities.Logs;
import utilities.Utility;
import java.util.Map;

public class SharedStepDef {
       CommonUtility commonUtility;
       Utility utility;
       public static WebDriver driver;
       public static String EmailID;
       public static String MobileNumber;
       public static String Password;
       public static String homePageTitle;

       public SharedStepDef(){
           commonUtility = new CommonUtility();
           utility = new Utility();
       }

       @And("Open amazon home page")
       public void openAmazonHomePage() {
            try{
                driver.get(utility.getHomePageLink());
                Logs.getInfoLogs("{"+utility.getHomePageLink()+"} web page opened");
                homePageTitle = driver.getTitle();
            }catch (Exception e){
                Logs.getErrorLogs(e.getMessage());
            }
       }

    @When("The login credentials are as below")
    public void theLoginCredentialsAreAsBelow(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap();
        if(map.containsKey("email")){
            EmailID = map.get("email");
            Logs.getInfoLogs("The Email ID for login is: {"+EmailID+"}");
        }
        if(map.containsKey("phone")){
            MobileNumber = map.get("phone");
            Logs.getInfoLogs("The Phone Number for login is: {"+MobileNumber+"}");
        }
        Password = map.get("password");
        Logs.getInfoLogs("The Password for login is: {"+Password+"}");
    }

    @Given("Open web browser")
    public void openWebBrowser(DataTable dataTable) {
          Map<String, String> map = dataTable.asMap();
          String browserName = map.get("browserName");

        if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", utility.getFirefoxDriverPath());
            try{
                driver = new FirefoxDriver();
                Logs.getInfoLogs("Firefox Web Browser Opened with Window ID: {"+driver.getWindowHandle()+"}");
                driver.manage().window().maximize();
                Logs.getInfoLogs("Web Browser maximized");
                driver.manage().deleteAllCookies();
                Logs.getInfoLogs("Web Browser all cookies deleted");
            }catch (Exception e){
                Logs.getErrorLogs(e.getMessage());
            }
        }
        else if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", utility.getChromeDriverPath());
            try{
                driver = new ChromeDriver();
                Logs.getInfoLogs("Chrome Web Browser Opened with Window ID: {"+driver.getWindowHandle()+"}");
                driver.manage().window().maximize();
                Logs.getInfoLogs("Web Browser maximized");
                driver.manage().deleteAllCookies();
                Logs.getInfoLogs("Web Browser all cookies deleted");
            }catch (Exception e){
                Logs.getErrorLogs(e.getMessage());
            }
        }
        else{
            Logs.getErrorLogs("Invalid Web Browser Selected");
        }
    }
}
