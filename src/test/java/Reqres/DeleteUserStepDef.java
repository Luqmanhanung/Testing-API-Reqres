package Reqres;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete user with id {int}")
    public void deleteUserWithIdIdInt(int id) {
        reqresAPI.deleteUserIntId(id);
    }

    @Given("Delete user with id {string}")
    public void deleteUserWithIdIdString(String id) {
        reqresAPI.deleteUserStringId(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when()
                .delete(ReqresAPI.DELETE_USER);
    }
}
