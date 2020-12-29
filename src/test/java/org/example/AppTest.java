package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }



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


}
