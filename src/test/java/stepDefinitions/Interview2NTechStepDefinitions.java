package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.Pages;
import utilities.Driver;
import utilities.GlobalVars;
import utilities.ReusableMethods;

import java.nio.file.Paths;
import java.util.List;

import static utilities.Driver.driver;

public class Interview2NTechStepDefinitions {
    Pages pages = new Pages();
    Actions actions = new Actions(driver);

    @Given("Ziyaretci 2NHaber anasayfasına gider")
    public void ziyaretci_2n_haber_anasayfasına_gider() {
        Driver.getDriver().get(GlobalVars.url);
        String pageTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(pageTitle.contains(GlobalVars.expectedPageTitle));
    }
    @Then("Navbarda bulunan elementlere tiklar ve dogru sayfanin acildigini kontrol eder")
    public void navbarda_bulunan_elementlere_tiklar_ve_dogru_sayfanin_acildigini_kontrol_eder() throws InterruptedException {

        List<WebElement> navbarElements = pages.navbarElements;
        // Her bir element için döngü
        for (WebElement navItem : navbarElements) {
            // Tıklamadan önce element textini al
            String expectedTitle = navItem.getText();
            System.out.println(expectedTitle);

            // Elementi görünür hale getir ve tıkla
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", navItem);
            navItem.click();

            // Sayfa yüklenmesi için kısa bekleme
            ReusableMethods.wait(1);

            // Sayfa başlığını kontrol et
            String actualTitle = driver.getTitle();
            System.out.println(actualTitle);
            Assert.assertTrue("Sayfa başlığı beklenen değeri içermiyor: " + expectedTitle,
                    actualTitle.toLowerCase().contains(expectedTitle.toLowerCase()));
            driver.navigate().back();
        }
    }

    @Given("Arama cubuguna {string} yazar")
    public void arama_cubuguna_yazar(String aranacakKelime) throws InterruptedException {
        pages.searchIcon.click();
        pages.searchInputBox.sendKeys(aranacakKelime);
        pages.searchInputBox.sendKeys(Keys.ENTER);

        ReusableMethods.wait(1);

    }
    @Then("Cikan sonuclardan {int}'inci haberin detaylarına bakar")
    public void cikan_sonuclardan_inci_haberin_detaylarına_bakar(Integer haberNumarasi) throws InterruptedException {
        String haberXPath = "(//*[@class='entry-title cmsmasters-widget-title__heading'])[" + haberNumarasi + "]";
        WebElement istenenHaber = driver.findElement(By.xpath(haberXPath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", istenenHaber);
        ReusableMethods.wait(1);
        ReusableMethods.clickElementUsingJS(driver, istenenHaber);
        ReusableMethods.wait(1);
        String pageSource = driver.getPageSource().toLowerCase();
        Assert.assertTrue(pageSource.contains(GlobalVars.aranacakKelime.toLowerCase()));
        ReusableMethods.wait(1);
    }

    @Given("Ziyaretci 2NTech HR sayfasına gider")
    public void ziyaretci_2n_tech_hr_sayfasına_gider() {
        Driver.getDriver().get(GlobalVars.hrUrl);
        String pageTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(pageTitle.contains(GlobalVars.expectedHrPageTitle));
    }
    @Given("Basvuru formunun ilk sayfasını doldurur")
    public void basvuru_formunun_ilk_sayfasını_doldurur() throws InterruptedException {
        actions.click(pages.adSoyad).sendKeys("Murat ATEŞ")
                .sendKeys(Keys.TAB).sendKeys("01/01/1987")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("29626758274")
                .sendKeys(Keys.TAB).sendKeys("05412372040")
                .sendKeys(Keys.TAB).sendKeys("mates204@gmail.com")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        // 3 saniye bekleme
        ReusableMethods.wait(3);

        // Dosya yolunu belirtme

        String filePath = "C:\\Users\\mates\\OneDrive\\Desktop\\CVs\\Yeni klasör\\Murat  ATES.pdf";
        pages.fileUpload.sendKeys(Paths.get(filePath).toString());

        // Sonraki sayfaya geçiş
        pages.sonrakiSayfa.click();
    }
    @Given("Basvuru sayfasının ikinci sayfasına gecer ve {string} pozisyonunu secer")
    public void basvuru_sayfasının_ikinci_sayfasına_gecer_ve_pozisyonunu_secer(String position) {
        String positionXpath = "//*[text()='"+position+"']";
        WebElement positionElement = driver.findElement(By.xpath(positionXpath));
        positionElement.click();
        pages.gonderButonu.click();
    }
    @Then("Formun basarili bir sekilde gonderildigini kontrol eder")
    public void formun_basarili_bir_sekilde_gonderildigini_kontrol_eder() {
        Assert.assertTrue(pages.basariliFormGonder.isDisplayed());
    }

}
