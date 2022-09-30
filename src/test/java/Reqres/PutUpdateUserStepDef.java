package Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class PutUpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Put update user with invalid id {string} and with valid json file")
    public void putUpdateUserWithInvalidIdIdAndWithValidJsonFile(String id) {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/ValidPutUpdateUser.json");
        reqresAPI.putUpdateUserStringId(jsonFiles,id);
    }

    @Given("Put update user with id {int} and with valid json file")
    public void putUpdateUserWithIdIdAndWithValidJsonFile(int id) {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/ValidPutUpdateUser.json");
        reqresAPI.putUpdateUser(jsonFiles,id);
    }

    @Given("Put update user with id {int} and without valid json file")
    public void putUpdateUserWithIdAndWithoutValidJsonFile(int id) {
        reqresAPI.putUpdateUserWithoutJsonFile(id);
    }

    @Given("Put update user with id {int} and with invalid json file")
    public void putUpdateUserWithIdAndWithInvalidJsonFile(int id) {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/InvalidPutUpdateUser.json");
        reqresAPI.putUpdateUser(jsonFiles,id);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when()
                .put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Put update user assert json validation")
    public void putUpdateUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/PutUpdateUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


}
