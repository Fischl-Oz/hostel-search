package com.fischl.models;

public class PostTag {
    private String tag_id;
    private int post_id;

    public PostTag() {
    }

    public PostTag(String tag_id, int post_id) {
        this.tag_id = tag_id;
        this.post_id = post_id;
    }

    public String getTagId() {
        return tag_id;
    }

    public void setTagId(String tagId) {
        this.tag_id = tagId;
    }

    public int getPostId() {
        return post_id;
    }

    public void setPostId(int postId) {
        this.post_id = postId;
    }
}
