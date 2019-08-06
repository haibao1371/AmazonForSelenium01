import java.io.IOException;
import java.util.Properties;

/**
 * @author ：haibao.wang
 * @date ：Created in 2019/5/3 9:50
 * @description：测试下properties类
 * @modified By：
 * @version: $
 */
public class TestPro {
    public static void main(String[] args){
        Properties prp = new Properties();
        try {
            prp.load(TestPro.class.getResourceAsStream("data.properties"));
            String url = prp.getProperty("url");
            String userName = prp.getProperty("username");
            String passWord = prp.getProperty("password");
            String Text = prp.getProperty("searchText");
            System.out.println(url+userName+passWord+Text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
