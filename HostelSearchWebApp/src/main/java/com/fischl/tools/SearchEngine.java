package com.fischl.tools;

import com.fischl.DAOs.HostelDAO;
import com.fischl.DAOs.PostDAO;
import com.fischl.DAOs.PostTagDAO;
import com.fischl.models.City;
import com.fischl.models.Hostel;
import com.fischl.models.Post;

import java.util.ArrayList;

public class SearchEngine {
    ArrayList<Post> results = new ArrayList<>();
    String keyword;
    String[] tags;
    Range price_range;
    City city;

    public SearchEngine() {
        keyword = "";
    }

    public void setKeyword(String keyword) {
        if (keyword == null) return;
        this.keyword = keyword.toLowerCase().trim();
    }

    public void setTags(String[] tags) {
        if (tags == null || tags.length == 0) {
            this.tags = null;
            return;
        }
        this.tags = tags;
//        for (String tag : tags ) {
//            System.out.println(tag + " ");
//        }
    }

    public void setPriceRange(Range price_range) {
        if (price_range == null) {
            this.price_range = new Range(0, Integer.MAX_VALUE);
            return;
        }
        this.price_range = price_range;
    }

    public void setCity(City city) {
        if (city == null) return;
        this.city = city;
    }

    public void search() {
        // Get st<Post> posts = new DatabaseContext().Posts.toList();
        ArrayList<Post> posts = new PostDAO().getAll();

        SearchByKeywords(posts);
        SearchByTags();
        SearchByPriceRange(posts);
    }

    public ArrayList<Post> getResults() {
        return results;
    }

    private void SearchByKeywords(ArrayList<Post> posts) {
        if (!keyword.isEmpty()) {
            posts = new DatabaseContext().Posts.Where(p -> p.getPostTitle().toLowerCase().contains(keyword)
                                                        || p.getPostContent().toLowerCase().contains(keyword));
        }
//        System.out.println(keyword);
        if (!posts.isEmpty()) {
            System.out.println(posts.size());
            for (Post post : posts) {
                if (!results.contains(post)) {
                    results.add(post);
                }
            }
        }
    }

    private void SearchByTags() {
//        System.out.println(tags.length);
        if (tags != null) {
            PostTagDAO postTagDAO = new PostTagDAO();
            PostDAO postDAO = new PostDAO();
            for (String tag : tags) {
                ArrayList<Integer> postIds = postTagDAO.getAllPostIdByTagId(tag);
//                System.out.println(postIds.size());
                for (Integer postId : postIds) {
                    Post post = postDAO.getById(postId);
                    if (!results.contains(post)) {
                        results.add(post);
                    }
                }
            }
        }
    }

    private void SearchByPriceRange(ArrayList<Post> posts) {
        if (price_range == null) return;
        if (price_range.max == Integer.MAX_VALUE) return;

        // Loop through all posts
        HostelDAO hostelDAO = new HostelDAO();
        for (Post post : posts) {
            // Get attached hostel
            int hostel_id = post.getHostelId();
            Hostel hostel = hostelDAO.getById(hostel_id);

            // Check if price is in range, if it does, add to result
            if (price_range.isInRange(hostel.getPrice())) {
                // Check if result already contains this post
                if (results.contains(post)) continue;
                results.add(post);
            }

        }
    }

    private void SearchByCity(ArrayList<Post> posts) {
        if (city == null) return;

        // Loop through all posts
        HostelDAO hostelDAO = new HostelDAO();
        for (Post post : posts) {
            // Get attached hostel
            int hostel_id = post.getHostelId();
            Hostel hostel = hostelDAO.getById(hostel_id);

//            // Check if price is in range, if it does, add to result
//            if (hostel.getCityId() == city.getCityId()) {
//                // Check if result already contains this post
//                if (results.contains(post)) continue;
//                results.add(post);
//            }

        }
    }
}
