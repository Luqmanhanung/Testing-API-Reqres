package Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostLoginStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("login user with valid json file")
    public void loginUserWithValidJsonFile() {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/LoginUserSuccessful.json");
        reqresAPI.postCreateRegisterLoginUser(jsonFiles);
    }

    @Given("login user with invalid json file")
    public void loginUserWithInvalidJsonFile() {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/LoginUserUnsuccessful.json");
        reqresAPI.postCreateRegisterLoginUser(jsonFiles);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when()
                .post(ReqresAPI.LOGIN_USER);
    }

    @And("Response body should contain token {string}")
    public void responseBodyShouldContainToken(String token) {
        SerenityRest.then()
                .body(ReqresResponse.TOKEN_LOGIN,equalTo(token));
    }

    @And("Post login user assert json validation")
    public void postLoginUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/LoginUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

}
