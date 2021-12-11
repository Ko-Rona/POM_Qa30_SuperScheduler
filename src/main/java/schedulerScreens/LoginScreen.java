package schedulerScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginScreen extends BaseScreen {

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;
    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;
    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;
    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMessage;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement okBtn;


    public WizardScreen loginComplexPositive(Auth user) {
        should(emailEditText, 20);
        type(emailEditText, user.getEmail());
        type(passwordEditText, user.getPassword());
        hideKeyBoard();
        loginButton.click();
        return new WizardScreen(driver);
    }

    public LoginScreen loginComplexNegative(Auth user) {
        should(emailEditText, 20);
        type(emailEditText, user.getEmail());
        type(passwordEditText, user.getPassword());
        hideKeyBoard();
        loginButton.click();
        return this;
    }

    public LoginScreen fillEmail(String email) {
        should(emailEditText, 20);
        type(emailEditText, email);
        return this;
    }

    public LoginScreen fillPassword(String password) {
        type(passwordEditText, password);
        return this;
    }

    public WizardScreen clickLoginBtn() {
        hideKeyBoard();
        loginButton.click();
        return new WizardScreen(driver);
    }

    public boolean isLoginBtn() {
        return isDisplayedWithExp(loginButton);
    }

    public LoginScreen checkErrorMessage(String message) {
        shouldHave(errorMessage, message, 10);
        return this;
    }

    public LoginScreen confirmErrorMessage() {
        okBtn.click();
        return this;
    }


}
