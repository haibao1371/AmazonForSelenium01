package amazon.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
    public WebDriver driver;

    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }

    //获取目标保存路径
    private void getTargetPath(String screenPath) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(screenPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     * @Author haibao.wang
     * @Description //截图的方法
     * @Date
     * @Param testCaseName：用例名字
     **/
    public void takeScreenShot(String testCaseName) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmmss");
        String time = sdf.format(date.getTime());
        String fileName = testCaseName + "_" + time + ".png";
        String savePath = System.getProperty("user.dir") + "/screenShot/";
        String saveTarget = savePath + fileName;
        this.getTargetPath(saveTarget);
    }
}
