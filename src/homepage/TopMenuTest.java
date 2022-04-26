package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyPageNavigation() {
       String result1 = getTextFromElement(By.linkText("Computers"));
       selectMenu(result1);
        String result2 = getTextFromElement(By.linkText("Electronics"));
        selectMenu(result2);
        String result3 = getTextFromElement(By.linkText("Apparel"));
        selectMenu(result3);
        String result4 = getTextFromElement(By.linkText("Digital downloads"));
        selectMenu(result4);
        String result5 = getTextFromElement(By.linkText("Books"));
        selectMenu(result5);
        String result6 = getTextFromElement(By.linkText("Jewelry"));
        selectMenu(result6);
        String result7 = getTextFromElement(By.linkText("Gift Cards"));
        selectMenu(result7);
    }
    @After
    public void tearDown() {
        //closeBrowser();
    }
}