package io.cucumber.skeleton.Utils;

import io.cucumber.skeleton.Enums.ApiResources;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;

import static io.cucumber.skeleton.Builder.TestDataBuild.getGlobalValue;

public class TestUtils {
    public static RequestSpecification requestSpecification;

    protected static String getResourceValue( String resource) {
        return switch (resource) {
            case "AddPlaceApi" -> ApiResources.ADD_PLACE_API.getResource();
            case "DeletePlaceApi" -> ApiResources.DELETE_PLACE_API.getResource();
            case "GetPlaceApi" -> ApiResources.GET_PLACE_API.getResource();
            default -> null;
        };
    }

    public RequestSpecification requestSpecification() throws IOException {
        if (requestSpecification == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            requestSpecification = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).
                    addFilter(RequestLoggingFilter.logRequestTo(log)).
                    addFilter(ResponseLoggingFilter.logResponseTo(log)).
                    setContentType(ContentType.JSON).build();
            return requestSpecification;
        }
        return requestSpecification;
    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }
}
