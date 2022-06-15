package io.cucumber.skeleton.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.skeleton.Utils.TestUtils;
import io.cucumber.skeleton.Builder.TestDataBuild;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class StepDefinitions extends TestUtils {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpecification;
    Response response;
    TestDataBuild testDataBuild = new TestDataBuild();
    Logger logger = LoggerFactory.getLogger(StepDefinitions.class);

    public static String place_id;

    @Then("the API call got success with status code {int}")
    public void theAPICallGotSuccessWithStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String key, String value) {
        Assert.assertEquals(getJsonPath(response, key), value);
    }

    @Given("Add Place Payload with {string}  {string} {string}")
    public void addPlacePayloadWith(String name, String language, String address) throws IOException {
        requestSpec = given().spec(requestSpecification()).body(testDataBuild.addPlacePayload(name, language, address));
    }

    @When("user calls {string} with {string} http request")
    public void userCallsWithHttpRequest(String resource, String methodName) {
        if (methodName.equals("POST")) {
            response = requestSpec.when().post(getResourceValue(resource));
            logger.info("response is :" + response.asString());
        } else if (methodName.equals("GET")) {
            response = requestSpec.when().get(getResourceValue(resource));
            logger.info("response is :" + response.asString());
        }
    }

    @And("verify place_Id created maps to {string} using {string}")
    public void verifyPlace_IdCreatedMapsToUsing(String expectedName, String resource) throws IOException {
        place_id = getJsonPath(response, "place_id");
        requestSpec = given().spec(requestSpecification()).queryParam("place_id", place_id).queryParam("key", "qaclick123");
        logger.info("request specification is: " + requestSpec);
        userCallsWithHttpRequest(resource, "GET");
        String actualName = getJsonPath(response, "name");
        Assert.assertEquals(expectedName, actualName);
    }

    @Given("DeletePlace Payload")
    public void deleteplacePayload() throws IOException {
        requestSpec = given().spec(requestSpecification()).queryParam("key", "qaclick123").
                body(testDataBuild.deletePlacePayload(place_id));
    }
}
