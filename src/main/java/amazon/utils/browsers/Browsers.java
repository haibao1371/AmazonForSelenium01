package amazon.utils.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author ：mmzs
 * @date ：Created in 2019/3/2 8:01 PM
 * @description：封装所有的枚举类
 * @modified By：
 * @version: $
 */
public class Browsers {
    public WebDriver driver = null;
    private String projectPath = System.getProperty("user.dir");//代表相对路径可要可不要
    private BrowserEnum browserEnum = null;
    public Browsers(BrowserEnum browserEnum){
        switch (browserEnum){
            case CHROME:
                System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;
            case FIREFOX:
                System.setProperty("webdriver.firefox.marionette", "drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case SAFARI:
                driver = new SafariDriver();
                driver.manage().window().maximize();
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver","drivers/MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                driver.manage().window().maximize();

        }
    }

}
