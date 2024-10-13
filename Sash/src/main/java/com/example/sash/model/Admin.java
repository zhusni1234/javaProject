package com.example.sash.model;

public class Admin {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";  // Ideally hashed

    private String username;
    private String password;

    // Default constructor for deserialization
    public Admin() {
    }

    // Constructor to receive admin login data
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Static method to check admin credentials
    public static boolean isAdmin(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
