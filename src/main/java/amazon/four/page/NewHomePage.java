package amazon.four.page;

import amazon.utils.Do;
import org.openqa.selenium.WebDriver;

/**
 * ��ע��
 *
 * @author Lenovo
 * @Title: NewHomePage
 * @ProjectName amazon
 * @Description: �µ���ҳ��
 * @date 2019/5/610:52
 */
public class NewHomePage {
    private WebDriver driver;
    private Do doo;

    //���췽��
    public NewHomePage(WebDriver driver) {
        this.driver = driver;
        doo = new Do( driver );
    }

    /**
     * @Description: ���ص�ǰhomepage��
     * @Param: url:Ҫ��������URL��ַ
     * @return:
     * @Author: haibao.wang
     * @date: 2019/5/6
     */
    public NewHomePage navigateToUrl(String url) {
        driver.get( url );
        //�����ҳ��ֱ�ӷ��أ����Եȼ����Ϊ: PageFactory.initElements(driver, this);
        return this;
    }

    /**
     * @Description: �����ת����¼����
     * @Param:
     * @return:
     * @Author: haibao.wang
     * @date: 2019/5/6
     */
    public void setGoToLogin(String locatorName) {
        doo.what( locatorName ).click();
    }
}
