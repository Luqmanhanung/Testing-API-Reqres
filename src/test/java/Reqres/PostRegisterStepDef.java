package Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostRegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("register new user with valid json file")
    public void registerNewUserWithValidJsonFile() {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/RegisterUserSuccessful.json");
        reqresAPI.postCreateRegisterLoginUser(jsonFiles);
    }

    @Given("register new user with invalid json file")
    public void registerNewUserWithInvalidJsonFile() {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/RegisterUserUnsuccessful.json");
        reqresAPI.postCreateRegisterLoginUser(jsonFiles);
    }

    @When("When Send request post register user")
    public void whenSendRequestPostRegisterUser() {
        SerenityRest.when()
                .post(ReqresAPI.REGISTER_USER);
    }

    @And("Response body should contain id {int} and token {string}")
    public void responseBodyShouldContainIdAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponse.ID_REGISTER,equalTo(id))
                .body(ReqresResponse.TOKEN_REGISTER,equalTo(token));
    }

    @And("Post register user assert json validation")
    public void postRegisterUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/RegisterUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Response body should contain error message {string}")
    public void responseBodyShouldContainErrorMessage(String errorMessage) {
        SerenityRest.then()
                .body(ReqresResponse.ERROR_MESSAGE,equalTo(errorMessage));
    }

    @And("Post register and login user error message missing password assert json validation")
    public void postRegisterUserErrorMessageMissingPasswordAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/InvalidRegisterUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
