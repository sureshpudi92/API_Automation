package api.endpoints;
import api.payloads.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class UserEndPoints {

   public static Response CreateUser(
           User Payload){

       Response response= given()
                .contentType("application/json")
                .accept("application/json")
                .body(Payload)

                .when()
                .post(Routes.post_url);
       return response;

    }

    public static Response GetUser(String userName){

        Response response= given()
                .pathParam("username",userName)

                .when()
                .get(Routes.get_url);
        return response;

    }
    public static Response UpdateUser(String userName ,User Payload){

        Response response= given()
                .contentType("application/json")
                .accept("application/json")
                .pathParam("username",userName)
                .body(Payload)

                .when()
                .put(Routes.update_url);
        return response;

    }
    public static Response DeleteUser(String userName){

        Response response= given()
                .pathParam("username",userName)

                .when()
                .delete(Routes.delete_url);
        return response;

    }
}
