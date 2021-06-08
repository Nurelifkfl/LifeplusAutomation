package com.lifeplus.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePage extends BasePage{

    @FindBy(xpath = "(//*[text()='Nutritional Supplements'])[1]")
    public WebElement nutriSupp;

    @FindBy(xpath = "(//*[text()='Our Products'])[1]")
    public WebElement ourProducts;

    @FindBy(xpath = "//*[text()='Winter Boost Pack']")
    public WebElement item;

    @FindBy(xpath = "(//*[@type='submit'])[4]")
    public WebElement addToCart;


}
