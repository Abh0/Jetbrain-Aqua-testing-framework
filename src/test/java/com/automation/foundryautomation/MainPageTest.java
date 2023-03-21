package com.automation.foundryautomation;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.*;



import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;


import java.io.IOException;
import java.time.Duration;




public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;



   

    @BeforeEach
    public void setUp() {

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);

       // driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://foundry.aarrrmor.com/");
        System.out.println("Title of the page: " + driver.getTitle());
        mainPage = new MainPage(driver);



    }

    @AfterEach
    public void tearDown() {

        driver.quit();
    }

    @Test    //TC_001 get free demo form
    public void landingPage() {
        mainPage.getFreeDemo.click();

        WebElement fullName = driver.findElement(By.xpath("//*[@id=':r7:']"));
        fullName.sendKeys("tester123");

        WebElement enterEmailId = driver.findElement(By.xpath("//*[@id=':r8:']"));
        enterEmailId.sendKeys("tester@gmail.com");

        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id=':r9:']"));
        phoneNumber.sendKeys("9994445552");

        WebElement storeName = driver.findElement(By.xpath("//*[@id=':ra:']"));
        storeName.sendKeys("Nayaaami");

        WebElement getDemoButton = driver.findElement(By.xpath("//*[@id=':rb:']"));
        getDemoButton.click();

        System.out.println("Success register landing page ");

    }

    @Test  //TC_002 sign In into Application
    public void signInForm() throws InterruptedException {
        mainPage.signInButton.click();
        WebElement enterEmailId = driver.findElement(By.xpath("//input[@name='email']"));
        enterEmailId.sendKeys("admin123@gmail.com");

        WebElement enterPassword = driver.findElement(By.xpath("//input[@name='password']"));
        enterPassword.sendKeys("0987654321");

        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-yhhqw6']"));
        loginButton.click();
        System.out.println("Sign in Successfully ");
    }

@Test          //sign up form
public void enterSignUpForm() throws InterruptedException {

        signInForm();

      //  mainPage.signUpForm.click();


    Thread.sleep(3000);
    WebElement settingIcon = driver.findElement(By.xpath("//header[@class='MuiPaper-root MuiPaper-elevation MuiPaper-elevation0 MuiAppBar-root MuiAppBar-colorPrimary MuiAppBar-positionFixed mui-fixed css-delwxj']//button[2]//*[name()='svg']"));
    settingIcon.click();
    System.out.println("click on setting icon: successfully" );

    WebElement addNewUser = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1r2avgj']"));
    addNewUser.click();
Thread.sleep(3000);
    WebElement userName1 = driver.findElement(By.xpath("//input[@placeholder='Enter User Name']"));
   userName1.sendKeys("Tester420 ");

   WebElement emailAddress = driver.findElement(By.xpath("//input[@placeholder='Enter Email ID']"));
   emailAddress.sendKeys("abhishek@101reporters.com");

    Thread.sleep(3000);
 WebElement enterPassword1 = driver.findElement(By.xpath("//input[@placeholder='Enter the Password']"));

 enterPassword1.sendKeys("0987654321");

 WebElement addNewUserbtn = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-118i3r4']"));
 addNewUserbtn.click();
System.out.println("User Added");

}

@Test
public void addToProduct() throws InterruptedException, IOException, AWTException {

        signInForm();
        Thread.sleep(3000);

    mainPage.productModule.click();
    Thread.sleep(6000);
    System.out.println("clicked on Product: " );
WebElement addNewProductButton = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-4kxug9']"));
    addNewProductButton.click();

    WebElement productName = driver.findElement(By.xpath("//input[@name='productname']"));
    productName.sendKeys("Apple iphone");

    WebElement productDescription = driver.findElement(By.xpath("//textarea[@name='productdescription']"));
    productDescription.sendKeys("Best Seller");



//image upload
//WebElement addImageButton = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-wqap2n']"));
//    addImageButton.click();
//    Thread.sleep(3000);
//    addImageButton.sendKeys("C://Users//101Reporters//Pictures//DemoImage");




    WebElement UploadImg = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-wqap2n']"));
    UploadImg.click();

    WebElement frame =driver.switchTo().activeElement();
    frame.sendKeys("C:\\Users\\101Reporters\\Pictures\\DemoImage\\iphone");



    Thread.sleep(3000);


    System.out.println("Step 1");





    WebElement regularPrice = driver.findElement(By.xpath("//input[@id='mrp']"));
    regularPrice.sendKeys("100");

    WebElement salesPrice = driver.findElement(By.xpath("//input[@id='sale_price']"));
    salesPrice.sendKeys("90");

    WebElement metaTitle = driver.findElement(By.xpath("//input[@name='productmetatitle']"));
    metaTitle.sendKeys("Recent Added");


    Actions metaDescription =  new Actions(driver);
     metaDescription.moveToElement(driver.findElement(By.xpath("//textarea[@placeholder='Type Meta Description here']")));
    metaDescription.sendKeys("this is good product  to use and pls reffered to your connection").perform();

Actions featuresec = new Actions(driver);
featuresec.moveToElement(driver.findElement(By.xpath(" //button[normalize-space()='Feature']")));
featuresec.click();



    WebElement feature1 = driver.findElement(By.xpath(" //input[@id='feature0']"));
feature1.sendKeys("smartphone");







   //for click on Publish Button
    Actions publishButton =  new Actions(driver);
    publishButton.moveToElement(driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiLoadingButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiLoadingButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1opsdle']")));
    publishButton.click().perform();
    Thread.sleep(6000);








    }
}
