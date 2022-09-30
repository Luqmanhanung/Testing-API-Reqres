package Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostCreateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post create new user with valid json file")
    public void postCreateNewUserWithValidJsonFile() {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/ValidCreateUser.json");
        reqresAPI.postCreateRegisterLoginUser(jsonFiles);
    }

    @Given("Post create new user with invalid json file")
    public void postCreateNewUserWithInvalidJsonFile() {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/InvalidCreateUser.json");
        reqresAPI.postCreateRegisterLoginUser(jsonFiles);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when()
                .post(ReqresAPI.POST_CREATE_USER);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponse.NAME,equalTo(name))
                .body(ReqresResponse.JOB,equalTo(job));
    }

    @And("Post create user assert json validation")
    public void postCreateUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/PostCreateUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));

    }

}
