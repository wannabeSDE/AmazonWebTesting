package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.SignIn;
import utilities.CommonUtility;
import utilities.Logs;
import utilities.Utility;
import utilities.Validator;

import java.util.concurrent.TimeUnit;

public class LoginStepDefs {
    private CommonUtility commonUtility;
    private Utility utility;
    private WebDriver driver;
    private HomePage homePage;
    private SignIn signIn;
    private Validator validator;

    public LoginStepDefs(){
        this.commonUtility = new CommonUtility();
        this.utility = new Utility();
        this.driver = SharedStepDef.driver;
        this.homePage = new HomePage(driver);
        this.signIn = new SignIn(driver);
        this.validator = new Validator();
    }

    @Then("Sign into your amazon account with above mentioned credentials")
    public void Signintoyouramazonaccountwithabovementionedcredentials(){
         try{
            homePage.clickOn_SignIn();
            Logs.getInfoLogs("Sign In button is clicked on {"+driver.getCurrentUrl()+"}");
            signIn.enter_EmailOrPhone(SharedStepDef.EmailID);
            Logs.getInfoLogs("Email ID entered in the text box");
            signIn.click_Continue();
            Logs.getInfoLogs("Clicked on {Continue} button");
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.elementToBeClickable(signIn.getPassWordElement()));
            signIn.enter_Password(SharedStepDef.Password);
            Logs.getInfoLogs("Password entered in the text box");
            signIn.click_signIn();
            Logs.getInfoLogs("Clicked on {Sign In} button");
            Thread.sleep(1000);
            validator.checkIfEquals(SharedStepDef.homePageTitle, driver.getTitle());
         }catch (Exception e){
             Logs.getErrorLogs(e.getMessage());
         }
    }
}
