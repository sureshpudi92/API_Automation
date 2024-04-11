
package api.tests;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.utilities.DataProviders;

public class DDTest {


    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String UserID, String userName, String fname, String lname, String email, String password, String phone) {

        User userPayload = new User();
        userPayload.setId(Integer.parseInt(UserID));
        userPayload.setUsername(userName);
        userPayload.setFirstname(fname);
        userPayload.setLastname(lname);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);

        Response response = UserEndPoints.CreateUser(userPayload);
        Assert.assertEquals(response.getStatusCode(), 200);


    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUser(String userName) {

        Response response = UserEndPoints.DeleteUser(userName);
        Assert.assertEquals(response.getStatusCode(), 200);


    }
}
