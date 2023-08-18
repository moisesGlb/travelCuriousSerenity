package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TourDetailPage extends PageObject {

    @FindBy(xpath = "//div[@id='title']//span[1]")
    private WebElementFacade tourPageTitle;

    @FindBy(xpath = "//section[@id='breadcrumbs-currency']//div[@class='form-element-select']")
    private WebElementFacade curencyDropdownBtn;

    @FindBy(xpath = "//section[@id='breadcrumbs-currency']//div[@class='form-element-options']//div[1]")
    private WebElement GBPcurrencyOption;

    @FindBy(xpath = "//input[@readonly='readonly']")
    private WebElement dateSelection;

    @FindBy(xpath = "//span[@aria-label='September 30, 2023']")
    private WebElement daySelection;

    @FindBy(xpath = "(//span[@class='form-element-text'])[2]")
    private WebElement time;

    @FindBy(xpath = "//div[contains(text(),'12:30')]")
    private WebElement timeToSelect;

    @FindBy(xpath = "//div[@class='participants-summary']")
    private WebElement visitorsComboBox;

    @FindBy(xpath = "(//button[@class='inc'])[1]")
    private WebElement incrementAdultVisitor;

    @FindBy(xpath = "(//button[@class='inc'])[2]")
    private WebElement incrementChildrenVisitor;

    @FindBy(xpath = "(//span[@class='rate'])[2]")
    private WebElement packagePrice;


    public WebElementFacade getPageTitle(){
        waitFor(ExpectedConditions.visibilityOf(tourPageTitle));
        return tourPageTitle;
    }

    public void selectPoundsCurrency(){
        curencyDropdownBtn.click();
        waitFor(ExpectedConditions.elementToBeClickable(GBPcurrencyOption));
        GBPcurrencyOption.click();
    }

    public void clickOnDateSelection(){
        waitFor(ExpectedConditions.visibilityOf(dateSelection));
        dateSelection.click();
    }

    public void clickOnDaySelection(){
        waitFor(ExpectedConditions.visibilityOf(daySelection));
        daySelection.click();
    }

    public void clickOnTime(){
        time.click();
    }

    public void selectTime(){
        waitFor(ExpectedConditions.visibilityOf(timeToSelect));
        timeToSelect.click();
    }

    public void clickOnVisitorsComboBox(){
        visitorsComboBox.click();
    }

    public void addAdultVisitor(){
        waitFor(ExpectedConditions.elementToBeClickable(incrementAdultVisitor));
        incrementAdultVisitor.click();
    }

    public void addChildrenVisitor(){
        waitFor(ExpectedConditions.elementToBeClickable(incrementChildrenVisitor));
        incrementChildrenVisitor.click();
    }

    public String getPackagePrice() {
        waitFor(ExpectedConditions.visibilityOf(packagePrice));
        return packagePrice.getText();
    }
}
