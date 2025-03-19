import java.util.Scanner;

// Vehicle Interface
interface Vehicle {
    String getMake();
    String getModel();
    int getYearOfManufacture();
}

// CarVehicle Interface
interface CarVehicle extends Vehicle {
    void setNumberOfDoors(int doors);
    int getNumberOfDoors();
    void setFuelType(String fuelType);
    String getFuelType();
}

// MotorVehicle Interface
interface MotorVehicle extends Vehicle {
    void setNumberOfWheels(int wheels);
    int getNumberOfWheels();
    void setMotorcycleType(String type);
    String getMotorcycleType();
}

// TruckVehicle Interface
interface TruckVehicle extends Vehicle {
    void setCargoCapacity(double capacity);
    double getCargoCapacity();
    void setTransmissionType(String transmission);
    String getTransmissionType();
}

// Car Class
class Car implements CarVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfDoors;
    private String fuelType;

    @Override
    public String getMake() { return make; }
    @Override
    public String getModel() { return model; }
    @Override
    public int getYearOfManufacture() { return yearOfManufacture; }

    @Override
    public void setNumberOfDoors(int doors) { this.numberOfDoors = doors; }
    @Override
    public int getNumberOfDoors() { return numberOfDoors; }
    @Override
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }
    @Override
    public String getFuelType() { return fuelType; }

    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setYearOfManufacture(int year) { this.yearOfManufacture = year; }
}

// Motorcycle Class
class Motorcycle implements MotorVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfWheels;
    private String motorcycleType;

    @Override
    public String getMake() { return make; }
    @Override
    public String getModel() { return model; }
    @Override
    public int getYearOfManufacture() { return yearOfManufacture; }
    @Override
    public void setNumberOfWheels(int wheels) { this.numberOfWheels = wheels; }
    @Override
    public int getNumberOfWheels() { return numberOfWheels; }
    @Override
    public void setMotorcycleType(String type) { this.motorcycleType = type; }
    @Override
    public String getMotorcycleType() { return motorcycleType; }

    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setYearOfManufacture(int year) { this.yearOfManufacture = year; }
}

// Truck Class
class Truck implements TruckVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private double cargoCapacity;
    private String transmissionType;

    @Override
    public String getMake() { return make; }
    @Override
    public String getModel() { return model; }
    @Override
    public int getYearOfManufacture() { return yearOfManufacture; }
    @Override
    public void setCargoCapacity(double capacity) { this.cargoCapacity = capacity; }
    @Override
    public double getCargoCapacity() { return cargoCapacity; }
    @Override
    public void setTransmissionType(String transmission) { this.transmissionType = transmission; }
    @Override
    public String getTransmissionType() { return transmissionType; }

    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setYearOfManufacture(int year) { this.yearOfManufacture = year; }
}

// Main Program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vehicle Rental Management System!");

        System.out.println("Choose a vehicle type to add:");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.println("3. Truck");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                Car car = new Car();
                System.out.println("\nEnter car details:");
                System.out.print("Make: ");
                car.setMake(scanner.nextLine());
                System.out.print("Model: ");
                car.setModel(scanner.nextLine());
                System.out.print("Year of Manufacture: ");
                car.setYearOfManufacture(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("Number of Doors: ");
                car.setNumberOfDoors(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("Fuel Type (petrol/diesel/electric): ");
                car.setFuelType(scanner.nextLine());

                System.out.println("\nVehicle added successfully!");
                System.out.println("\nVehicle Details:");
                System.out.println("Type: Car");
                System.out.println("Make: " + car.getMake());
                System.out.println("Model: " + car.getModel());
                System.out.println("Year: " + car.getYearOfManufacture());
                System.out.println("Number of Doors: " + car.getNumberOfDoors());
                System.out.println("Fuel Type: " + car.getFuelType());
                break;

            case 2:
                Motorcycle motorcycle = new Motorcycle();
                System.out.println("\nEnter motorcycle details:");
                System.out.print("Make: ");
                motorcycle.setMake(scanner.nextLine());
                System.out.print("Model: ");
                motorcycle.setModel(scanner.nextLine());
                System.out.print("Year of Manufacture: ");
                motorcycle.setYearOfManufacture(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("Number of Wheels: ");
                motorcycle.setNumberOfWheels(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("Motorcycle Type (sport/cruiser/off-road): ");
                motorcycle.setMotorcycleType(scanner.nextLine());

                System.out.println("\nVehicle added successfully!");
                System.out.println("\nVehicle Details:");
                System.out.println("Type: Motorcycle");
                System.out.println("Make: " + motorcycle.getMake());
                System.out.println("Model: " + motorcycle.getModel());
                System.out.println("Year: " + motorcycle.getYearOfManufacture());
                System.out.println("Number of Wheels: " + motorcycle.getNumberOfWheels());
                System.out.println("Motorcycle Type: " + motorcycle.getMotorcycleType());
                break;

            case 3:
                Truck truck = new Truck();
                System.out.println("\nEnter truck details:");
                System.out.print("Make: ");
                truck.setMake(scanner.nextLine());
                System.out.print("Model: ");
                truck.setModel(scanner.nextLine());
                System.out.print("Year of Manufacture: ");
                truck.setYearOfManufacture(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("Cargo Capacity (in tons): ");
                truck.setCargoCapacity(scanner.nextDouble());
                scanner.nextLine(); // Consume newline
                System.out.print("Transmission Type (manual/automatic): ");
                truck.setTransmissionType(scanner.nextLine());

                System.out.println("\nVehicle added successfully!");
                System.out.println("\nVehicle Details:");
                System.out.println("Type: Truck");
                System.out.println("Make: " + truck.getMake());
                System.out.println("Model: " + truck.getModel());
                System.out.println("Year: " + truck.getYearOfManufacture());
                System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
                System.out.println("Transmission Type: " + truck.getTransmissionType());
                break;

            default:
                System.out.println("Invalid choice!");
                break;
        }

        scanner.close();
    }
}