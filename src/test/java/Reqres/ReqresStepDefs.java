package Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDefs {
    ReqresAPI reqresAPI;

    @Given("Get list user with parameter {string}")
    public void getListUserWithParameter(String page) {
        reqresAPI.getListUser(page);
    }

    @When("Send request")
    public void sendRequest() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("API should return response {int} OK")
    public void apiShouldReturnResponseOK(int statusCodeOK) {
        SerenityRest.then().statusCode(statusCodeOK);
    }

    @And("Response body should contain firstname {string} and lastname {string}")
    public void responseBodyShouldContainFirstnameAndLastname(String firstname, String lastname) {
        SerenityRest.then()
                .body(ReqresResponse.FIRST_NAME,equalTo(firstname))
                .body(ReqresResponse.LAST_NAME,equalTo(lastname));
    }
}
