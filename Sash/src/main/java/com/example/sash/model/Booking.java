package com.example.sash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "bookings")
public class Booking {

    @Id
    private String id;
    private Date checkinDate;
    private Date checkoutDate;
    private int duration;   // Duration in days
    private double totalPrice;

    // Default constructor
    public Booking() {
    }

    // Parameterized constructor
    public Booking(String id, Date checkinDate, Date checkoutDate, int duration, double totalPrice) {
        this.id = id;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.duration = duration;
        this.totalPrice = totalPrice;
    }

    // Getters
    public String getId() {
        return id;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public int getDuration() {
        return duration;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", checkinDate=" + checkinDate +
                ", checkoutDate=" + checkoutDate +
                ", duration=" + duration +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
