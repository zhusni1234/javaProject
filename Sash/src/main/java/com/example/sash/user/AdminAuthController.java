package com.example.sash.user;

import com.example.sash.model.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminAuthController {

    @PostMapping("/signin")
    public ResponseEntity<String> adminSignIn(@RequestBody Admin loginAdmin) {
        // Check if the provided username and password match the hardcoded admin credentials
        if (Admin.isAdmin(loginAdmin.getUsername(), loginAdmin.getPassword())) {
            return ResponseEntity.ok("Admin signed in successfully.");
        }
        return ResponseEntity.badRequest().body("Invalid admin credentials.");
    }
}
