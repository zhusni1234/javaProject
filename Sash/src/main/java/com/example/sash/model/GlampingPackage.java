package com.example.sash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "glampingPackages")
public class GlampingPackage {

    @Id
    private String id;
    private String name;
    private double price;
    private List<String> images;
    private List<LocalDate> availableDates;  // New field for available dates

    // Constructor(s)
    public GlampingPackage() {
    }

    public GlampingPackage(String id, String name, double price, List<String> images, List<LocalDate> availableDates) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.images = images;
        this.availableDates = availableDates;  // Initialize available dates in constructor
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getImages() {
        return images;
    }

    public List<LocalDate> getAvailableDates() {
        return availableDates;  // Getter for available dates
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setAvailableDates(List<LocalDate> availableDates) {
        this.availableDates = availableDates;  // Setter for available dates
    }

    @Override
    public String toString() {
        return "GlampingPackage{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", images=" + images +
                ", availableDates=" + availableDates +  // Include available dates in toString
                '}';
    }
}
