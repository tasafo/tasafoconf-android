package org.tasafo.tasafoconf.io.json.model;

import java.io.Serializable;

/**
 * Created by ramonrabello on 13/11/15.
 */
public class Location implements Serializable {

    private double latitude;
    private double longitude;
    private String name;
    private String address;

    public Location(){}

    public Location(double latitude, double longitude, String name, String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
