package io.cucumber.skeleton.Builder;

import io.cucumber.skeleton.Pojo.Location;

public class LocationBuilder {

    private double lat;
    private double lng;


    public double getLat() {
        return lat;
    }

    public LocationBuilder setLat(double lat) {
        this.lat = lat;
        return this;
    }

    public double getLng() {
        return lng;
    }

    public LocationBuilder setLng(double lng) {
        this.lng = lng;
        return this;
    }

    public Location build(){
        return new Location(lat,lng);
    }
}
