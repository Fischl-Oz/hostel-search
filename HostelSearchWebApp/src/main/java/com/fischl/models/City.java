package com.fischl.models;

public class City {
    private String city_id;
    private String city_name;

    public City() {
    }

    public City(String city_id, String city_name) {
        this.city_id = city_id;
        this.city_name = city_name;
    }

    public String getCityId() {
        return city_id;
    }

    public void setCityId(String cityId) {
        this.city_id = cityId;
    }

    public String getCityName() {
        return city_name;
    }

    public void setCityName(String cityName) {
        this.city_name = cityName;
    }
}
