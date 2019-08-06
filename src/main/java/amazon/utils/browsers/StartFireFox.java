package amazon.utils.browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author ：海哥
 * @date ：Created in 2019/3/2 1:37 PM
 * @description：启动IE浏览器
 * @modified By：
 * @version: $
 */
public class StartFireFox {
    private WebDriver driver = null;
    private WebElement element = null;

    @BeforeTest
    public void initBrowser() {
        System.setProperty("webdriver.firefox.marionette", "drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.baidu.com");
    }

    @Test
    public void startFirefox() {
        element = driver.findElement(By.name("wd"));
        element.sendKeys("selenium3.0");
        element.submit();
        System.out.println("获得的主题为：" + driver.getTitle());

    }

    @AfterTest
    public void quitBrowser() {
        driver.quit();
    }
}

