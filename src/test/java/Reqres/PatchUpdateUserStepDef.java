package Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PatchUpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Patch update user with id {int} and with valid json file")
    public void patchUpdateUserWithIdAndWithValidJsonFile(int id) {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/RequestBody/PatchUpdateNameUser.json");
        reqresAPI.patchUpdateUserIdInt(jsonFile,id);
    }

    @Given("Patch update user with id {string} and with valid json file")
    public void patchUpdateUserWithIdAndWithValidJsonFile(String id) {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/RequestBody/PatchUpdateNameUser.json");
        reqresAPI.patchUpdateUserIdString(jsonFile,id);
    }

    @When("Send request patch update user")
    public void sendRequestPatchUpdateUser() {
        SerenityRest.when()
                .patch(ReqresAPI.PATCH_UPDATE_USER);
    }

    @And("Patch Response body should contain name {string}")
    public void patchResponseBodyShouldContainName(String name) {
        SerenityRest.then()
                .body(ReqresResponse.NAME,equalTo(name));
    }

    @And("Patch update user assert json validation")
    public void patchUpdateUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/PatchUpdateUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
