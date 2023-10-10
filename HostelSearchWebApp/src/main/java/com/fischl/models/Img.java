package com.fischl.models;

public class Img {
    private int img_id;
    private String img_name;
    private String img_uri;
    private String img_desc;
    private int user_id;
    private int hostel_id;

    public Img() {
    }

    public Img(int img_id, String img_name, String img_uri, String img_desc, int user_id, int hostel_id) {
        this.img_id = img_id;
        this.img_name = img_name;
        this.img_uri = img_uri;
        this.img_desc = img_desc;
        this.user_id = user_id;
        this.hostel_id = hostel_id;
    }

    public int getImgId() {
        return img_id;
    }

    public void setImgId(int imgId) {
        this.img_id = imgId;
    }

    public String getImgName() {
        return img_name;
    }

    public void setImgName(String imgName) {
        this.img_name = imgName;
    }

    public String getImgUri() {
        return img_uri;
    }

    public void setImgUri(String imgUri) {
        this.img_uri = imgUri;
    }

    public String getImgDesc() {
        return img_desc;
    }

    public void setImgDesc(String imgDesc) {
        this.img_desc = imgDesc;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public int getHostelId() { return hostel_id; }

    public void setHostelId(int hostel_id) { this.hostel_id = hostel_id; }
}
