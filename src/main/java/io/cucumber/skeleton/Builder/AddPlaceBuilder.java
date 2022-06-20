package io.cucumber.skeleton.Builder;

import io.cucumber.skeleton.Pojo.AddPlace;
import io.cucumber.skeleton.Pojo.Location;

import java.util.List;

public class AddPlaceBuilder {

    private int accuracy;
    private String name;
    private String phone_number;
    private String address;
    private String website;
    private String language;
    private Location location;
    private List<String> types;

    public int getAccuracy() {
        return accuracy;
    }

    public AddPlaceBuilder setAccuracy(int accuracy) {
        this.accuracy = accuracy;
        return this;
    }

    public String getName() {
        return name;
    }

    public AddPlaceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public AddPlaceBuilder setPhone_number(String phone_number) {
        this.phone_number = phone_number;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AddPlaceBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public AddPlaceBuilder setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public AddPlaceBuilder setLanguage(String language) {
        this.language = language;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public AddPlaceBuilder setLocation(Location location) {
        this.location = location;
        return this;
    }

    public List<String> getTypes() {
        return types;
    }

    public AddPlaceBuilder setTypes(List<String> types) {
        this.types = types;
        return this;
    }

    public AddPlace build(){
        return new AddPlace(accuracy,name,phone_number,address,website,language,location,types);
    }
}
