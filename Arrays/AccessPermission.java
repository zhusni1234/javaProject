public class AccessPermission {

    public static void main(String[] args) {
        // Declare and initialize boolean variables
        boolean isLoggedIn = true; // user is logged in
        boolean hasPermission = false; // user does not have permission to access the feature

        // Apply Boolean negation and implement conditional logic
        if (!isLoggedIn) {
            System.out.println("Access Denied: You need to log in first.");
        } else if (!hasPermission) {
            System.out.println("Access Denied: You do not have the required permissions.");
        } else {
            System.out.println("Access Granted: You have the required permissions.");
        }
    }
}
