package com.company;

public class Artist {
    private String name;
    private String country;

    Artist(String name, String country) {
        if (name.length() > 100 || country.length() > 100) {
            System.out.println("Name and country length must be <=100!");
        }
        this.name = name;
        this.country = country;
    }

    public Artist() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
