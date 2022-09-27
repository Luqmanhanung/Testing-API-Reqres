package Reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ReqresAPI {
    public static final String BASE_URL = "https://reqres.in";
    public static final String GET_LIST_USERS = BASE_URL+"/api/users?page={page}";

    @Step("Get list user")
    public void getListUser(String page){
        SerenityRest.given()
                .pathParam("page", page);
    }
}
