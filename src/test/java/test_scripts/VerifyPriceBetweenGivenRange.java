package test_scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.Amazon.Homepage;
import page_objects.Amazon.SearchPage;

public class VerifyPriceBetweenGivenRange extends  DriverWrapper {

    @Test
    public void verifyPriceBetweenRange() throws InterruptedException {
        Homepage homepage = new Homepage();
        SearchPage searchpage = new SearchPage();
        double startRange = 50.00;
        double endRange = 150.00;
        boolean inRange = true;

        homepage.writeInSearchBox("iphone");
        homepage.clickOnSearchIcon();
        Thread.sleep(5000);
        String priceString = searchpage.getPriceOfFirstSponsoredItem();  //$99.99
        System.out.println(priceString);
        //priceString = priceString.substring(1); //"99.99"
        double price = Double.valueOf(priceString); //99.99
        System.out.println("Double: " + price);

        if(price < startRange || price > endRange) {
            inRange = false;
        }

        Assert.assertTrue(inRange, "Item price is not in range.\tFound item price: "+price);

    }
}
