package amazon.four.locator;

/**
 * @Author haibao.wang
 * @Description //�����еĶ�λ��Ϣ�������ƾ�̬���������ڽӿ��У�
 * @Date
 * @Param
 * @return
 **/
public interface Loctors {
    //��ת��¼��ť"�ҵ�����ѷ"_xpath
    public String GOTOLOGIN = "//a[@id='nav-your-amazon']";
    //�û���_xpath
    public String USERNAME = "//input[@id='ap_email']";
    //����_xpath
    public String PASSWORD = "//input[@id='ap_password']";
    //��¼_xpath
    public String LOGIN = "//input[@id='signInSubmit']";
    //����_xpath
    public String SEARCH = "//input[@id='twotabsearchtextbox']";
    //�����ύ_xpath
    public String CLICKBUTTON = "//input[@class='nav-input']";
    //ѡ��ɸѡ��_cssSelector
    public String SELECT = "#searchDropdownBox";
    //�����ఴť_xpath
    public String SHOOES = "//span[@class='a-size-base a-color-base' and text()='��Ь']";
    //��λһ��Ь_xpath
    public String SHOOESPATH = "//img[@class='s-image' and contains(@src,'.jpg')]";
    //ѡ��ߴ�_xpath
    public String SIZE = "//select[@class='a-native-dropdown']";
    //���빺�ﳵ_xpath
    public String ADDTOCAR = ".//*[@id='add-to-cart-button']";
    //���н���_xpath
    public String SETTLE =".//*[@id='hlb-ptc-btn']";
}
