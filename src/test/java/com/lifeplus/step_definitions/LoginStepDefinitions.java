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

public class LoginStepDefinitions {

    @Given("user is on homepage")
    public void user_is_on_homepage() {
        Driver.get().get(ConfigurationReader.get("url"));


    }

    @When("user navigates to login")
    public void user_navigates_to_login() {

        BrowserUtils.waitFor(2);
        String loginButton="//*[text()='Log in or register']";
       Driver.get().findElement(By.xpath(loginButton)).click();

        BrowserUtils.waitFor(2);
       String popUpLoginBut=".popup-button.login-button";
       Driver.get().findElement(By.cssSelector(popUpLoginBut)).click();
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

        System.out.println(actual);
        Assert.assertTrue(" ",actual.contains(expected));



    }



}
