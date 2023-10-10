package com.fischl.models;

public class District {
    private String district_id;
    private String district_name;
    private String city_id;

    public District() {
    }

    public District(String district_id, String district_name, String city_id) {
        this.district_id = district_id;
        this.district_name = district_name;
        this.city_id = city_id;
    }

    public String getDistrictId() {
        return district_id;
    }

    public void setDistrictId(String districtId) {
        this.district_id = districtId;
    }

    public String getDistrictName() {
        return district_name;
    }

    public void setDistrictName(String districtName) {
        this.district_name = districtName;
    }

    public String getCityId() {
        return city_id;
    }

    public void setCityId(String cityId) {
        this.city_id = cityId;
    }
}
