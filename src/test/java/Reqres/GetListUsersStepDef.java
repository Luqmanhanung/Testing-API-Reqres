package Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetListUsersStepDef {
    @Steps

    ReqresAPI reqresAPI;

    @Given("Get list user with page {int}")
    public void getListUserWithParameter(int page) {
        reqresAPI.getListUserWithValidParameter(page);
    }

    @Given("Get list user with page {string}")
    public void getListUserWithPage(String page) {
        reqresAPI.getListUserWithInvalidParameter(page);
    }

    @Given("Get list user with time delay {int} second")
    public void getListUserWithTimeDelayParameter(int delay) {
        reqresAPI.getListUserWithValidParameterDelay(delay);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when()
                .get(ReqresAPI.GET_LIST_USERS);
    }

    @When("Send request get list users with delay")
    public void sendRequestGetSingleUserWithDelay() {
        SerenityRest.when()
                .get(ReqresAPI.GET_LIST_USERS_WITH_DELAY);
    }

    @And("Response body should contain id {int}, firstname {string}, lastname {string} and email {string}")
    public void responseBodyShouldContainFirstnameAndLastname(int id, String firstname, String lastname, String email) {
        SerenityRest.then()
                .body(ReqresResponse.ID_LIST_USER,equalTo(id))
                .body(ReqresResponse.FIRST_NAME,equalTo(firstname))
                .body(ReqresResponse.LAST_NAME,equalTo(lastname))
                .body(ReqresResponse.EMAIL,equalTo(email));
    }
    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then()
                .body("page", equalTo(page));
    }

    @And("Get list user assert json validation")
    public void getListUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/GetListUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


}
