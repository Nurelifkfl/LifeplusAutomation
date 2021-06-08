package com.lifeplus.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {


    @FindBy(xpath = "//*[text()='Log in or register']")
    public WebElement firstLogIn;
    @FindBy(css = ".popup-button.login-button")
    public WebElement popUpLoginButton;

    @FindBy(xpath = "(//input[@name='user-name'])[2]")
    public WebElement username;

    @FindBy(xpath = "(//input[@name='password'])[2]")
    public WebElement password;

    @FindBy(xpath = "(//span[@class='iconbutton-text'])[2]")
    public WebElement Login;




}
