package amazon.four.locator;

/**
 * @Author haibao.wang
 * @Description //将所有的定位信息都声明称静态常量保存在接口中：
 * @Date
 * @Param
 * @return
 **/
public interface Loctors {
    //跳转登录按钮"我的亚马逊"_xpath
    public String GOTOLOGIN = "//a[@id='nav-your-amazon']";
    //用户名_xpath
    public String USERNAME = "//input[@id='ap_email']";
    //密码_xpath
    public String PASSWORD = "//input[@id='ap_password']";
    //登录_xpath
    public String LOGIN = "//input[@id='signInSubmit']";
    //搜索_xpath
    public String SEARCH = "//input[@id='twotabsearchtextbox']";
    //搜索提交_xpath
    public String CLICKBUTTON = "//input[@class='nav-input']";
    //选择筛选类_cssSelector
    public String SELECT = "#searchDropdownBox";
    //点击左侧按钮_xpath
    public String SHOOES = "//span[@class='a-size-base a-color-base' and text()='男鞋']";
    //定位一组鞋_xpath
    public String SHOOESPATH = "//img[@class='s-image' and contains(@src,'.jpg')]";
    //选择尺寸_xpath
    public String SIZE = "//select[@class='a-native-dropdown']";
    //加入购物车_xpath
    public String ADDTOCAR = ".//*[@id='add-to-cart-button']";
    //进行结算_xpath
    public String SETTLE =".//*[@id='hlb-ptc-btn']";
}
