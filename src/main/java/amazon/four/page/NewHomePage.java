package amazon.four.page;

import amazon.utils.Do;
import org.openqa.selenium.WebDriver;

/**
 * 类注释
 *
 * @author Lenovo
 * @Title: NewHomePage
 * @ProjectName amazon
 * @Description: 新的主页面
 * @date 2019/5/610:52
 */
public class NewHomePage {
    private WebDriver driver;
    private Do doo;

    //构造方法
    public NewHomePage(WebDriver driver) {
        this.driver = driver;
        doo = new Do( driver );
    }

    /**
     * @Description: 返回当前homepage；
     * @Param: url:要导航到的URL地址
     * @return:
     * @Author: haibao.wang
     * @date: 2019/5/6
     */
    public NewHomePage navigateToUrl(String url) {
        driver.get( url );
        //将这个页面直接返回，可以等价理解为: PageFactory.initElements(driver, this);
        return this;
    }

    /**
     * @Description: 点击跳转到登录界面
     * @Param:
     * @return:
     * @Author: haibao.wang
     * @date: 2019/5/6
     */
    public void setGoToLogin(String locatorName) {
        doo.what( locatorName ).click();
    }
}
