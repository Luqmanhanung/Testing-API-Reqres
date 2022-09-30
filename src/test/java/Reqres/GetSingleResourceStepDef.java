package Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class GetSingleResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single resource with id {int}")
    public void getSingleResourceWithIdId(int id) {
        reqresAPI.getSingleResourceWithValidParameter(id);
    }

    @Given("Get single resource with invalid id {string}")
    public void getSingleResourceWithInvalidId(String id) {
        reqresAPI.getSingleResourceWithInvalidParameter(id);
    }

    @When("Send request get single resource")
    public void sendRequestGetSingleResource() {
        SerenityRest.when()
                .get(ReqresAPI.GET_SINGLE_RESOURCE);
    }

    @And("Get single resource assert json validation")
    public void getSingleResourceAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/GetSingleResourceJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
