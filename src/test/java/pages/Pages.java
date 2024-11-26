package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Pages {

    public Pages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[@id='menu-1-5dc673f1']/li")
    public List<WebElement> navbarElements;
    @FindBy(xpath = "//*[@class='e-font-icon-svg e-fas-search']")
    public WebElement searchIcon;
    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchInputBox;
    @FindBy(id = "name")
    public WebElement adSoyad;
    @FindBy(id = "cv_field")
    public WebElement fileUpload;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement sonrakiSayfa;
    @FindBy(xpath = "//*[text()='Gönder']")
    public WebElement gonderButonu;
    @FindBy(xpath = "//*[text()='Form Başarı ile gönderildi. Katıldığınız için teşekkür ederiz.']")
    public WebElement basariliFormGonder;
}
