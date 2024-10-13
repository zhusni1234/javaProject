package com.example.sash.service;

import com.example.sash.model.Booking;
import com.example.sash.model.GlampingPackage;
import com.example.sash.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    private int points = 0; // Keep track of user points

    // Get all user bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Create a new booking after successful payment
    public Booking createBooking(GlampingPackage glampingPackage, String checkinDate, String checkoutDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date checkin = sdf.parse(checkinDate);
            Date checkout = sdf.parse(checkoutDate);
            int duration = (int) ((checkout.getTime() - checkin.getTime()) / (1000 * 60 * 60 * 24));
            double totalPrice = glampingPackage.getPrice() * duration;

            Booking booking = new Booking();
            booking.setCheckinDate(checkin);
            booking.setCheckoutDate(checkout);
            booking.setDuration(duration);
            booking.setTotalPrice(totalPrice);

            // Add points based on the total price (1 point per ringgit)
            points += totalPrice;

            return bookingRepository.save(booking);
        } catch (Exception e) {
            throw new RuntimeException("Error while creating booking: " + e.getMessage());
        }
    }

    // Calculate the total price for a package
    public double calculateTotalPrice(GlampingPackage glampingPackage, String checkinDate, String checkoutDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date checkin = sdf.parse(checkinDate);
            Date checkout = sdf.parse(checkoutDate);
            int duration = (int) ((checkout.getTime() - checkin.getTime()) / (1000 * 60 * 60 * 24));

            // Calculate total price based on the duration of stay
            return glampingPackage.getPrice() * duration;
        } catch (Exception e) {
            throw new RuntimeException("Error calculating total price: " + e.getMessage());
        }
    }

    // Check availability for a package
    public boolean checkAvailability(GlampingPackage glampingPackage, String checkinDate, String checkoutDate) {
        // Implement your availability logic here (e.g., check if any booking exists for these dates)
        return true; // Assuming it's available
    }

    // Get user points
    public int getUserPoints() {
        return points;
    }
}
