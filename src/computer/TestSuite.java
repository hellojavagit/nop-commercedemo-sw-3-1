package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void name() throws InterruptedException {
        //Click on Computer Menu.
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //Click on Desktop
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        //Select Sort By position "price low to high"
        mouseHoverAndClick(By.xpath("//select[@id='products-orderby']"));
        selectByIndexFromDropDown(By.xpath("//select[@id='products-orderby']"), 3);
        //Verify the Product will arrange in Descending order.
        verifyTextMessages("Error in order", "Price: Low to High", By.name("products-orderby"));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // Click on Computer Menu.
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //Click on Desktop
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        //Select Sort By position "Name: A to Z"
        mouseHoverAndClick(By.xpath("//select[@id='products-orderby']"));
        selectByIndexFromDropDown(By.xpath("//select[@id='products-orderby']"), 1);
        // Click on "Add To Cart"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@type='button' and @onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']"));
        Thread.sleep(2000);
        //Verify the Text "Build your own computer"
        verifyTextMessages("ErrorMessage", "Build your own computer", By.xpath("//h1[normalize-space()='Build your own computer']"));
        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByIndexFromDropDown(By.xpath("//select[@id='product_attribute_1']"), 2);
        //Select "8GB [+$60.00]" using Select class.
        selectByIndexFromDropDown(By.xpath("//select[@id='product_attribute_2']"), 3);
        // Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        //Verify the price "$1,475.00"
        verifyTextMessages("verifying the price","$1,475.00",By.xpath("//span[@id='price-value-1']"));
        //Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyTextMessages("Product has been added", "The product has been added to your shopping cart", By.xpath("//p[@class='content']"));
        //After that close the bar clicking on the cross button
        clickOnElement(By.xpath("//span[@title='Close']"));
        // MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        //Verify the message "Shopping cart"
        verifyTextMessages("Shopping cart", "Shopping cart", By.xpath("//h1[normalize-space()='Shopping cart']"));
        //Change the Qty to "2" and Click on "Update shopping cart"
       // sendTextToElement(By.xpath("//input[@id='itemquantity11263']"), "1");
        //Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //sendTextToElement(By.id("itemquantity11215"),"2");
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        // Verify the Total"$2,950.00"
        verifyTextMessages("Total verification", "$2,950.00", By.xpath("//span[@class='product-subtotal']"));
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // Verify the Text “Welcome, Please Sign In!”
        verifyTextMessages("Welcome", "Welcome, Please Sign In!", By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        ////button[normalize-space()='Checkout as Guest']
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Hello");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "hi");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "prime123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"), "ABCDEF");
        selectByIndexFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), 10);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "Select state");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "TEXAS");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "qwertuy");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "123456");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "12321");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        ////input[@id='shippingoption_1']
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //Select “Master card” From Select credit card dropdown
        selectByIndexFromDropDown(By.xpath("//select[@id='CreditCardType']"), 1);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "cvcvxcvc");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "4234456565676766");
        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireMonth']"), 12);
        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireYear']"), 2023);
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //verify Payment Method: Credit Card
        //verifyTextMessages("Payment methods","Payment Method: Credit Card",By.xpath("//span[normalize-space()='Payment Method:']"));
        //verifyTextMessages("ERRor","Payment Method: Credit Card",By.xpath(" //span[normalize-space()='Credit Card']"));
        //verifyTextMessages("Error","",By.ClassName("shipping-method"));
        verifyTextMessages("Error", "$2,900.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,900.00')]"));
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        verifyTextMessages("Error", "Thank you", By.xpath("//h1[normalize-space()='Thank you']"));
        verifyTextMessages("Not processed", "Your order has been successfully processed!", By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        verifyTextMessages("Error", "Welcome to our store", By.xpath("//h2[normalize-space()='Welcome to our store']"));
        clickOnElement(By.xpath("//a[normalize-space()='Log out']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}