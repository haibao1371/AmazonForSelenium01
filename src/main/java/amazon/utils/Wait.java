package amazon.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author 海宝 20180126
 * 这个类封装的是只智能等待时间
 */
public class Wait {
    private WebDriver driver;
    private int timeout = 10;

    // 构造函数
    public Wait(WebDriver driver) {
        this.driver = driver;
        // PageFactory.initElements(driver, this);
    }

    //等待元素出来,即判断页面上的元素是否存在
    public void waitForElementPresent(String locator) {
        (new WebDriverWait( driver, 10 )).until( ExpectedConditions.presenceOfElementLocated( By.xpath( locator ) ) );
    }

    //判断页面元素是否在页面上可用和可被单击
    public void waitForElementIsEnable(String locator) {
        (new WebDriverWait( driver, 10 )).until( ExpectedConditions.elementToBeClickable( By.xpath( locator ) ) );
    }

    //判断页面上是否包含特定的文本
    public void waitForText(String locator, String excepeText) {
        (new WebDriverWait( driver, 10 )).until( ExpectedConditions.textToBePresentInElement( By.xpath( locator ), excepeText ) );
    }

    //判断某个元素是否被选中，一般用于下拉框中
    public void waitForElementIsSelect(String locator) {
        (new WebDriverWait( driver, 10 )).until( ExpectedConditions.elementToBeSelected( By.xpath( locator ) ) );
    }

    public void waitFor(long timeout) {
        try {
            Thread.sleep( timeout );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
