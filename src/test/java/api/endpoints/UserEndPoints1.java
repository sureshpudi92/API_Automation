package api.endpoints;
import api.payloads.User;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPoints1 {

    public static ResourceBundle getURL(){
      ResourceBundle routes = ResourceBundle.getBundle("routes"); //load propertifile// file name
        return routes;
    }

   public static Response CreateUser(User Payload){

        String post_url=getURL().getString("post_url");

       Response response= given()
                .contentType("application/json")
                .accept("application/json")
                .body(Payload)

                .when()
                .post(post_url);
       return response;

    }

    public static Response GetUser(String userName){
        String get_url=getURL().getString("get_url");
        Response response= given()
                .pathParam("username",userName)

                .when()
                .get(get_url);
        return response;

    }
    public static Response UpdateUser(String userName ,User Payload){
        String update_url=getURL().getString("update_url");
        Response response= given()
                .contentType("application/json")
                .accept("application/json")
                .pathParam("username",userName)
                .body(Payload)

                .when()
                .put(update_url);
        return response;

    }
    public static Response DeleteUser(String userName){
        String delete_url=getURL().getString("delete_url");
        Response response= given()
                .pathParam("username",userName)

                .when()
                .delete(delete_url);
        return response;

    }
}
