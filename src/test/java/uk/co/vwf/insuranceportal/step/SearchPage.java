package uk.co.vwf.insuranceportal.step;


import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import uk.co.vwf.insuranceportal.common.Constant;
import uk.co.vwf.insuranceportal.common.DriverFactory;
import uk.co.vwf.insuranceportal.pageobject.VehicleSearch;

import java.util.List;

//@RunWith(Cucumber.class)
public class SearchPage {
    VehicleSearch vehicleSearch;

    @Given("^I am on dealer portal page$")
    public void landOnDealerPortalPage() throws Throwable {
        vehicleSearch = new VehicleSearch(DriverFactory.createDriver());
        vehicleSearch.loadPage(Constant.HOST_URL);
        System.out.println(Constant.HOST_URL);

    }

    @Then("^I see (.*) title of dealer search")
    public void headingMsg(String text) {
        Assert.assertEquals(true, vehicleSearch.isDealerSearchTitleDisplayed());
        Assert.assertEquals(text, vehicleSearch.getDealerSearchTitle());
    }

    @And("^ And I see Drive Away Insurance")
    public void HeadingSubMsg() throws Throwable {
        Assert.assertEquals(true, vehicleSearch.isDealerSearchTitleDisplayed());
        Assert.assertEquals("Drive Away Insurance", vehicleSearch.getDealerSearchTitle());
    }

    @And("^I see (.*) subtitle of dealer search")
    public void registrationMsgText(String text) throws Throwable {
        Assert.assertEquals(true, vehicleSearch.isDealerSearchSubTitleDisplaed());
        Assert.assertEquals("Please enter the vehicle registration", vehicleSearch.getDealerSearchSubTitle());
    }

    @When("^I enter Vehicle Registration no (.*)")
    public void enterRegistrationNo(String registrationNo) throws Throwable {
        Assert.assertEquals(true, vehicleSearch.isRegistrationNoTextFieldEditable());
        vehicleSearch.enterRegistrationNo(registrationNo);
    }

    @When("^I clear Vehicle Registration no input field")
    public void clearRegistrationInputField() throws Throwable {
        vehicleSearch.clearInput();
    }

    @Then("^I click on find vehicle button")
    public void clickOnFindVehicleButton() throws Throwable {
        vehicleSearch.clickOnFindVehicleButton();
    }

    @Then("^I see result")
    public void seeResult(DataTable result) {
        List<List<String>> data = result.raw();

        for (List row : data) {
            Assert.assertEquals(row.get(0), vehicleSearch.getResult());
            System.out.println(vehicleSearch.getResult());
            Assert.assertEquals(row.get(1), vehicleSearch.getResultStartDate());
            System.out.println(vehicleSearch.getResultStartDate());
            Assert.assertEquals(row.get(2), vehicleSearch.getResultEndDate());
            System.out.println(vehicleSearch.getResultEndDate());
        }
    }

    @Then("^I refresh page")
    public void pageRefresh() {
        vehicleSearch.pageRefresh();
    }

    @Then("^I see error msg (.*)")
    public void validateErrorMsg(String erroMsg) {
        Assert.assertEquals(erroMsg, vehicleSearch.getInputErrorMessage());
    }

}
