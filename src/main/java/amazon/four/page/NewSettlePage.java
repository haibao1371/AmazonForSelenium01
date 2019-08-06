package amazon.four.page;

import amazon.utils.Do;
import org.openqa.selenium.WebDriver;

/**
 * 类注释
 *
 * @author Lenovo
 * @Title: NewSettlePage
 * @ProjectName amazon
 * @Description: TODO
 * @date 2019/5/616:01
 */
public class NewSettlePage {
    private WebDriver driver;
    private Do doo;

    //构造方法
    public NewSettlePage(WebDriver driver) {
        this.driver = driver;
        doo = new Do( driver );
    }

    public void settleClick(String locatorName) {
        doo.what( locatorName ).click();
        System.out.println( "真的要结算啦，就到这里啦" );

    }
}
