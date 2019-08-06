package amazon.utils.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author ：haibao.wang
 * @date ：Created in 2019/4/7 18:44
 * @description：启动windows10自带的浏览器Microsoft Edge
 * @modified By：
 * @version: $
 */
public class StartEdge {
    private WebDriver driver  = null;
    @BeforeTest
    public void initBrowser(){
        System.setProperty("webdriver.edge.driver","drivers/MicrosoftWebDriver.exe");
        driver = new EdgeDriver();
    }
    @Test
    public void startEdge(){
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com");
        String str = driver.getTitle();//获取主题
        System.out.println(str);
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
