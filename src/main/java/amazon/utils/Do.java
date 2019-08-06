package amazon.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
*@Description: 封装的一个万能的Do类
*@Param:
*@return:
*@Author: haibao.wang
*@date:  2019/5/6
*/
public class Do {
    private WebDriver driver;
    private ScreenShot screenShot;
    //private ParseProperties locator = new ParseProperties( System.getProperty( "user.dir" ) + "\\files\\locators.properties" );
    private Wait waiter;

    public Do(WebDriver driver) {
        this.driver = driver;
        waiter = new Wait( driver );
        screenShot = new ScreenShot( driver );
    }

    public WebElement what(String locatorname) {
        //	return driver.findElement(By.xpath(locator.getValue(locatorname)));
        return driver.findElement( By.xpath( locatorname ) );
    }
    public WebElement whatc(String locatorname) {
        return driver.findElement( By.cssSelector( locatorname ) );
    }
    public List<WebElement> whats(String locatorname) {
        return driver.findElements( By.xpath( locatorname ) );
    }

    //等待元素出来,即判断页面上的元素是否存在
    public void waitForElementPresent(String locatorname) {
        //waiter.waitForElementPresent(locator.getValue(locatorname));
        waiter.waitForElementPresent( locatorname );
    }

    //判断页面元素是否在页面上可用和可被单击
    public void waitForElementIsEnable(String locatorname) {
        //waiter.waitForElementIsEnable(locator.getValue(locatorname));
        waiter.waitForElementIsEnable( locatorname );
    }

    //固定等待时长
    public void waitFor(long timeout) {
        waiter.waitFor( timeout );
    }

    /**
     * @return
     * @Author haibao.wang
     * @Description //截图的方法
     * @Date
     * @Param testCaseName：用例名字
     **/
    public void takeScreenShot(String testCaseName) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMdd_hhmmss" );
        String time = sdf.format( date.getTime() );
        String fileName = testCaseName + "_" + time + ".png";
        String savePath = System.getProperty( "user.dir" ) + "/screenShot/";
        String saveTarget = savePath + fileName;
        this.getTargetPath( saveTarget );
    }

    //获取目标保存路径
    private void getTargetPath(String screenPath) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs( OutputType.FILE );
        try {
            FileUtils.copyFile( srcFile, new File( screenPath ) );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
