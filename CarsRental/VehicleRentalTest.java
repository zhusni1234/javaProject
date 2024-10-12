public class VehicleRentalTest {
    public static void main(String[] args) {
        // Create instances of Car and Motorcycle
        Car car = new Car("Toyota", "Camry", 2020, 50.0, 5,4);
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR600RR", 2019, 35.0, 600);

        // Specify rental duration
        int rentalDays = 3;

        // Calculate and print rental cost for each vehicle
        System.out.println(car);
        System.out.println("Rental cost for " + rentalDays + " days: $" + car.calculateRentalCost(rentalDays) + "\n");

        System.out.println(motorcycle);
        System.out.println("Rental cost for " + rentalDays + " days: $" + motorcycle.calculateRentalCost(rentalDays));
    }
}
