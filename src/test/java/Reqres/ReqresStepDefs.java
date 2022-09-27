package Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDefs {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with page {int}")
    public void getListUserWithParameter(int page) {
        reqresAPI.getListUserWithValidParameter(page);
    }

    @When("Send request get single user")
    public void sendRequest() {
        SerenityRest.when()
                .get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("API should return response {int} OK")
    public void apiShouldReturnResponseOK(int statusCodeOK) {
        SerenityRest.then()
                .statusCode(statusCodeOK);
    }

    @And("Response body should contain id {int}, firstname {string}, lastname {string} and email {string}")
    public void responseBodyShouldContainFirstnameAndLastname(int id, String firstname, String lastname, String email) {
        SerenityRest.then()
                .body(ReqresResponse.IDSINGLEUSER,equalTo(id))
                .body(ReqresResponse.FIRST_NAME,equalTo(firstname))
                .body(ReqresResponse.LAST_NAME,equalTo(lastname))
                .body(ReqresResponse.EMAIL,equalTo(email));
    }
    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then()
                .body("page", equalTo(page));
    }

    @Given("Post create new user with valid json file")
    public void postCreateNewUserWithValidJsonFile() {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/CreateUser.json");
        reqresAPI.postCreateUser(jsonFiles);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when()
                .post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int statusCodeCreated) {
        SerenityRest.then()
                .statusCode(statusCodeCreated);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponse.NAME,equalTo(name))
                .body(ReqresResponse.JOB,equalTo(job));
    }

    @Given("Get list user with page {string}")
    public void getListUserWithPage(String page) {
        reqresAPI.getListUserWithInvalidParameter(page);
    }

    @Then("API should return response {int} Not Found")
    public void apiShouldReturnResponseNotFound(int statusCodeNotFound) {
        SerenityRest.then()
                .statusCode(statusCodeNotFound);
    }

    @Given("get single resource with page {int}")
    public void getSingleResourceWithPage(int page) {
        reqresAPI.getListUserWithValidParameter(page);
    }

    @When("Send request get single resource")
    public void sendRequestGetSingleResource() {
        SerenityRest.when()
                .get(ReqresAPI.GET_LIST_RESOURCES);
    }

    @Then("Response body should contain name {string}, color {string}, and pantone_value {string}")
    public void responseBodyShouldContainIdNameYearColorAndPantone_value(String name, String color, String pantoneValue) {
        SerenityRest.then()
                .body(ReqresResponse.NAMESINGLERESOURCE,equalTo(name))
                .body(ReqresResponse.COLOR,equalTo(color))
                .body(ReqresResponse.PANTONEVALUE,equalTo(pantoneValue));
    }
}
