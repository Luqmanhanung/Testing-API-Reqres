package Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static final String BASE_URL = "https://reqres.in";
    public static final String GET_LIST_USERS = BASE_URL+"/api/users?page={page}";
    public static final String GET_LIST_RESOURCES = BASE_URL+"/api/unknown?page={page}";
    public static final String POST_CREATE_USER = BASE_URL+"/api/users/";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/JsonFile";

    @Step("Get list user with valid parameter")
    public void getListUserWithValidParameter(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Get list user with invalid parameter")
    public void getListUserWithInvalidParameter(String page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Get list Resource with valid parameter")
    public void getListResourceWithValidParameter(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Post create user")
    public void postCreateUser(File jsonFile){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonFile);



    }
}
