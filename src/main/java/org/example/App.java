package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;


public class App
{

    public static WebDriver driver;
    private static Actions actions;
    public static final  String PASSWORD = "123zxc321cxz";
    public static final  String LOGIN = "user_diary";

    public static WebDriver getDriver(){
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    driver = new ChromeDriver(options);
    return driver;
    }


    public static void testAuth( WebDriver driver ) {
        driver.get("https://www.diary.ru");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement authorization = driver.findElement(By.id("drop-login"));
        authorization.click();
        WebElement inputLogin = driver.findElement(By.id("usrlog2"));
        inputLogin.click();
        inputLogin.sendKeys(LOGIN);

        WebElement inputPass = driver.findElement(By.id("usrpass2"));
        inputPass.click();
        inputPass.sendKeys(PASSWORD);
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"loginform\"]/form/button"));
        submit.click();
        WebElement userMenu = driver.findElement(By.id("drop"));
        userMenu.click();
        WebElement exitUser = driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/ul[2]/li[10]/div/div/div[1]/a[2]"));
        exitUser.click();



    }

    public static void newCreateDiary( WebDriver driver ) {
        driver.get("https://www.diary.ru");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement authorization = driver.findElement(By.id("drop-login"));
        authorization.click();
        WebElement inputLogin = driver.findElement(By.id("usrlog2"));
        inputLogin.click();
        inputLogin.sendKeys(LOGIN);

        WebElement inputPass = driver.findElement(By.id("usrpass2"));
        inputPass.click();
        inputPass.sendKeys(PASSWORD);
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"loginform\"]/form/button"));
        submit.click();
        WebElement newEntry = driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/ul[2]/li[2]/a"));
        newEntry.click();

        WebElement checkLink = driver.findElement(By.linkText("user_diary"));
        new WebDriverWait(driver,4).until(ExpectedConditions.visibilityOf(checkLink));

        WebElement title = driver.findElement(By.id("postTitle"));
        title.click();
        title.sendKeys("Запись");

        WebElement message = driver.findElement(By.id("message"));
        message.click();
        message.sendKeys("Тестовая запись");

        WebElement buttonNewEntry = driver.findElement(By.id("draft_save"));
        buttonNewEntry.click();
        WebElement draft = driver.findElement(By.xpath("//*[@id=\"myDraftLink\"]/a"));
        draft.click();

        WebElement deleteDraft = driver.findElement(By.cssSelector("img[title='Удалить']"));
        deleteDraft.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement deleteYes = driver.findElement(By.cssSelector("input[value='Да']"));
        deleteYes.click();


//        new WebDriverWait(driver,4).until(ExpectedConditions.visibilityOf(buttonNext));
//        WebElement diaryDelete = driver.findElement(By.className("i-cross"));
//        diaryDelete.click();



    }



    public static void main( String[] args ) {
        getDriver();
        testAuth(driver);
        newCreateDiary(driver);
        driver.quit();
    }
//        driver.get("https://crm.geekbrains.space");
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        WebElement inputLogin = driver.findElement(By.id("prependedInput"));
//        inputLogin.click();
//        inputLogin.sendKeys("Applanatest");
//        inputLogin.sendKeys(Keys.ENTER);
//        WebElement inputPass = driver.findElement(By.id("prependedInput2"));
//        inputPass.click();
//        inputPass.sendKeys("Student2020!");
//        inputPass.sendKeys(Keys.ENTER);
//        WebElement singIn = driver.findElement(By.id("_submit"));
//        singIn.click();
//        singIn.sendKeys(Keys.ENTER);
//        WebElement buttonDropdown = driver.findElement(By.className("dropdown"));
//        WebElement dropdownTitle = driver.findElement(By.className("title"));
//        actions.moveToElement(buttonDropdown).click(dropdownTitle);
//        Action clickTitle = actions.build();
//        clickTitle.perform();

//        WebElement buttonDropdown = driver.findElement(By.className("dropdown"));
//        Actions cursor = new Actions(driver);
//        cursor.moveToElement(buttonDropdown);
//        cursor.click();
//        cursor.perform();
//        WebElement dropdownCompany = driver.findElement(By.className("title"));
//        Actions cursor2 = new Actions(driver);
//        cursor2.moveToElement(dropdownCompany);
//        cursor2.click();
        //new Select(driver.findElement(By.cssSelector("\"span=[title='Контрагенты']\""))).selectByVisibleText("Организации");

//        WebElement buttonDropdown = driver.findElement(By.cssSelector("dropdown:nth-child(3) > .unclickable > .title"));
//        buttonDropdown.click();
//
//        buttonDropdown.sendKeys(Keys.ENTER);



}
