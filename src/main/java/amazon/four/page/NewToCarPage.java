package amazon.four.page;

import amazon.utils.Do;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * ��ע��
 *
 * @author Lenovo
 * @Title: NewToCarPage
 * @ProjectName amazon
 * @Description: TODO
 * @date 2019/5/616:01
 */
public class NewToCarPage {
    private WebDriver driver;
    private Do doo;

    public NewToCarPage(WebDriver driver) {
        this.driver = driver;
        doo = new Do( driver );
    }

    //���빺�ﳵ
    public void addToCar(String locatorName) {
        doo.what( locatorName ).click();
    }
    //ѡ��ߴ�
    public void getSelectSize(String loctorName,int i) {
//        Select select = new Select(size);
//        select.selectByIndex(i);
        Select select = new Select( (WebElement) doo.whats( loctorName ) );
        select.selectByIndex(i);
    }
}
