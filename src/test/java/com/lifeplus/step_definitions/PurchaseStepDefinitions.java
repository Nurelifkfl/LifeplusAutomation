package com.lifeplus.step_definitions;

import com.lifeplus.pages.PurchasePage;
import com.lifeplus.utilities.BrowserUtils;
import com.lifeplus.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PurchaseStepDefinitions {

    PurchasePage purPage = new PurchasePage();

    @Given("the user navigates to {string} {string} {string}")
    public void the_user_navigates_to(String string, String string2, String string3) {


            WebElement source= Driver.get().findElement(By.xpath("(//*[text()='Our Products'])[1]"));
            Actions actions = new Actions(Driver.get());
            actions.moveToElement(source).build().perform();

            WebElement nutrisupp = Driver.get().findElement(By.xpath("(//*[text()='Nutritional Supplements'])[1]"));
            nutrisupp.click();


            WebElement lplusRecommends = Driver.get().findElement(By.xpath("(//*[text()='Lifeplus Recommends'])[2]"));

            BrowserUtils.waitForClickablility(lplusRecommends,15).click();



    }

    @Given("the user stores information of item in a txt file")
    public void the_user_stores_information_of_item_in_a_txt_file() throws IOException {
        File file1 = new File("itemInfo.txt");
        FileWriter fw = new FileWriter(file1);
        BufferedWriter bw = new BufferedWriter(fw);

        String infoOfItem=Driver.get().findElement(By.xpath("//*[@href='/uk/en/product-details/4107/winter-boost-pack']")).getText();

        String priceOfItem=Driver.get().findElement(By.xpath("//div[@class='price']")).getText();
        bw.write(infoOfItem);
        bw.write(priceOfItem);
        bw.close();
    }


    @When("user adds the item to the basket")
    public void user_adds_the_item_to_the_basket() {


        WebElement item = Driver.get().findElement(By.xpath("//*[@href='/uk/en/product-details/4107/winter-boost-pack']"));
        BrowserUtils.waitForClickablility(item,15).click();



    }

    @Then("user should be able to see in the basket")
    public void user_should_be_able_to_see_in_the_basket() {

        WebElement addToCart = Driver.get().findElement(By.xpath("//*[@id='add-to-cart-button']"));
        addToCart.click();


        String actual = Driver.get().findElement(By.name("update-cart-form")).getText();

        String expected = "Winter Boost Pack";

        Assert.assertTrue(actual.contains(expected));




    }
    @When("user deletes item in the basket")
    public void user_deletes_item_in_the_basket() {
        WebElement update = Driver.get().findElement(By.cssSelector(".bubble-text.likely-action"));
        update.click();

        WebElement remove = Driver.get().findElement(By.cssSelector(".remove-item-from-cart-button.plum-text"));
        remove.click();

    }

    @Then("basket should be empty")
    public void basket_should_be_empty() {

        String actual = Driver.get().findElement(By.xpath("//*[text()='There are currently no items in your cart.']")).getText();

        String expected = "There are currently no items in your cart.";

        Assert.assertEquals(expected,actual);

    }


}
