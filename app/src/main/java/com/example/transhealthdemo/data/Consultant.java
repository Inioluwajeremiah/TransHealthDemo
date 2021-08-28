package com.example.transhealthdemo.data;

public class Consultant {
    private String name;
    private String category;
    private String location;
    private int starNumber;
    private String reviews;

    public Consultant(String name, String category, String location, int starNumber, String reviews) {
        this.name = name;
        this.category = category;
        this.location = location;
        this.starNumber = starNumber;
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStarNumber() {
        return starNumber;
    }

    public void setStarNumber(int starNumber) {
        this.starNumber = starNumber;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }
}
