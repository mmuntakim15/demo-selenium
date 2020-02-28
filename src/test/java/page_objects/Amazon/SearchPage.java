package page_objects.Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page_objects.BasePage;
import test_scripts.DriverWrapper;

import java.util.List;

public class SearchPage extends BasePage {

    By priceOfFirstSponsoredItemWhole = By.xpath("//div[contains(@class,'s-result-list')]//div[@data-index='0']//span[starts-with(@class,'a-price-whole')]");
    By priceOfFirstSponsoredItemFraction = By.xpath("//div[contains(@class,'s-result-list')]//div[@data-index='0']//span[starts-with(@class,'a-price-fraction')]");


    public String getPriceOfFirstSponsoredItem() {
        return getValueFromElement(priceOfFirstSponsoredItemWhole)+"."+getValueFromElement(priceOfFirstSponsoredItemFraction);
    }



}
