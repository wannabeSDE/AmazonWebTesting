package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignIn {
    public SignIn(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.XPATH, using="//*[@id='ap_email']")
    private WebElement EmailOrPhone;

    @FindBy(how = How.XPATH, using="//*[@class='a-button-input']")
    private WebElement Continue;

    @FindBy(how = How.XPATH, using="//*[@id='ap_password']")
    private WebElement passWord;

    @FindBy(how = How.XPATH, using="//*[@id='signInSubmit']")
    private WebElement btn_signIn;


    public void enter_EmailOrPhone(String message){
        EmailOrPhone.sendKeys(message);
    }
    public void click_Continue(){
        Continue.click();
    }
    public void enter_Password(String password){
        passWord.sendKeys(password);
    }
    public void click_signIn(){
        btn_signIn.click();
    }
    public WebElement getPassWordElement(){
        return passWord;
    }
    public WebElement getBtn_signInElement(){
        return btn_signIn;
    }

}
