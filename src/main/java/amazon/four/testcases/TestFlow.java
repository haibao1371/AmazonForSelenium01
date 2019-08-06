package amazon.four.testcases;

import amazon.four.locator.Data;
import amazon.four.locator.Loctors;
import amazon.four.page.*;
import amazon.utils.browsers.BrowserEnum;
import amazon.utils.browsers.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 类注释
 *
 * @author Lenovo
 * @Title: TestFlow
 * @ProjectName amazon
 * @Description: TODO 我的第一个测试用例
 * @date 2019/5/616:52
 */
public class TestFlow {
    private WebDriver driver;
    private NewHomePage nhp;
    private NewLoginPage nlp;
    private NewSelectPage nsp;
    private NewChoosePage ncp;
    private NewToCarPage ntcp;
    private NewSettlePage nsep;

    @BeforeClass
    public void init() {
        Browsers browser = new Browsers( BrowserEnum.EDGE );
        driver = browser.driver;
        driver.manage().window().maximize();
        nhp = new NewHomePage( driver );
        nlp = new NewLoginPage( driver );
        nsp = new NewSelectPage( driver );
        ncp = new NewChoosePage( driver );
        ntcp = new NewToCarPage( driver );
        nsep = new NewSettlePage( driver );
    }

    /**
     * @Description: TODO 测试全流程的一个测试用例
     * @Param:
     * @return:
     * @Author: haibao.wang
     * @date: 2019/5/6
     */
    @Test
    public void testForFlow() {
        nhp.navigateToUrl( Data.URL );
        nhp.setGoToLogin( Loctors.GOTOLOGIN );
        nlp.setPhone( Loctors.USERNAME, Data.USER );
        nlp.setPassword( Loctors.PASSWORD, Data.PASS );
        nlp.login( Loctors.LOGIN );
        //  Assert.assertEquals( "勇气的亚马逊","勇气的亚马逊" );
        nsp.input( Loctors.SEARCH, Data.SEARCHTEXT );
        nsp.getSelect( Loctors.SELECT, 33 );
        nsp.click( Loctors.CLICKBUTTON );
        Reporter.log( "reportng日志显示" );

    }

    @AfterClass
    public void quit() {
        //  driver.close();
    }
}
