package amazon.four.page;

import amazon.utils.Do;
import org.openqa.selenium.WebDriver;

/**
 * ��ע��
 *
 * @author Lenovo
 * @Title: NewChoosePage
 * @ProjectName amazon
 * @Description: TODO
 * @date 2019/5/616:00
 */
public class NewChoosePage {
    private WebDriver driver;
    private Do doo;

    //���췽��
    public NewChoosePage(WebDriver driver) {
        this.driver = driver;
        doo = new Do( driver );
    }

    //����ѡ��һ˫
    public void getShoes(String loctorName) {
        doo.whats( loctorName ).get( 0 ).click();
    }
}
