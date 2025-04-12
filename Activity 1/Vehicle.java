import java.util.Scanner;

class BaseVehicle {
    private String brand;
    private int speed;
    private String fuelType;

    public BaseVehicle(String brand, int speed, String fuelType) {
        this.brand = brand;
        this.speed = speed;
        this.fuelType = fuelType;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getFuelType() {
        return this.fuelType;
    }

    public void displayInfo() {
        System.out.println("Brand name: " + brand);
        System.out.println("Car's speed: " + speed + " km/h");
        System.out.println("Gas or Electric: " + fuelType);
    }
}

class Car extends BaseVehicle {
    private int numDoors;

    public Car(String brand, int speed, String fuelType, int numDoors) {
        super(brand, speed, fuelType);
        this.numDoors = numDoors;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numDoors + " doors");
    }
}

class Motorcycle extends BaseVehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, int speed, String fuelType, boolean hasSidecar) {
        super(brand, speed, fuelType);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has a Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}

public class Vehicle {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        boolean input = true;
        System.out.println("Welcome to Missubibi");

        while (input) {
            System.out.println("\nSelect the type of your vehicle for details:");
            System.out.println("1. Car");
            System.out.println("2. Motorcycle");
            System.out.println("3. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Enter Car details");
                System.out.print("Brand name: ");
                String carBrand = scanner.nextLine();
                System.out.print("Top Speed: ");
                int carSpeed = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Gas or Electric: ");
                String carGas = scanner.nextLine();
                System.out.print("How many doors does it have: ");
                int carDoors = scanner.nextInt();
                scanner.nextLine();

                Car car = new Car(carBrand, carSpeed, carGas, carDoors);
                System.out.println("\nCar details");
                car.displayInfo();
            } else if (choice == 2) {
                System.out.println("Enter Motorcycle details");
                System.out.print("Brand name: ");
                String motoBrand = scanner.nextLine();
                System.out.print("Top Speed: ");
                int motoSpeed = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Gas or Electric: ");
                String motoGas = scanner.nextLine();
                System.out.print("Does your motor have a Sidecar? (true/false): ");
                boolean motoSidecar = scanner.nextBoolean();
                scanner.nextLine();

                Motorcycle motorcycle = new Motorcycle(motoBrand, motoSpeed, motoGas, motoSidecar);
                System.out.println("\nMotorcycle details");
                motorcycle.displayInfo();
            } else if (choice == 3) {
                System.out.println("Thank you for using our Service. God bless you!");
                input = false;
            } else {
                System.out.println("Invalid choice. Please enter either of the following. Thank you");
            }
        }
        scanner.close();
    }
}