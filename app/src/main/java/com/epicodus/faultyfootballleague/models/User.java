package com.epicodus.faultyfootballleague.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 5/10/16.
 */
public class User {
    private String name;
    private String email;
    private List<String> searches;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.searches = new ArrayList<>();
    }

    public User() {}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getSearches() {
        return searches;
    }

    public void setSearches(List<String> searches) {
        this.searches = searches;
    }
    public void addSearch(String search) {
        searches.add(search);
    }
}
