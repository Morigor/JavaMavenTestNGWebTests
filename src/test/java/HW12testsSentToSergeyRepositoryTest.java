import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Integer.parseInt;

public class HW12testsSentToSergeyRepositoryTest {

    private final String baseURL = "http://www.99-bottles-of-beer.net/";
    private final String browseLangURL = "https://www.99-bottles-of-beer.net/abc.html";
    private final String chromeDriver = "webdriver.chrome.driver";
    private final String driverPath
            = "C:\\Drivers\\selenium, driver for Chrome\\chromedriver.exe";

    @Test
    public void testAreLanguagesSortedByLetter() {
        String expectedResult
                = "All languages starting with the letter J are shown, sorted by Language.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(baseURL);

        driver.findElement(
                By.xpath("//ul[@id='menu']/li/a[@href='/abc.html']")
        ).click();
        driver.findElement(
                By.xpath("//ul[@id='submenu']/li/a[@href='j.html']")
        ).click();

        String actualResult = driver
                .findElement(By.xpath("//div[@id='main']/p[text()]")).getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testConfirmIfLanguageCorrect() {
        String expectedResult = "MySQL";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(baseURL);
        driver.findElement(
                By.xpath("//ul[@id='menu']/li/a[@href='/abc.html']")
        ).click();
        driver.findElement(
                By.xpath("//ul[@id='submenu']/li/a[@href='m.html']")
        ).click();

        String actualResult = driver
                .findElement(
                        By.xpath("//table[@id='category']/tbody/tr/td" +
                                "/a[@href='language-mysql-1252.html']")
                ).getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testConfirmIfTableHeadExist() {
        String expectedResult = "Language, Author, Date, Comments, Rate,";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(browseLangURL);

        String[] tableArr = new String[5];
        String actualresult = "";
        for (int i = 0; i < tableArr.length; i++) {
            tableArr[i] = driver
                    .findElement(
                            By.xpath("//tbody/tr/th[" + (i + 1) + "]")
                    ).getText();
            actualresult = actualresult.concat(tableArr[i] + ", ");
        }

        Assert.assertEquals(actualresult.trim(), expectedResult);

        driver.quit();
    }

    @Test
    public void testMathematicaLanguageData() {
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(browseLangURL);
        driver.findElement(
                By.xpath("//ul[@id='submenu']/li/a[@href='m.html']")).click();
        driver
                .findElement(
                        By.xpath("//tbody/tr/td/a[@href='language-mathematica-1090.html']"))
                .click();

        WebElement author
                = driver
                .findElement(
                        By.xpath("//table[@style='margin: 7px; padding: 0;;']/tbody/tr[2]/td[last()]"));
        WebElement update
                = driver
                .findElement(
                        By.xpath("//table[@style='margin: 7px; padding: 0;;']/tbody/tr[1]/td[last()]"));
        WebElement comments
                = driver
                .findElement(
                        By.xpath("//table[@style='margin: 7px; padding: 0;;']/tbody/tr[4]/td[last()]"));

        Assert.assertEquals(author.getText(), "Brenton Bostick");
        Assert.assertEquals(update.getText(), "03/16/06");
        Assert.assertEquals(comments.getText(), "1");

        driver.quit();
    }

    @Test
    public void testLanguagesWithFigureFirst() {
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(browseLangURL);
        driver.findElement(
                        By.xpath("//ul[@id='submenu']/li/a[@href='0.html']"))
                .click();

        String[] languageArr = new String[10];
        int numberOfLanguages = 0;
        for (int i = 0; i < languageArr.length; i++) {
            languageArr[i]
                    = driver
                    .findElement(
                            By.xpath("//table[@id='category']/tbody/tr[" + (i + 2) + "]"))
                    .getText();
            if (languageArr[i].length() > 0) {
                numberOfLanguages++;
            }
        }

        Assert.assertEquals(numberOfLanguages, 10);

        driver.quit();
    }

    @Test
    public void testOfErrorOnSignGuestbookPage() {
        String expectedResult = "Error: Error: Invalid security code.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.99-bottles-of-beer.net/guestbookv2.html");

        driver.findElement(
                        By.xpath("//ul[@id='submenu']/li/a[@href='./signv2.html']"))
                .click();
        driver.findElement(By.xpath("//form/p/input[@name='email']"))
                .sendKeys("membership@ics.org.uk");

        int randomCode = (int) (100 + (Math.random() * (999 - 100)));
        String securityCode = String.valueOf(randomCode);
        driver.findElement(By.xpath("//form/p/input[@name='captcha']"))
                .sendKeys(securityCode);
        driver.findElement(By.xpath("//form/p/textarea[@*]"))
                .sendKeys("test message");
        driver.findElement(By.xpath("//form/p/input[@type='submit']"))
                .click();

        String actualResult = driver
                .findElement(By.xpath("//div[@id='main']/p")).getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testIfIconRedditWorks() {
        String expectedResult
                = "https://www.reddit.com/login/?dest=https%3A%2F%2F" +
                "www.reddit.com%2Fsubmit%3Furl%3Dhttps%253A%252F%252F" +
                "www.99-bottles-of-beer.net%252Flanguage-java-4" +
                ".html%26title%3D99%2520Bottles%2520of%2520Beer%2520%257C%2520Language%2520Java";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(browseLangURL);

        driver.findElement(
                By.xpath("//ul[@id='submenu']/li/a[@href='j.html']")).click();
        driver.findElement(
                        By.xpath("//tbody/tr/td/a[@href='language-java-3.html']"))
                .click();
        driver
                .findElement(
                        By.xpath("//table[@id='category']/tbody/tr/td" +
                                "/a[@href='language-java-4.html']")).click();
        driver.findElement(By.xpath("//a[@title='reddit']")).click();

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testConfirmIfShakespeareInTop() {
        String language = "Shakespeare";
        boolean expectedResult = true;

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(baseURL);

        driver.findElement(
                        By.xpath("//ul[@id='menu']/li/a[@href='/toplist.html']"))
                .click();
        String[] languageArr = new String[20];
        boolean shakespearInTop20 = false;
        for (int i = 0; i < languageArr.length; i++) {
            languageArr[i] = driver
                    .findElement(By.xpath("//tbody/tr[" + (i + 2) + "]"))
                    .getText();
            if (languageArr[i].contains(language)) {
                shakespearInTop20 = true;
            }
        }

        driver.findElement(
                        By.xpath("//ul[@id='submenu']/li/a[@href='./toplist_esoteric.html']"))
                .click();
        String[] languageArr1 = new String[10];
        boolean shakespearInTop10 = false;
        for (int i = 0; i < languageArr1.length; i++) {
            languageArr1[i] = driver
                    .findElement(By.xpath("//tbody/tr[" + (i + 2) + "]"))
                    .getText();
            if (languageArr1[i].contains(language)) {
                shakespearInTop10 = true;
            }
        }

        driver.findElement(
                        By.xpath("//ul[@id='submenu']/li/a[@href='./tophits.html']"))
                .click();
        String[] languageArr2 = new String[6];
        boolean shakespearInTop6 = false;
        for (int i = 0; i < languageArr2.length; i++) {
            languageArr2[i] = driver
                    .findElement(By.xpath("//tbody/tr[" + (i + 2) + "]"))
                    .getText();
            if (languageArr2[i].contains(language)) {
                shakespearInTop6 = true;
            }
        }

        driver.findElement(
                        By.xpath("//ul[@id='submenu']/li/a[@href='./toplist_real.html']"))
                .click();
        String[] languageArr3 = new String[25];
        boolean shakespearInTop25 = false;
        for (int i = 0; i < languageArr3.length; i++) {
            languageArr3[i] = driver
                    .findElement(By.xpath("//tbody/tr[" + (i + 2) + "]"))
                    .getText();
            if (!languageArr3[i].contains(language)) {
                shakespearInTop25 = true;
            } else {
                shakespearInTop25 = false;
            }
        }

        Assert.assertEquals(shakespearInTop20, expectedResult);
        Assert.assertEquals(shakespearInTop10, expectedResult);
        Assert.assertEquals(shakespearInTop6, expectedResult);
        Assert.assertEquals(shakespearInTop25, expectedResult);

        driver.quit();
    }

    @Test
    public void testIfSixVersionsOfJavaExist() {
        int numOfJavaVersions = 6;
        int actualResult = 0;

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.99-bottles-of-beer.net/j.html");

        driver.findElement(
                        By.xpath("//tbody/tr/td/a[@href='language-java-3.html']"))
                .click();
        String versionName
                = driver
                .findElement(
                        By.xpath("//div[@id='main']/p[@style='padding-top: 0; padding-bottom: 0;']"))
                .getText();
        actualResult++;

        String[] versionArr = new String[5];
        for (int i = 0; i < versionArr.length; i++) {
            versionArr[i]
                    = driver
                    .findElement(
                            By.xpath("//table[@id='category']/tbody/tr[" + (i + 2) + "]"))
                    .getText();
            if (!versionArr[i].contains(versionName)) {
                actualResult++;
            }
        }

        Assert.assertEquals(actualResult, numOfJavaVersions);

        driver.quit();
    }

    @Test
    public void testIfVersionHasMaxComments() {
        int javaOOVersionComments = 33;

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.99-bottles-of-beer.net/language-java-3.html");

        WebElement javaOOVcomments
                = driver
                .findElement(
                        By.xpath("//table[@style='margin: 7px; padding: 0;;']/tbody/tr[4]/td[2]"));
        int maxComments = parseInt(javaOOVcomments.getText());

        int[] eachLangComments = new int[5];
        for (int i = 0; i < eachLangComments.length; i++) {
            eachLangComments[i]
                    = parseInt(driver
                    .findElement(
                            By.xpath("//table[@id='category']/tbody/tr[" + (i + 2) + "]/td[4]"))
                    .getText());
            if (eachLangComments[i] >= maxComments) {
                maxComments = eachLangComments[i];
            }
        }

        Assert.assertEquals(maxComments, javaOOVersionComments);

        driver.quit();
    }
}
