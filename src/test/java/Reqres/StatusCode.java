package Reqres;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class StatusCode {
    @Steps
    ReqresAPI reqresAPI;

    @Then("API should return response {int} OK")
    public void apiShouldReturnResponseOK(int statusCodeOK) {
        SerenityRest.then()
                .statusCode(statusCodeOK);
    }

    @Then("Api should return response {int} Created")
    public void statusCodeShouldBeCreated(int statusCodeCreated) {
        SerenityRest.then()
                .statusCode(statusCodeCreated);
    }

    @Then("API should return response {int} Not Found")
    public void apiShouldReturnResponseNotFound(int statusCodeNotFound) {
        SerenityRest.then()
                .statusCode(statusCodeNotFound);
    }

    @Then("API should return response {int} BAD REQUEST")
    public void apiShouldReturnResponseBADREQUEST(int statusCodeBadRequest) {
        SerenityRest.then()
                .statusCode(statusCodeBadRequest);
    }

    @Then("API should return response status code {int} Service Unavailable")
    public void apiShouldReturnResponseStatusCodeServiceUnavailable(int statusCodeServiceUnavailable) {
        SerenityRest.then()
                .statusCode(statusCodeServiceUnavailable);
    }

    @Then("API should return response {int} NO CONTENT")
    public void apiShouldReturnResponseNOCONTENT(int statusCodeNoContent) {
        SerenityRest.then()
                .statusCode(statusCodeNoContent);
    }
}
