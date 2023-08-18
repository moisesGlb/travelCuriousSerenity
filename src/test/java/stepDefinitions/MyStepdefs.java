package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.HomePage;
import pages.TourDetailPage;

public class MyStepdefs {

    @Page
    HomePage homePage;

    @Page
    TourDetailPage tourDetailPage;

    @Given("a customer that navigates to the home page of travelcurious")
    public void customerNavigatesToHomePageTravelcurious(){
        homePage.getHomePage();
        homePage.closeBanners();
    }

    @When("the customer look for the tour: {string} and click on it")
    public void theCustomerLookForTheTourAndClickOnIt(String tourName) {
        if(!homePage.isTourInHomePage(tourName)){
            Assert.fail("The experience you are looking for could not be found on the home page");
        }
    }

    @And("the tourDetails Page is displayed")
    public void theTourDetailsPageIsDisplayed() {
        Assert.assertTrue(tourDetailPage.getPageTitle().isVisible());
    }

    @And("the user change the currency to GBP")
    public void theUserChangeTheCurrency() {
        tourDetailPage.selectPoundsCurrency();
    }

    @And("the user select the date September 30")
    public void theUserSelectTheMonthAndDay() {
        tourDetailPage.clickOnDateSelection();
        tourDetailPage.clickOnDaySelection();
    }

    @And("the user select the time 12:30")
    public void theUserSelectTheTime() {
        tourDetailPage.clickOnTime();
        tourDetailPage.selectTime();
    }

    @And("the user select 3 adults and 2 children attending the tour")
    public void theUserSelectTheAttendingTheTour() {
        tourDetailPage.clickOnVisitorsComboBox();
        tourDetailPage.addAdultVisitor();
        tourDetailPage.addChildrenVisitor();
    }

    @Then("the tour info is displayed with a specific price {string}")
    public void theTourInfoIsDisplayedWithASpecificPrice(String price){
        Assert.assertEquals(tourDetailPage.getPackagePrice(),price);
    }
}
