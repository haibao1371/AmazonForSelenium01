package amazon.four.page;

import amazon.utils.Do;
import org.openqa.selenium.WebDriver;

/**
 * ��ע��
 *
 * @author Lenovo
 * @Title: NewLoginPage
 * @ProjectName amazon
 * @Description: �µĵ�¼����
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
     * @Description: ���������ֻ��ŵķ���
     * @Param:
     * @return:
     * @Author: haibao.wang
     * @date: 2019/5/6
     */
    public void setPhone(String loctorName, String logPhone) {
        doo.what( loctorName ).sendKeys( logPhone );
    }

    /**
     * @Description: TODO ������������Ĳ�������
     * @Param:
     * @return:
     * @Author: haibao.wang
     * @date: 2019/5/6
     */
    public void setPassword(String loctorName, String logPassword) {
        doo.what( loctorName ).sendKeys( logPassword );
    }

    /**
     * @Description: �����¼����
     * @Param:
     * @return:
     * @Author: haibao.wang
     * @date: 2019/5/6
     */
    public void login(String loctorName) {
        doo.what( loctorName ).click();
    }
}
