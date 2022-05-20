import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.*;

public class WebTest {

    public static final String baseURL = "http://www.99-bottles-of-beer.net/";


    //   Тестирование сайта:  http://www.99-bottles-of-beer.net/    (lesson test)
    @Test
    public void testMenuStartTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath
                = "C:\\Drivers\\selenium, driver for Chrome\\chromedriver.exe";
        final String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                        "/ul[@id='menu']/li/a[@href='/abc.html']")
        );
        menuBrowseLanguages.click();
        sleep(3000);

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                        "/ul[@id='menu']/li/a[@href='/']")
        );
        menuStart.click();

        WebElement h2 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h2")
        );

        String actualResult = h2.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //  TC  11_01
    @Test
    public void testIs99VisibleOnTopOfBaseUrl() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath
                = "C:\\Drivers\\selenium, driver for Chrome\\chromedriver.exe";
        final String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);

        WebElement h1 = driver.
                findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='header']/h1")
        );

        String actualResult = h1.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //  TC   11_02
    @Test
    public void testIsBaseUrlConsistSubmitNewLanguageMenu() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath
                = "C:\\Drivers\\selenium, driver for Chrome\\chromedriver.exe";
        String expectedResult = "SUbMIT NEw LANGUAGE";
        expectedResult = expectedResult.toLowerCase();

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);

        WebElement menuSubmitNewLanguage = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='menu']/li/a[@href='" +
                                "/submitnewlanguage.html']"));

        String actualResult = menuSubmitNewLanguage.getText().toLowerCase();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //  TC  11_03
    @Test
    public void testIsSubmenuOfSubmitNewLanguageExist() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath
                = "C:\\Drivers\\selenium, driver for Chrome\\chromedriver.exe";
        final String expectedResult = "Submit New Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);

        WebElement menuSubmitNewLanguage
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='menu']/li/a[@href='" +
                                "/submitnewlanguage.html']"));
        menuSubmitNewLanguage.click();

        WebElement submenuSubmitNewLanguage
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='submenu']" +
                                "/li/a[@href='./submitnewlanguage.html']"));
        submenuSubmitNewLanguage.getText();

        String actualResult = submenuSubmitNewLanguage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //  TC 11_04
    @Test
    public void testIsSubmenu0_9() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath
                = "C:\\Drivers\\selenium, driver for Chrome\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/abc.html";
        final String expectedResult = "0-9";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement submenu0_9
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='submenu']/li/a[@href='0.html']"));

        String actualResult = submenu0_9.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //  TC 11_06
    @Test
    public void testAreNamesOfFoundersCorrect() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath
                = "C:\\Drivers\\selenium, driver for Chrome\\chromedriver.exe";
        final String expectedResult
                = "Oliver Schade" + "\n" + "Gregor Scheithauer" + "\n"
                + "Stefan Scheler";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);

        WebElement team
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='submenu']/li/a[@href='team.html']"));
        team.click();

        WebElement h1
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/h3[1]"));

        WebElement h2
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/h3[2]"));

        WebElement h3
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/h3[3]"));

        String actualResult = h1.getText() + "\n" + h2.getText() + "\n"
                                                        + h3.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //  TC  11_7
    @Test
    public void testIsJavaLanguageAvailable() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath
                = "C:\\Drivers\\selenium, driver for Chrome\\chromedriver.exe";
        final String expectedResult = "Java (object-oriented version)";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);

        WebElement searchLanguage
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='menu']/li/a[@href='/search.html']"));
        searchLanguage.click();


        WebElement searchField = driver.findElement(By.name("search"));
        searchField.sendKeys("java");
        searchField = driver.findElement(By.name("submitsearch"));
        searchField.click();

        WebElement tableData
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']" +
                                "/table[@id='category']/tbody/tr[2]" +
                                "/td[@bgcolor='#efefef']" +
                                "/a[@href='/language-java-3.html']"));

        String actualResult = tableData.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //  TC  11_11
    @Test
    public void testConfirmError() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath
                = "C:\\Drivers\\selenium, driver for Chrome\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        final String expectedResult
                = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement submitLanguage
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']" +
                                "/form[@id='addlanguage']/p/input[@type='submit']"));
        submitLanguage.click();

       WebElement error
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/p"));
        String actualresult = error.getText();

        Assert.assertEquals(actualresult, expectedResult);

        driver.quit();
    }

    //   TC 11_12
    @Test
    public void testConfirmDetailedErrorSyntax() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath
                = "C:\\Drivers\\selenium, driver for Chrome\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement submitLanguage
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']" +
                                "/form[@id='addlanguage']/p" +
                                "/input[@type='submit']"));
        submitLanguage.click();

        WebElement error
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/p"));

        boolean actualResult = error.getText().contains("Error");
        boolean actualResult1 = error.getText().contains("Precondition");
        boolean actualResult2 = error.getText().contains("Incomplete");
        boolean actualResult3 = error.getText().contains("Input");
        boolean actualResult4 = error.getText().contains("failed");
        boolean actualResult5 = error.getText().contains(":");
        boolean actualResult6 = error.getText().contains("-");
        boolean actualResult7 = error.getText().contains(".");


        Assert.assertTrue(actualResult);
        Assert.assertTrue(actualResult1);
        Assert.assertTrue(actualResult2);
        Assert.assertTrue(actualResult3);
        Assert.assertTrue(actualResult4);
        Assert.assertTrue(actualResult5);
        Assert.assertTrue(actualResult6);
        Assert.assertTrue(actualResult7);

        driver.quit();
    }

    //  TC 11_13
    @Test
    public void testIsImportantNoteAppeared() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath
                = "C:\\Drivers\\selenium, driver for Chrome\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        final String expectedResult
                = "IMPORTANT: Take your time! The more carefully you fill " +
                "out this form (especially the language name and " +
                "description), the easier it will be for us and the faster " +
                "your language will show up on this page. We don't have the " +
                "time to mess around with fixing your descriptions etc. " +
                "Thanks for your understanding.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement note
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']/ul" +
                                "/li[1]"));
        String actualResult = note.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //  TC 11_14
    @Test
    public void testBrowseLanguageTable() {
        String chromedriver = "webdriver.chrome.driver";
        String driverPath
                = "C:\\Drivers\\selenium, driver for Chrome\\chromedriver.exe";
        final String expectedResult1 = "Language";
        final String expectedResult2 = "Author";

        System.setProperty(chromedriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);

        WebElement browseLanguages
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='menu']/li/a[@href='/abc.html']"));
        browseLanguages.click();

        WebElement language
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']" +
                                "/table[@id='category']/tbody/tr" +
                                "/th[@style='width: 40%;']"));

        WebElement author
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='main']" +
                                "/table[@id='category']/tbody/tr" +
                                "/th[@style='width: 30%;']"));

        String actualResult1 = language.getText();
        String actualResult2 = author.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

    //  TC 11_15
    @Test
    public void testConfirmThatNoNewComments() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath
                = "C:\\Drivers\\selenium, driver for Chrome\\chromedriver.exe";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);

        WebElement topLists
                = driver
                .findElement(By
                        .xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='menu']/li[4]" +
                                "/a[@href='/toplist.html']"));
        topLists.click();

        driver.findElement(
                        By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='submenu']/li[7]" +
                                "/a[@href='./newcomments.html']")).click();

        WebElement fieldForComments
                = driver
                .findElement(
                        By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));

        boolean actualresult = fieldForComments.getText().isEmpty();

        Assert.assertTrue(actualresult);

        driver.quit();
    }

    //  TC  11_21
    public void testConfirmImportantDiff() {


    }

}
