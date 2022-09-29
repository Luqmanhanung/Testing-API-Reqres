package Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.module.jsv.JsonSchemaValidator;

public class ReqresStepDefs {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with page {int}")
    public void getListUserWithParameter(int page) {
        reqresAPI.getListUserWithValidParameter(page);
    }
    @Given("Get single user with id {int}")
    public void getSingleUserWithIdId(int id) {
        reqresAPI.getSingleUserWithValidId(id);
    }

    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidId(String id) {
        reqresAPI.getSingleUserWithInvalidId(id);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when()
                .get(ReqresAPI.GET_LIST_USERS);

    }

    @When("Send request get single user")
    public void sendRequest() {
        SerenityRest.when()
                .get(ReqresAPI.GET_SINGLE_USER);
    }

    @Then("API should return response {int} OK")
    public void apiShouldReturnResponseOK(int statusCodeOK) {
        SerenityRest.then()
                .statusCode(statusCodeOK);
    }

    @And("Response body should contain id {int}, firstname {string}, lastname {string} and email {string}")
    public void responseBodyShouldContainFirstnameAndLastname(int id, String firstname, String lastname, String email) {
        SerenityRest.then()
                .body(ReqresResponse.IDLISTUSER,equalTo(id))
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
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/ValidCreateUser.json");
        reqresAPI.postCreateUser(jsonFiles);
    }

