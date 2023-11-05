package com.fischl.tools;

import com.fischl.DAOs.PostDAO;
import com.fischl.DAOs.PostTagDAO;
import com.fischl.models.Post;
import com.fischl.models.PostTag;

import java.util.ArrayList;

public class SearchEngine {
    ArrayList<Post> results = new ArrayList<>();
    String keyword;
    String[] tags;
    public SearchEngine() {
        keyword = "";
    }
    public void setKeyword(String keyword) {
        if (keyword == null) return;
        this.keyword = keyword.toLowerCase().trim();
    }
    public void setTags(String[] tags) {
        if (tags == null || tags.length == 0) {
            this.tags = new String[0];
            return;
        }
        this.tags = tags;
        for (String tag : tags ) {
            System.out.println(tag + " ");
        }
    }
    public void search() {
        ArrayList<Post> posts = new ArrayList<>();
        if (!keyword.isEmpty()) {
            posts = new DatabaseContext().Posts.Where(p -> p.getPostTitle().toLowerCase().contains(keyword) || p.getPostContent().toLowerCase().contains(keyword));
        }
        System.out.println(keyword);
        if (posts.size() > 0) {
            System.out.println(posts.size());
            for (int i = 0; i < posts.size(); i++) {
                if (!results.contains(posts.get(i))) {
                    results.add(posts.get(i));
                }
            }
        }
        System.out.println(tags.length);
        if (tags.length > 0) {
            PostTagDAO postTagDAO = new PostTagDAO();
            PostDAO postDAO = new PostDAO();
            for (int i = 0; i < tags.length; i++) {
                ArrayList<Integer> postIds = postTagDAO.getAllPostIdByTagId(tags[i]);
                System.out.println(postIds.size());
                for (int j = 0; j < postIds.size(); j++) {
                    Post post = postDAO.getById(postIds.get(j));
                    if (!results.contains(post)) {
                        results.add(post);
                    }
                }
            }
        }
    }
    public ArrayList<Post> getResults() {
        return results;
    }
}
