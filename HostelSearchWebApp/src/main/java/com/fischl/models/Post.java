package com.fischl.models;

import java.sql.Timestamp;

public class Post {
    private int post_id;
    private String post_title;
    private Timestamp post_date;
    private String post_content;
    private String post_status;
    private int hostel_id;
    private String district_id;

    public Post() {
    }

    public Post(int post_id, String post_title, Timestamp post_date, String post_content, String post_status, int hostel_id, String district_id) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.post_date = post_date;
        this.post_content = post_content;
        this.post_status = post_status;
        this.hostel_id = hostel_id;
        this.district_id = district_id;
    }

    public int getPostId() {
        return post_id;
    }

    public void setPostId(int postId) {
        this.post_id = postId;
    }

    public String getPostTitle() {
        return post_title;
    }

    public void setPostTitle(String postTitle) {
        this.post_title = postTitle;
    }

    public Timestamp getPostDate() {
        return post_date;
    }

    public void setPostDate(Timestamp postDate) {
        this.post_date = postDate;
    }

    public String getPostContent() {
        return post_content;
    }

    public void setPostContent(String postContent) {
        this.post_content = postContent;
    }

    public String getPostStatus() {
        return post_status;
    }

    public void setPostStatus(String postStatus) {
        this.post_status = postStatus;
    }

    public int getHostelId() {
        return hostel_id;
    }

    public void setHostelId(int hostelId) {
        this.hostel_id = hostelId;
    }

    public String getDistrictId() {
        return district_id;
    }

    public void setDistrictId(String districtId) {
        this.district_id = districtId;
    }
}
