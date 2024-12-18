package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
        Bu classın amacı belirlenen browser'a uygun WebDriver objesi oluşturmaktır
     */

    private Driver(){

    }

    public static  WebDriver driver;

    public static WebDriver getDriver(){

        /*
            Browser'in sadece chrome olmamasi icin
            configuration.properties'e browser = firefox
            secenegi ekledik.
            Orada yazan browser tercihini 22.satirda alip
            tercihe uygun driver olusturmasi icin
            bir switch statement kullandik
         */

        String browser = GlobalVars.browser;

        if (driver == null){
            switch (browser){
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case"edge":
                    WebDriverManager.edgedriver().setup();
                    driver= new EdgeDriver();
                    break;
                case"safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
