package com.example.sash.user;

import com.example.sash.model.Booking;
import com.example.sash.model.GlampingPackage;
import com.example.sash.service.BookingService;
import com.example.sash.service.GlampingPackageService;
import com.example.sash.service.PaymentService; // Mock payment service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private GlampingPackageService glampingPackageService;

    @Autowired
    private PaymentService paymentService; // Injecting payment service

    // View all bookings for authenticated users
    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Step 1: User selects a glamping package, views price, and proceeds with booking
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/book")
    public ResponseEntity<String> bookGlampingPackage(
        @RequestParam String packageId,
        @RequestParam String checkinDate,
        @RequestParam String checkoutDate
    ) {
        Optional<GlampingPackage> glampingPackage = glampingPackageService.findById(packageId);
        
        if (glampingPackage.isPresent()) {
            // Check package availability
            boolean available = bookingService.checkAvailability(glampingPackage.get(), checkinDate, checkoutDate);
            if (available) {
                // Calculate total price
                double totalPrice = bookingService.calculateTotalPrice(glampingPackage.get(), checkinDate, checkoutDate);

                return ResponseEntity.ok("The total price for this package is: RM " + totalPrice + ". Proceed with payment.");
            } else {
                return ResponseEntity.status(400).body("Package is unavailable for the selected dates");
            }
        } else {
            return ResponseEntity.status(404).body("Package not found");
        }
    }

    // Step 2: User proceeds to make payment
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/pay")
    public ResponseEntity<String> makePayment(
        @RequestParam String packageId,
        @RequestParam String checkinDate,
        @RequestParam String checkoutDate
    ) {
        Optional<GlampingPackage> glampingPackage = glampingPackageService.findById(packageId);
        
        if (glampingPackage.isPresent()) {
            // Calculate total price
            double totalPrice = bookingService.calculateTotalPrice(glampingPackage.get(), checkinDate, checkoutDate);

            // Fake payment processing
            boolean paymentSuccess = paymentService.processPayment(totalPrice);

            if (paymentSuccess) {
                // Create booking after payment success
                bookingService.createBooking(glampingPackage.get(), checkinDate, checkoutDate);
                return ResponseEntity.ok("Payment successful! Booking confirmed.");
            } else {
                return ResponseEntity.status(400).body("Payment failed! Please try again.");
            }
        } else {
            return ResponseEntity.status(404).body("Package not found");
        }
    }
}
