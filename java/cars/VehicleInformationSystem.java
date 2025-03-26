import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// ======================== INTERFACES ========================
// Base Interface for all vehicles
interface Vehicle {
    String getMake();

    String getModel();

    int getYear();
}

// Additional interface for Car
interface CarVehicle {
    void setNumberOfDoors(int doors);

    void setFuelType(String fuelType);

    int getNumberOfDoors();

    String getFuelType();
}

// Additional interface for Motorcycle
interface MotorVehicle {
    void setNumberOfWheels(int wheels);

    void setMotorType(String type);

    int getNumberOfWheels();

    String getMotorType();
}

// Additional interface for Truck
interface TruckVehicle {
    void setCargoCapacity(double capacity);

    void setTransmissionType(String transmission);

    double getCargoCapacity();

    String getTransmissionType();
}

// ======================== CLASSES ===========================
// Car Class
class Car implements Vehicle, CarVehicle {
    private String make, model, fuelType;
    private int year, numberOfDoors;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public void setNumberOfDoors(int doors) {
        this.numberOfDoors = doors;
    }

    @Override
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public String getFuelType() {
        return fuelType;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYear() {
        return year;
    }
}

// Motorcycle Class
class Motorcycle implements Vehicle, MotorVehicle {
    private String make, model, motorType;
    private int year, numberOfWheels;

    public Motorcycle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public void setNumberOfWheels(int wheels) {
        this.numberOfWheels = wheels;
    }

    @Override
    public void setMotorType(String type) {
        this.motorType = type;
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public String getMotorType() {
        return motorType;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYear() {
        return year;
    }
}

// Truck Class
class Truck implements Vehicle, TruckVehicle {
    private String make, model, transmissionType;
    private int year;
    private double cargoCapacity;

    public Truck(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public void setCargoCapacity(double capacity) {
        this.cargoCapacity = capacity;
    }

    @Override
    public void setTransmissionType(String transmission) {
        this.transmissionType = transmission;
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public String getTransmissionType() {
        return transmissionType;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYear() {
        return year;
    }
}

// ========================== MAIN PROGRAM ==========================
public class VehicleInformationSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("===== Vehicle Information System =====");
        while (true) {
            try {
                System.out.println("\n1. Add Car\n2. Add Motorcycle\n3. Add Truck\n4. Show All Vehicles\n5. Exit");
                System.out.print("Select an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                switch (choice) {
                    case 1 -> addCar();
                    case 2 -> addMotorcycle();
                    case 3 -> addTruck();
                    case 4 -> showAllVehicles();
                    case 5 -> {
                        System.out.println("Exiting the program. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear buffer
            }
        }
    }

    private static void addCar() {
        try {
            System.out.print("Enter Car Make: ");
            String make = scanner.nextLine();
            System.out.print("Enter Car Model: ");
            String model = scanner.nextLine();
            System.out.print("Enter Year: ");
            int year = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            Car car = new Car(make, model, year);
            System.out.print("Enter Number of Doors: ");
            car.setNumberOfDoors(scanner.nextInt());
            scanner.nextLine();

            System.out.print("Enter Fuel Type (Petrol/Diesel/Electric): ");
            car.setFuelType(scanner.nextLine());
            vehicles.add(car);
            System.out.println("Car added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct data.");
            scanner.nextLine();
        }
    }

    private static void addMotorcycle() {
        try {
            System.out.print("Enter Motorcycle Make: ");
            String make = scanner.nextLine();
            System.out.print("Enter Motorcycle Model: ");
            String model = scanner.nextLine();
            System.out.print("Enter Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            Motorcycle motorcycle = new Motorcycle(make, model, year);
            System.out.print("Enter Number of Wheels: ");
            motorcycle.setNumberOfWheels(scanner.nextInt());
            scanner.nextLine();

            System.out.print("Enter Type (Sport/Cruiser/Off-Road): ");
            motorcycle.setMotorType(scanner.nextLine());
            vehicles.add(motorcycle);
            System.out.println("Motorcycle added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct data.");
            scanner.nextLine();
        }
    }

    private static void addTruck() {
        try {
            System.out.print("Enter Truck Make: ");
            String make = scanner.nextLine();
            System.out.print("Enter Truck Model: ");
            String model = scanner.nextLine();
            System.out.print("Enter Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            Truck truck = new Truck(make, model, year);
            System.out.print("Enter Cargo Capacity (tons): ");
            truck.setCargoCapacity(scanner.nextDouble());
            scanner.nextLine();

            System.out.print("Enter Transmission Type (Manual/Automatic): ");
            truck.setTransmissionType(scanner.nextLine());
            vehicles.add(truck);
            System.out.println("Truck added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct data.");
            scanner.nextLine();
        }
    }

    private static void showAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to display.");
        } else {
            System.out.println("===== Vehicle List =====");
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }
}
