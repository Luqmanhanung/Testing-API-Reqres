package Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.io.File;

public class ReqresAPI {
    public static final String BASE_URL = "https://reqres.in";
    public static final String GET_LIST_USERS = BASE_URL+"/api/users?page={page}";
    public static final String GET_LIST_RESOURCES = BASE_URL+"/api/unknown?page={page}";
    public static final String GET_LIST_USERS_WITH_DELAY = BASE_URL+"/api/users?delay={delay}";
    public static final String POST_CREATE_USER = BASE_URL+"/api/users/";
    public static final String PUT_UPDATE_USER = BASE_URL+"/api/users/{id}";
    public static final String PATCH_UPDATE_USER = BASE_URL+"/api/users/{id}";
    public static final String DELETE_USER = BASE_URL+"/api/users/{id}";
    public static final String REGISTER_USER = BASE_URL+"/api/register";
    public static final String LOGIN_USER =BASE_URL+"/api/login";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/JsonFile";

    @Step("Get list user with valid parameter")
    public void getListUserWithValidParameter(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Get list user with valid parameter (delay)")
    public void getListUserWithValidParameterDelay(int delay){
        SerenityRest.given()
                .pathParam("delay", delay);
    }

    @Step("Get list user with invalid parameter")
    public void getListUserWithInvalidParameter(String page){
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Get list Resource with invalid parameter")
    public void getListResourceWithInvalidParameter(String page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Post create user")
    public void postCreateUser(File jsonFile){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }
    @Step("Put update user")
    public void putUpdateUser(File jsonFile, int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }
    @Step("Patch update user")
    public void patchUpdateUser(File jsonFile, int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
}
