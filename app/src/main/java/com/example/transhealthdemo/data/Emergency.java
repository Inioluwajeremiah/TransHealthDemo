package com.example.transhealthdemo.data;

public class Emergency {

    private String healthIssue;
    private String description;
    private String location;


    public Emergency(String healthIssue, String description, String location) {
        this.healthIssue = healthIssue;
        this.description = description;
        this.location = location;
    }

    public String getHealthIssue() {
        return healthIssue;
    }

    public void setHealthIssue(String healthIssue) {
        this.healthIssue = healthIssue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}


