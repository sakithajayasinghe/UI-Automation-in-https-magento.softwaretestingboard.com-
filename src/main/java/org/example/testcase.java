package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testcase {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    public void testng() throws InterruptedException {
        //LOGIN TEST
        //1.Go to https://magento.softwaretestingboard.com/ and use the provided username
        //password to login to the system.
        String givenURL = "https://magento.softwaretestingboard.com/";
        driver.get(givenURL);
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(givenURL, currentURL);
        System.out.println("URL VERIFIED");
        driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
        driver.findElement(By.id("email")).sendKeys("qagroup37@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Abc1234@");
        driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();

        //2.//(1).Adding Cart
        ////(1.1)By Selecting Item

               Thread.sleep(5000);
               driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]/span[2]")).click();

               Thread.sleep(2000);
               driver.findElement(By.xpath("//*[@id=\"narrow-by-list2\"]/dd/ol/li[2]/a")).click();
               Thread.sleep(2000);
               driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/strong/a")).click();
               Thread.sleep(2000);
//3.verify name and price
        String productname="Pierce Gym Short";
        String productnamechecking=driver.findElement(By.className("base")).getText();
        Assert.assertEquals(productname,productnamechecking);
        System.out.println("Name is same");
        String price="$27.00";
        String checkingprice=driver.findElement(By.xpath("//*[@id=\"product-price-1028\"]/span")).getText();

        Assert.assertEquals(price,checkingprice);
        System.out.println("price is same");


//add to cart



               driver.findElement(By.id("option-label-size-143-item-175")).click();
               Thread.sleep(2000);
               driver.findElement(By.id("option-label-color-93-item-49")).click();
               Thread.sleep(2000);
               driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
               Thread.sleep(4000);
               driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/a")).click();
               Thread.sleep(2000);

               //4.



        //5.add another product
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button")).click();
        Thread.sleep(12000);
        driver.findElement(By.xpath("/html/body/div[1]/header/div/a/img")).click();
        Thread.sleep(2000);

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"ui-id-6\"]/span[2]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"narrow-by-list2\"]/dd/ol/li[1]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("product-item-link")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("product-addtocart-button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a/span")).click();
        Thread.sleep(5000);
       //6. Go to the Cart and Verify if the value of the Total Products amount
        //equals the sum of the product prices that are added to the cart
        String price3="$27.00";
        String checkingprice3=driver.findElement(By.className("cart-price")).getText().replace("$","");
        System.out.println(checkingprice3);

        String price4="$45.00";
        String checkingprice4=driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody[2]/tr[1]/td[2]/span/span/span")).getText().replace("$","");
        System.out.println(checkingprice4);



        double num=(Double.parseDouble(checkingprice3)+Double.parseDouble(checkingprice4));
        System.out.println(num);
        String num2=driver.findElement(By.xpath("//*[@id=\"cart-totals\"]/div/table/tbody/tr[1]/td/span")).getText().replace("$","");
        double num3=Double.parseDouble(num2);
        Assert.assertEquals(num,num3);
        System.out.println("Price is same");
        Thread.sleep(2000);

        //7. Click on the trash can icon next to the products and remove one from the cart
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody[1]/tr[2]/td/div/a[3]")).click();
        Thread.sleep(2000);
        //Verify if the total is updated after the removal of products
        String checkingprice5="$45.00";
        Thread.sleep(8000);
        String num4=driver.findElement(By.xpath("//*[@id=\"cart-totals\"]/div/table/tbody/tr[1]/td/span")).getText();
        Assert.assertEquals(checkingprice5,num4);
        System.out.println("total is updated after the removal of products");
        //8. Click on proceed to checkout
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button")).click();
        Thread.sleep(5000);
      /*  //9. Fill in the necessary information and proceed
        driver.findElement(By.name("name")).sendKeys("abc company");
        Thread.sleep(2000);
        driver.findElement(By.className("input-text")).sendKeys("3rd crosss street");
        Thread.sleep(2000);
        driver.findElement(By.name("city")).sendKeys("marista");
        Thread.sleep(2000);
        driver.findElement(By.className("select")).sendKeys("Alaska");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"ES20OTP\"]")).sendKeys("12345-6423");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"XMSKQ2J\"]")).sendKeys("0702966725");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input")).click();
        Thread.sleep(2000);*/
        driver.findElement(By.className("radio")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();

        //10.Verify URL
        Thread.sleep(3000);
        String url="https://magento.softwaretestingboard.com/checkout/#payment";
        Thread.sleep(2000);
        String url2=driver.getCurrentUrl();
        Assert.assertEquals(url,url2);
        System.out.println("URL VERIFIED");
        Thread.sleep(6000);

        //11. Click on Place Order
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();



        //12. Finally, Verify the Thank you for your purchase! message
        String msg="Thank you for your purchase!";
        Thread.sleep(6000);
        String msg2=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText();
        Thread.sleep(2000);
        Assert.assertEquals(msg,msg2);
        System.out.println("Thankyou msg verified");

















    }

}
