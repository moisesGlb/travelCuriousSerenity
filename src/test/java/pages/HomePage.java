package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.GlobalConfig;

import java.util.List;

public class HomePage extends PageObject {

    @FindBy(xpath = "//div[@id='covid']//i")
    private WebElementFacade closeCovidBanner;

    @FindBy(xpath = "//div[@id='cookies']//i")
    private WebElementFacade closeCookiesBanner;

    @FindBy(xpath = "//div[@class='tour ']//div[@class='content']//a[@class='name']")
    private List<WebElementFacade> tourNames;

    public void getHomePage(){
        getDriver().get(GlobalConfig.TRAVEL_CURIOUS_URL);
    }

    public void closeBanners(){
        waitFor(ExpectedConditions.elementToBeClickable(closeCovidBanner));
        closeCovidBanner.click();
        waitFor(ExpectedConditions.elementToBeClickable(closeCookiesBanner));
        closeCookiesBanner.click();
    }

    public boolean isTourInHomePage(String tourName){
        int i=0;
        for (i=0;i<tourNames.size();i++){
            if (tourNames.get(i).getText().equalsIgnoreCase(tourName)){
                tourNames.get(i).click();
                return true;
            }
        }
        return false;
    }
}
