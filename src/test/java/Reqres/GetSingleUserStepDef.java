package Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with id {int}")
    public void getSingleUserWithIdId(int id) {
        reqresAPI.getSingleUserWithValidId(id);
    }

    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidId(String id) {
        reqresAPI.getSingleUserWithInvalidId(id);
    }

    @When("Send request get single user")
    public void sendRequest() {
        SerenityRest.when()
                .get(ReqresAPI.GET_SINGLE_USER);
    }



    @And("Response body should contain id {int}")
    public void responseBodyShouldContainIdId(int id) {
        SerenityRest.then()
                .body(ReqresResponse.ID_SINGLE_USER,equalTo(id));
    }
    @And("Get single user assert json validation")
    public void getSingleUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/GetSingleUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
