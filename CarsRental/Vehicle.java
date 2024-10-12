// Super class Vehicle
class Vehicle {
    // Attributes
    private String make;
    private String model;
    private int year;
    private double rentalPricePerDay;

    // Constructor
    public Vehicle(String make, String model, int year, double rentalPricePerDay) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    // Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    // Method to calculate rental cost based on the number of days
    public double calculateRentalCost(int days) {
        return rentalPricePerDay * days;
    }
}

// Subclass: Car
class Car extends Vehicle {
    // Additional attributes
    private int numSeats;
    private int numDoors;

    // Constructor
    public Car(String make, String model, int year, double rentalPricePerDay, int numSeats, int numDoors) {
        super(make, model, year, rentalPricePerDay); // Call parent class constructor
        this.numSeats = numSeats;
        this.numDoors = numDoors;
    }

    // Getters for additional attributes
    public int getNumSeats() {
        return numSeats;
    }

    public int getNumDoors() {
        return numDoors;
    }

    @Override
    public String toString() {
        return "Car [Make: " + getMake() + ", Model: " + getModel() + ", Year: " + getYear() +
                ", Seats: " + numSeats + ", Doors: " + numDoors + 
                ", Rental Price per Day: $" + getRentalPricePerDay() + "]";
    }
}

// Subclass: Motorcycle
class Motorcycle extends Vehicle {
    // Additional attribute
    private int engineSize;

    // Constructor
    public Motorcycle(String make, String model, int year, double rentalPricePerDay, int engineSize) {
        super(make, model, year, rentalPricePerDay); // Call parent class constructor
        this.engineSize = engineSize;
    }

    // Getter for additional attribute
    public int getEngineSize() {
        return engineSize;
    }

    @Override
    public String toString() {
        return "Motorcycle [Make: " + getMake() + ", Model: " + getModel() + ", Year: " + getYear() +
                ", Engine Size: " + engineSize + "cc" + 
                ", Rental Price per Day: $" + getRentalPricePerDay() + "]";
    }
}
