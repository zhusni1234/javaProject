import java.util.Scanner;

public class SocialMediaProfile {
    // Instance variables
    private String username;
    private int age;
    private String bio;

    // Method to create a social media profile with validation checks
    public void createProfile(String username, int age, String bio) {
        // Validate that the username is not empty
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }

        // Validate that the age is between 13 and 120
        if (age < 13 || age > 120) {
            throw new IllegalArgumentException("Age must be between 13 and 120.");
        }

        // Validate that the bio does not exceed 160 characters
        if (bio.length() > 160) {
            throw new IndexOutOfBoundsException("Bio cannot exceed 160 characters.");
        }

        // Assign values if all checks pass
        this.username = username;
        this.age = age;
        this.bio = bio;

        // Simulate profile creation
        System.out.println("Profile created successfully!");
        System.out.println("Username: " + this.username);
        System.out.println("Age: " + this.age);
        System.out.println("Bio: " + this.bio);
    }

    // Main method to take user input and create profile
    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Get the username from the user
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Get the age from the user
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Get the bio from the user
        System.out.print("Enter bio (160 characters max): ");
        String bio = scanner.nextLine();

        // Create an instance of SocialMediaProfile
        SocialMediaProfile profile = new SocialMediaProfile();
        
        try {
            // Attempt to create the profile with the provided input
            profile.createProfile(username, age, bio);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            // Catch and print the exception if validation fails
            System.out.println("Error: " + e.getMessage());
        }

        // Close the scanner
        scanner.close();
    }
}
