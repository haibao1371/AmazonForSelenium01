package amazon.utils.browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author ：海哥
 * @date ：Created in 2019/3/2 10:43 AM
 * @description：启动mac自带的safari浏览器
 * @modified By：
 * @version: 1.0.0
 */
public class StartSafari {
    private WebDriver driver = null;
    private Capabilities caps = null;
    private WebElement element=null;
    @BeforeTest
    public void startSafari(){
        driver = new SafariDriver();
        driver.navigate().to("http://www.baidu.com");
        driver.manage().window().maximize();
    }
    @Test
    public void loginBaidu(){
        element = driver.findElement(By.name("wd"));
        element.sendKeys("selenium3.0");
        element.submit();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @AfterClass
    public void closeSafari(){
        driver.close();
    }

}
