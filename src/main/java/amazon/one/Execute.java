package amazon.one;

/**
 * @author ：haibao.wang
 * @date ：Created in 2019/5/1 8:56
 * @description：
 * @modified By：
 * @version: $
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import amazon.utils.browsers.Browsers;
import amazon.utils.browsers.BrowserEnum;
import java.io.UnsupportedEncodingException;
import java.util.List;

class ChromeStart {
    public static WebDriver driver;

    //启动谷歌浏览器
    public void startChrome() {
//        System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
//
//        driver = new ChromeDriver();
        Browsers browser = new Browsers(BrowserEnum.CHROME);
        driver = browser.driver;
    }

    //将浏览器窗口最大化
    public void maxWindow() {
        driver.manage().window().maximize();
    }

    //导航到亚马逊网站
    public void getUrl() {
        //driver.navigate().to("https://www.amazon.cn/");
        driver.get("https://www.amazon.cn/");
    }

    //跳转到登录界面
    public void goTo() {
        WebElement eleto = driver.findElement(By.xpath("//a[@id='nav-your-amazon']"));
        eleto.click();
    }

    //登录亚马逊网站
    public void login() {
        String loginButton= "//input[@id='ap_email']";
        String loginText = "user";
        String passWord = "//input[@id='ap_password']";
        String passwText = "password";
        String clickButton = "//input[@id='signInSubmit']";
        WebElement eleName = driver.findElement(By.xpath(loginButton));
        eleName.sendKeys(loginText);//输入自己的用户名
        WebElement elePassword = driver.findElement(By.xpath(passWord));
        elePassword.sendKeys(passwText);//输入自己的密码
        WebElement elelogin = driver.findElement(By.xpath(clickButton));
        elelogin.click();
//        ScreenShot ss = new ScreenShot(driver);
//        ss.takeScreenShot("Login");
//        //ss.takeScreenShot("take","login");
    }

    //搜索鞋的品牌阿迪达斯，男士
    public void input() {
        WebElement eleInput = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        String search = "adidas";
        try {
            String newSearch = new String(search.getBytes(),"UTF-8");
            eleInput.sendKeys(newSearch);
            WebElement eleSubmit = driver.findElement(By.xpath("//input[@class='nav-input']"));
            eleSubmit.click();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //增加筛选条件为鞋靴
    public void choose() {
        WebElement eleSelect = driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select select = new Select(eleSelect);
        select.selectByIndex(33);
    }
    //在右侧点击鞋靴
  public void chooseSecond(){
       WebElement eleSel = driver.findElement(By.xpath("//span[@class='a-size-base a-color-base' and text()='男鞋']"));
       eleSel.click();
  }
    //选择喜欢的一双鞋，查看其详细信息
    public void look() {
/*        WebElement eleShooe = driver.findElement(By.xpath("//span[@class='a-color-secondary']"));
        eleShooe.click();*/
     /*   WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//select[@class='a-native-dropdown']"));
            }
        }).isDisplayed();*/
        List<WebElement> elements = null;
        //定位当前页面的所有鞋的元素
        elements = driver.findElements(By.xpath("//img[@class='s-image' and contains(@src,'.jpg')]"));
        elements.get(0).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //跳转到新的窗口
    public void gotoNewWindow() {
        String strOldHandle = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            if (winHandle.equals(strOldHandle)) {
                continue;
            }
            //这句必须有，否则winsows窗体依然会跳转回原窗体
            driver.close();
            driver.switchTo().window(winHandle);
            break;
        }
    }

    //进入详细详情界面选择尺寸
    public static void chooseSize() {

        WebElement eleSize = driver.findElement(By.xpath("//select[@class='a-native-dropdown']"));
        Select selectSize = new Select(eleSize);
        selectSize.selectByIndex(1);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //加入购物车
    public void ShoopingCar() {
        WebElement shooping = driver.findElement(By.xpath(".//*[@id='add-to-cart-button']"));
        shooping.click();
    }

    //在做一次导航跳转
    public void gotoNextWindow() {
        String stroNextHandle = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            if (winHandle.equals(stroNextHandle)) {
                continue;
            }
            driver.close();
            driver.switchTo().window(winHandle);
            break;
        }
    }

    //进行结算
    public void settle() throws InterruptedException {
        Thread.sleep(4000);
        WebElement eleSettle = driver.findElement(By.xpath(".//*[@id='hlb-ptc-btn']"));
        eleSettle.click();
    }
}

public class Execute {
    public static void main(String[] args) {
        ChromeStart cs = new ChromeStart();
        cs.startChrome();
        cs.maxWindow();
        cs.getUrl();
        cs.goTo();
        cs.login();
        cs.input();
        cs.choose();
        cs.chooseSecond();
        cs.look();
        cs.gotoNewWindow();
        cs.chooseSize();
        cs.ShoopingCar();
      //  cs.gotoNextWindow();
        try {
            cs.settle();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
