package com.lifeplus.step_definitions;

import com.lifeplus.pages.LoginPage;
import com.lifeplus.utilities.BrowserUtils;
import com.lifeplus.utilities.ConfigurationReader;
import com.lifeplus.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginStepDefinitions {
     LoginPage loginPage = new LoginPage();
    @Given("user is on homepage")
    public void user_is_on_homepage() {
        Driver.get().get(ConfigurationReader.get("url"));


    }

    @When("user navigates to login")
    public void user_navigates_to_login() {

        WebElement firstLogIn = loginPage.firstLogIn;
        firstLogIn.click();

        BrowserUtils.waitFor(2);

        WebElement popupLogIn = loginPage.popUpLoginButton;
        popupLogIn.click();

    }

    @When("enter valid username and password")
    public void enter_valid_username_and_password(){

        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

    }

    @Then("the user should be able to login successfully")
    public void the_user_should_be_able_to_login_successfully() {

        String expected="Logout";
        String logout="user-logout";
        String actual=Driver.get().findElement(By.className(logout)).getText();

        Assert.assertTrue(" ",actual.contains(expected));



    }



}