    @Given("Post create new user with invalid json file")
    public void postCreateNewUserWithInvalidJsonFile() {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/InvalidCreateUser.json");
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

    @Given("get list resource with valid page {int}")
    public void getSingleResourceWithPage(int page) {
        reqresAPI.getListResourceWithValidParameter(page);
    }

    @Given("get list resource with invalid page {string}")
    public void getListResourceWithInvalidPage(String page) {
        reqresAPI.getListResourceWithInvalidParameter(page);
    }

    @Given("get single resource with page {string}")
    public void getSingleResourceWithPage(String page) {
        reqresAPI.getListResourceWithInvalidParameter(page);
    }

    @When("Send request get list resources")
    public void sendRequestGetListResource() {
        SerenityRest.when()
                .get(ReqresAPI.GET_LIST_RESOURCES);
    }

    @When("Send request get single resource")
    public void sendRequestGetSingleResource() {
        SerenityRest.when()
                .get(ReqresAPI.GET_SINGLE_RESOURCE);
    }

    @Then("Response body should contain id {int}, name {string}, year {int}, color {string}, and pantone_value {string}")
    public void responseBodyShouldContainIdNameYearColorAndPantone_value(int id, String name, int year, String color, String pantoneValue) {
        SerenityRest.then()
                .body(ReqresResponse.IDLISTRESOURCES,equalTo(id))
                .body(ReqresResponse.NAMELISTRESOURCES,equalTo(name))
                .body(ReqresResponse.YEARLISTRESOUCES,equalTo(year))
                .body(ReqresResponse.COLOR,equalTo(color))
                .body(ReqresResponse.PANTONEVALUE,equalTo(pantoneValue));
    }

    @Given("register new user with valid json file")
    public void registerNewUserWithValidJsonFile() {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/RegisterUserSuccessful.json");
        reqresAPI.postCreateUser(jsonFiles);
    }

    @When("When Send request post register user")
    public void whenSendRequestPostRegisterUser() {
        SerenityRest.when()
                .post(ReqresAPI.REGISTER_USER);
    }

    @And("Response body should contain id {int} and token {string}")
    public void responseBodyShouldContainIdAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponse.IDREGISTER,equalTo(id))
                .body(ReqresResponse.TOKENREGISTER,equalTo(token));
    }

    @Given("register new user with invalid json file")
    public void registerNewUserWithInvalidJsonFile() {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/RegisterUserUnsuccessful.json");
        reqresAPI.postCreateUser(jsonFiles);
    }

    @Then("API should return response {int} BAD REQUEST")
    public void apiShouldReturnResponseBADREQUEST(int statusCodeBadRequest) {
        SerenityRest.then()
                .statusCode(statusCodeBadRequest);
    }

    @And("Response body should contain error message {string}")
    public void responseBodyShouldContainErrorMessage(String errorMessage) {
        SerenityRest.then()
                .body(ReqresResponse.ERRORMESSAGE,equalTo(errorMessage));
    }

    @Given("login user with valid json file")
    public void loginUserWithValidJsonFile() {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/LoginUserSuccessful.json");
        reqresAPI.postCreateUser(jsonFiles);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when()
                .post(ReqresAPI.LOGIN_USER);
    }

    @And("Response body should contain token {string}")
    public void responseBodyShouldContainToken(String token) {
        SerenityRest.then()
                .body(ReqresResponse.TOKENLOGIN,equalTo(token));
    }

    @Given("login user with invalid json file")
    public void loginUserWithInvalidJsonFile() {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/LoginUserUnsuccessful.json");
        reqresAPI.postCreateUser(jsonFiles);
    }

    @Given("Get list user with delay {int}")
    public void getListUserWithDelayParameter(int delay) {
        reqresAPI.getListUserWithValidParameterDelay(delay);
    }

    @Then("API should return response status code {int}")
    public void apiShouldReturnResponseStatusCode(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @When("Send request get single user with delay")
    public void sendRequestGetSingleUserWithDelay() {
        SerenityRest.when()
                .get(ReqresAPI.GET_LIST_USERS_WITH_DELAY);
    }

    @Given("Put update user with id {int} and with valid json file")
    public void putUpdateUserWithIdIdAndWithValidJsonFile(int id) {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/RequestBody/ValidPutUpdateUser.json");
        reqresAPI.putUpdateUser(jsonFiles,id);
    }
    @Given("Put update user with invalid id {string} and with valid json file")
    public void putUpdateUserWithInvalidIdIdAndWithValidJsonFile(String id) {
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

    @Given("Patch update user with id {int} and with valid json file")
    public void patchUpdateUserWithIdAndWithValidJsonFile(int id) {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/RequestBody/PatchUser.json");
        reqresAPI.patchUpdateUser(jsonFile,id);
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

    @Given("Delete user with id {int}")
    public void deleteUserWithIdIdInt(int id) {
        reqresAPI.deleteUser(id);
    }
    @Given("Delete user with id {string}")
    public void deleteUserWithIdIdString(String id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when()
                .delete(ReqresAPI.DELETE_USER);
    }

    @Then("API should return response {int} NO CONTENT")
    public void apiShouldReturnResponseNOCONTENT(int statusCodeNoContent) {
        SerenityRest.then()
                .statusCode(statusCodeNoContent);
    }

    @And("Get list user assert json validation")
    public void getListUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/GetListUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Post create user assert json validation")
    public void postCreateUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/PostCreateUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));

    }

    @And("Get list resource assert json validation")
    public void getListResourceAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/GetListResourceJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Post register user assert json validation")
    public void postRegisterUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/RegisterUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Post login user assert json validation")
    public void postLoginUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/LoginUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Put update user assert json validation")
    public void putUpdateUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/UpdateUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Post register and login user error message missing password assert json validation")
    public void postRegisterUserErrorMessageMissingPasswordAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/InvalidRegisterUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


    @And("Response body should contain id {int}")
    public void responseBodyShouldContainIdId(int id) {
        SerenityRest.then()
                .body(ReqresResponse.IDSINGLEUSER,equalTo(id));
    }

    @And("Get single user assert json validation")
    public void getSingleUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/GetSingleUserJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }


    @Given("Get single resource with id {int}")
    public void getSingleResourceWithIdId(int id) {
        reqresAPI.getSingleResourceWithValidParameter(id);
    }

    @Given("Get single resource with invalid id {string}")
    public void getSingleResourceWithInvalidId(String id) {
        reqresAPI.getSingleResourceWithInvalidParameter(id);
    }

    @And("Get single resource assert json validation")
    public void getSingleResourceAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/JsonSchemaValidation/GetSingleResourceJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Then("Response body should contain name {string}, color {string}, and pantone_value {string}")
    public void responseBodyShouldContainNameColorAndPantone_value(String name, String color, String pantoneValue) {
        SerenityRest.then()
                .body(ReqresResponse.NAMELISTRESOURCES,equalTo(name))
                .body(ReqresResponse.COLOR,equalTo(color))
                .body(ReqresResponse.PANTONEVALUE,equalTo(pantoneValue));
    }
}
