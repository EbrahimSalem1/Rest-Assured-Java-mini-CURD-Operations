package Suites;
import base.ReqresBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utili.CommonMethods;

public class ReqresTests extends ReqresBase {


    @Test(priority = 0, description = "GET method with List of users")
    public void getFewFirstNamesTest() {

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/users?page=2");

        // Retrieve the body of the Response
        ResponseBody body = response.getBody();
        RestAssured
                .given()
                .spec(CommonMethods.conformToRequestSpec())
                .when()
                .then()
                .spec(CommonMethods.conformToResponseSpec(200, "application/json"))
                .body("data.first_name", Matchers.hasItems("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel"));

        String bodyAsString = body.asString();
        Assert.assertEquals(bodyAsString.contains("Michael") /*Expected value*/, true /*Actual Value*/, "Response body contains Michael");

        //To Display a body Response if you want
        //System.out.println("Response Body is: " + body.asString());
    }


    @Test(priority = 1, description = "POST method for Creating a new user")
    public void createUserTest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Joe Cameron");
        jsonObject.put("job", "Software Tester");

        JSONObject responseObject = new JSONObject();
        responseObject.put("name", "Joe Cameron");
        responseObject.put("job", "AI Evangelist");
        responseObject.put("id", "134");
        responseObject.put("createdAt", "2024-04-21T03:01:35.282Z");

//        RequestSpecification httpRequest = RestAssured.given();
//        Response request = httpRequest.post("/users");
//        ResponseBody body = request.getBody();

        RestAssured
                .given()
                .spec(CommonMethods.conformToRequestSpec())
                .body(jsonObject.toJSONString())
                .when()
                .post("/users")
                .then()
                .log().all()
                .spec(CommonMethods.conformToResponseSpec(201, "application/json"))
                .extract().response().body().asString().equals(responseObject.toJSONString());

        //To Display a body Response if you want
        //System.out.println("Response Body is: " + body.asString());
    }


    @Test(priority = 2, description = "PUT method for updating an existing user")
    public void updateUserPutTest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Ebrahim Salem");
        jsonObject.put("job", "Software Engineer in Test Automation");

        JSONObject responseObject = new JSONObject();
        responseObject.put("name", "Ebrahim Mohamed");
        responseObject.put("job", "Software Engineer in Test Automation");
        responseObject.put("updatedAt", "2024-04-21T03:15:07.054Z");

        RequestSpecification httpRequest = RestAssured.given();
        Response request = httpRequest.put("/users/2");

        ResponseBody body = request.getBody();

        RestAssured
                .given()
                .spec(CommonMethods.conformToRequestSpec())
                .body(jsonObject.toJSONString())
                .when()
                .put("/users/2")
                .then()
                .log().all()
                .spec(CommonMethods.conformToResponseSpec(200, "application/json"))
                .extract().response().body().asString().equals(responseObject.toJSONString());

        //To Display a body Response if you want
        //System.out.println("Response Body is: " + body.asString());
    }

}