package electronics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void testVerified() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        mouseHoverAndClick(By.xpath(" //ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        verifyTextMessages("Comparing Results", "Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        mouseHoverAndClick(By.xpath(" //ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        verifyTextMessages("Comparing Results", "Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        Thread.sleep(2000);
        clickOnElement(By.linkText("Nokia Lumia 1020"));
        verifyTextMessages("Comparing", "Nokia Lumia 1020", By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        verifyTextMessages("Price Does Not Match", "$349.00", By.xpath("//span[@id='price-value-20']"));
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        verifyTextMessages("Product has been added", "The product has been added to your shopping cart", By.xpath("//p[@class='content']"));
        //After that close the bar clicking on the cross button
        clickOnElement(By.xpath("//span[@title='Close']"));
        mouseHover(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        verifyTextMessages("Verifying", "Shopping cart", By.xpath("//h1[normalize-space()='Shopping cart']"));
        verifyTextMessages("Quantity", "2", By.xpath("//input[@id='itemquantity11238']"));
        verifyTextMessages("Total", "$698.00", By.xpath("//td[@class='subtotal']"));
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));
        verifyTextMessages("Welcome", "Welcome, Please Sign In!", By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));
        clickOnElement(By.xpath("//input[@id='gender-female']"));
        sendTextToElement(By.name("FirstName"), "Hi");
        sendTextToElement(By.name("LastName"), "Hello");
        selectByValueFromDropDown(By.name("DateOfBirthDay"), "10");
        selectByVisibleTextFromDropDown(By.name("DateOfBirthMonth"), "August");
        selectByValueFromDropDown(By.name("DateOfBirthYear"), "1990");
        sendTextToElement(By.name("Email"), "ppprime1234@gmail.com");
        sendTextToElement(By.name("Password"), "abcd123");
        sendTextToElement(By.name("ConfirmPassword"), "abcd123");
        clickOnElement(By.id("register-button"));
        verifyTextMessages("Registration not completed", "Registration completed", By.xpath("//div[contains(text(),'Your registration completed')]"));
        verifyTextMessages("Verifying", "Your registration completed", By.xpath("//h1[normalize-space()='Register']"));
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        verifyTextMessages("Verifying", "Shopping cart", By.xpath("//h1[normalize-space()='Shopping cart']"));
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
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
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByIndexFromDropDown(By.xpath("//select[@id='CreditCardType']"), 0);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "cvcvxcvc");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "4263982640269299");
        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireMonth']"), 2);
        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireYear']"), 2023);
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        verifyTextMessages("CheckingPayment", "Credit Card", By.xpath("//span[normalize-space()='Credit Card']"));
        verifyTextMessages("CheckingShippingMethod", "2nd Day Air", By.xpath("//span[normalize-space()='2nd Day Air']"));
        verifyTextMessages("Total is", "$698.00", By.xpath("//span[@class='product-subtotal']"));
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        verifyTextMessages("Error", "Thank you", By.xpath("//h1[normalize-space()='Thank you']"));
        verifyTextMessages("Not processed", "Your order has been successfully processed!", By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        verifyTextMessages("Error", "Welcome to our store", By.xpath("//h2[normalize-space()='Welcome to our store']"));


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
