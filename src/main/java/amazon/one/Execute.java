package amazon.one;

/**
 * @author ��haibao.wang
 * @date ��Created in 2019/5/1 8:56
 * @description��
 * @modified By��
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

    //�����ȸ������
    public void startChrome() {
//        System.setProperty("webdriver.chrome.driver", "files\\chromedriver.exe");
//
//        driver = new ChromeDriver();
        Browsers browser = new Browsers(BrowserEnum.CHROME);
        driver = browser.driver;
    }

    //��������������
    public void maxWindow() {
        driver.manage().window().maximize();
    }

    //����������ѷ��վ
    public void getUrl() {
        //driver.navigate().to("https://www.amazon.cn/");
        driver.get("https://www.amazon.cn/");
    }

    //��ת����¼����
    public void goTo() {
        WebElement eleto = driver.findElement(By.xpath("//a[@id='nav-your-amazon']"));
        eleto.click();
    }

    //��¼����ѷ��վ
    public void login() {
        String loginButton= "//input[@id='ap_email']";
        String loginText = "user";
        String passWord = "//input[@id='ap_password']";
        String passwText = "password";
        String clickButton = "//input[@id='signInSubmit']";
        WebElement eleName = driver.findElement(By.xpath(loginButton));
        eleName.sendKeys(loginText);//�����Լ����û���
        WebElement elePassword = driver.findElement(By.xpath(passWord));
        elePassword.sendKeys(passwText);//�����Լ�������
        WebElement elelogin = driver.findElement(By.xpath(clickButton));
        elelogin.click();
//        ScreenShot ss = new ScreenShot(driver);
//        ss.takeScreenShot("Login");
//        //ss.takeScreenShot("take","login");
    }

    //����Ь��Ʒ�ư��ϴ�˹����ʿ
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

    //����ɸѡ����ΪЬѥ
    public void choose() {
        WebElement eleSelect = driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select select = new Select(eleSelect);
        select.selectByIndex(33);
    }
    //���Ҳ���Ьѥ
  public void chooseSecond(){
       WebElement eleSel = driver.findElement(By.xpath("//span[@class='a-size-base a-color-base' and text()='��Ь']"));
       eleSel.click();
  }
    //ѡ��ϲ����һ˫Ь���鿴����ϸ��Ϣ
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
        //��λ��ǰҳ�������Ь��Ԫ��
        elements = driver.findElements(By.xpath("//img[@class='s-image' and contains(@src,'.jpg')]"));
        elements.get(0).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //��ת���µĴ���
    public void gotoNewWindow() {
        String strOldHandle = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            if (winHandle.equals(strOldHandle)) {
                continue;
            }
            //�������У�����winsows������Ȼ����ת��ԭ����
            driver.close();
            driver.switchTo().window(winHandle);
            break;
        }
    }

    //������ϸ�������ѡ��ߴ�
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

    //���빺�ﳵ
    public void ShoopingCar() {
        WebElement shooping = driver.findElement(By.xpath(".//*[@id='add-to-cart-button']"));
        shooping.click();
    }

    //����һ�ε�����ת
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

    //���н���
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
