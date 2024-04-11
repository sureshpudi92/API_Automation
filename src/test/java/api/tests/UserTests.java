package api.tests;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class UserTests {
    Faker faker;
    User userpayload;

    public Logger logger;
    @BeforeClass
    public void setUpData(){
        faker=new Faker();
        userpayload=new User();

        userpayload.setId(faker.idNumber().hashCode());
        userpayload.setFirstname(faker.name().firstName());
        userpayload.setUsername(faker.name().username());
        userpayload.setLastname(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());
        userpayload.setPassword(faker.internet().password(5,10));
        userpayload.setPhone(faker.phoneNumber().cellPhone());
logger= LogManager.getLogger(this.getClass());
    }
    @Test(priority = 1)
    public void testPostUser(){
logger.info("************create User*********************");
        Response response=UserEndPoints.CreateUser(userpayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("user created succesffuly");
    }
    @Test(priority=2)
    public void getUserByName(){

        Response response=UserEndPoints.GetUser(this.userpayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }
@Test(priority=3)
    public void UpdateUserByName(){

        //update data
        userpayload.setFirstname(faker.name().firstName());
        userpayload.setLastname(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());


      Response response=  UserEndPoints.UpdateUser(this.userpayload.getUsername(),userpayload);
      response.then().log().body().statusCode(200);
      response.then().log().all();
    }
    @Test(priority=4)
public void DeleteUserByName(){

        Response response=UserEndPoints.DeleteUser(this.userpayload.getUsername());
        response.then().log().all();
    Assert.assertEquals(response.getStatusCode(),200);
}

}
