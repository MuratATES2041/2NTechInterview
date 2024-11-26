package hooks;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import utilities.Driver;

public class Hooks {
    @Before
    public void setUp() {
        WebDriver driver = Driver.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            File srcFile = ts.getScreenshotAs(OutputType.FILE);

            // Screenshot kaydetme işlemleri
            // Dosya adı için tarih formatı
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String screenshotName = "screenshot_" + scenario.getName().replaceAll(" ", "_") + "_" + timestamp + ".png";

            // Ekran görüntüsünü kaydetme yolu
            String filePath = System.getProperty("user.dir") + "/target/screenshots/" + screenshotName;

            try {
                FileUtils.copyFile(srcFile, new File(filePath));
                System.out.println("Ekran görüntüsü kaydedildi: " + filePath);
            } catch (IOException e) {
                System.out.println("Ekran görüntüsü kaydedilirken hata oluştu: " + e.getMessage());
            }
        }
        Driver.quitDriver();
    }

}
