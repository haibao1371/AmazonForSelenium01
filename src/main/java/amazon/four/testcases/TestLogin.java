package amazon.four.testcases;

import amazon.four.locator.Data;
import amazon.four.locator.Loctors;
import amazon.four.page.NewHomePage;
import amazon.four.page.NewLoginPage;
import amazon.utils.Do;
import amazon.utils.browsers.BrowserEnum;
import amazon.utils.browsers.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author ??haibao.wang
 * @date ??Created in 2019/5/7 23:29
 * @description????????????
 * @modified By??
 * @version: $
 */
public class TestLogin {
    private WebDriver driver;
    private NewHomePage nhp;
    private NewLoginPage nlp;
    private Do doo;
    @BeforeClass
    public void init() {
        Browsers browser = new Browsers(BrowserEnum.CHROME);
        driver = browser.driver;
        driver.manage().window().maximize();
        nhp = new NewHomePage(driver);
        nlp = new NewLoginPage(driver);
        doo = new Do(driver);
    }

    @Test
    public void testLogin() {
        nhp.navigateToUrl(Data.URL);
        nhp.setGoToLogin(Loctors.GOTOLOGIN);
        nlp.setPhone(Loctors.USERNAME, Data.USER);
        nlp.setPassword(Loctors.PASSWORD, Data.PASS);
        nlp.login(Loctors.LOGIN);
       String actulString =  doo.what(Loctors.GOTOLOGIN).getText();
        Assert.assertEquals(actulString,"勇气的亚马逊");
    }
    @AfterClass
    public void quit(){
        doo.waitFor(3000);
        driver.close();
    }
}
