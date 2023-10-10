package com.fischl.models;

public class Tag {
    private String tag_id;
    private String tag_txt;

    public Tag() {
    }

    public Tag(String tag_id, String tag_txt) {
        this.tag_id = tag_id;
        this.tag_txt = tag_txt;
    }

    public String getTagId() {
        return tag_id;
    }

    public void setTagId(String tagId) {
        this.tag_id = tagId;
    }

    public String getTagTxt() {
        return tag_txt;
    }

    public void setTagTxt(String tagTxt) {
        this.tag_txt = tagTxt;
    }
}
