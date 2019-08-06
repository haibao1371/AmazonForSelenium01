package amazon.four.page;

import amazon.utils.Do;
import org.openqa.selenium.WebDriver;

/**
 * 类注释
 *
 * @author Lenovo
 * @Title: NewLoginPage
 * @ProjectName amazon
 * @Description: 新的登录界面
 * @date 2019/5/611:15
 */
public class NewLoginPage {
    private WebDriver driver;
    private Do doo;

    public NewLoginPage(WebDriver driver) {
        this.driver = driver;
        doo = new Do( driver );
    }

    /**
     * @Description: 定义输入手机号的方法
     * @Param:
     * @return:
     * @Author: haibao.wang
     * @date: 2019/5/6
     */
    public void setPhone(String loctorName, String logPhone) {
        doo.what( loctorName ).sendKeys( logPhone );
    }

    /**
     * @Description: TODO 定义输入密码的操作方法
     * @Param:
     * @return:
     * @Author: haibao.wang
     * @date: 2019/5/6
     */
    public void setPassword(String loctorName, String logPassword) {
        doo.what( loctorName ).sendKeys( logPassword );
    }

    /**
     * @Description: 定义登录操作
     * @Param:
     * @return:
     * @Author: haibao.wang
     * @date: 2019/5/6
     */
    public void login(String loctorName) {
        doo.what( loctorName ).click();
    }
}
