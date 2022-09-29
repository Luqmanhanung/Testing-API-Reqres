package Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.io.File;

public class ReqresAPI {
    public static final String BASE_URL = "https://reqres.in";
    public static final String GET_LIST_USERS = BASE_URL+"/api/users?page={page}";
    public static final String GET_SINGLE_USER = BASE_URL+"/api/users/{id}";
    public static final String GET_LIST_RESOURCES = BASE_URL+"/api/unknown?page={page}";
    public static final String GET_SINGLE_RESOURCE = BASE_URL+"/api/unknown/{id}";
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
    @Step("Get Single user with valid id")
    public void getSingleUserWithValidId(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get Single user with invalid id")
    public void getSingleUserWithInvalidId(String id){
        SerenityRest.given()
                .pathParam("id", id);
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
    @Step("Get list Resource with valid parameter")
    public void getListResourceWithValidParameter(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Get list Resource with invalid parameter")
    public void getListResourceWithInvalidParameter(String page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Get single Resource with valid id")
    public void getSingleResourceWithValidParameter(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get single Resource with invalid id")
    public void getSingleResourceWithInvalidParameter(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Post create user")
    public void postCreateUser(File jsonFile){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Step("Put update user (int id)")
    public void putUpdateUser(File jsonFile, int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Step("Put update user (String id)")
    public void putUpdateUser(File jsonFile, String id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Step("Put update user without json file (int id)")
    public void putUpdateUserWithoutJsonFile(int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON);
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
    @Step("Delete user String id")
    public void deleteUser(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }
}
