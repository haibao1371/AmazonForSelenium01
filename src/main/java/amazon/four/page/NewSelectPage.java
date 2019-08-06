package amazon.four.page;

import amazon.utils.Do;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * ��ע��
 *
 * @author Lenovo
 * @Title: NewSelectPage
 * @ProjectName amazon
 * @Description: TODO
 * @date 2019/5/615:50
 */
public class NewSelectPage {
    private WebDriver driver;
    private Do doo;

    public NewSelectPage(WebDriver driver) {
        this.driver = driver;
        doo = new Do( driver );
    }

    //���뷽��
    public void input(String loctorName, String searchText) {
        doo.what( loctorName ).sendKeys( searchText );
    }
    //�������
    public void click(String loctorName) {
        doo.what( loctorName );
    }
    //��ȡ������ѡ��Ьѥ
    public void getSelect(String loctorName,int i) {
        Select select = new Select(doo.whatc( loctorName ) );
        select.selectByIndex(i);
    }
    //�����
    public void leftClick(String loctorName) {
        doo.what( loctorName ).click();
    }
}
