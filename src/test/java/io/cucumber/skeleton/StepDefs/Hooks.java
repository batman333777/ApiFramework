package io.cucumber.skeleton.StepDefs;

import io.cucumber.java.Before;
import io.cucumber.skeleton.Enums.ApiResources;

import java.io.IOException;

import static io.cucumber.skeleton.Builder.TestDataBuild.getGlobalValue;

public class Hooks {
    StepDefinitions stepDefinitions = new StepDefinitions();
    static String methodType = "POST";
    static String addPlaceAPI = "AddPlaceApi";
    static String getPlaceApi = "GetPlaceApi";

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        if (StepDefinitions.place_id == null) {
            stepDefinitions.addPlacePayloadWith(getGlobalValue("TemporaryName"), getGlobalValue("TemporaryLanguage"), getGlobalValue("TemporaryCountry"));
            stepDefinitions.userCallsWithHttpRequest(addPlaceAPI, methodType);
            stepDefinitions.verifyPlace_IdCreatedMapsToUsing(getGlobalValue("TemporaryName"),getPlaceApi);
        }
    }
}
