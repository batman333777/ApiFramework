package io.cucumber.skeleton.Builder;

import io.cucumber.skeleton.Pojo.AddPlace;
import io.cucumber.skeleton.Pojo.Location;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestDataBuild {

    protected static Properties properties = new Properties();

    protected static double longitude = 33.427362;
    protected static double latitude = -38.383494;
    protected static String phoneNumber = "(+91) 983 893 3937";
    protected static String storeType = "shoe Park";
    protected static int meters = 50;


    public AddPlace addPlacePayload(String name, String language, String address) {
        List<String> storeTypeList = new ArrayList<>();
        storeTypeList.add(storeType);

        AddPlace addPlace = new AddPlaceBuilder().setAccuracy(meters).setAddress(address).
                setLanguage(language).setPhone_number(phoneNumber).setWebsite(getGlobalValue("baseUrl")).
                setName(name).setTypes(storeTypeList).build();

        Location location = new LocationBuilder().setLat(latitude).
                setLng(longitude).build();
        addPlace.setLocation(location);
        return addPlace;
    }

    public String deletePlacePayload(String placeId) {
        return "{\r\n    \"place_id\":\"" + placeId + "\"\r\n}";
    }

    public static String getGlobalValue(String key) {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/java/io/cucumber/skeleton/Properties/Global.properties")) {
            properties.load(fileInputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
