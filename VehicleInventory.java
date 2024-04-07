/**
   This class represents a vehicle inventory management system. It allows users to add vehicles, list vehicle information, and remove vehicles from the inventory.

   The main method provides a simple command-line interface for interacting with the inventory system.

   Features:
   - Adding a new vehicle: Users can input information about a vehicle, including make, model, color, year, mileage, selling price, and VIN (Vehicle Identification Number).
   - Listing vehicle information: Users can view the details of all vehicles currently in the inventory.
   - Removing a vehicle: Users can remove a vehicle from the inventory by specifying its index.

   Error Handling:
   - Input Validation: The program ensures that user input for menu options, vehicle information, and indices is valid. If invalid input is provided, appropriate error messages are displayed, and the user is prompted to enter a valid value.

   Design:
   - The program uses a list to store Automobile objects representing vehicles in the inventory.
   - Methods are provided to add, remove, and list vehicles, as well as utility methods for handling user input.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleInventory {
    private List<Automobile> vehicles;

    public VehicleInventory() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Automobile vehicle) {
        vehicles.add(vehicle);
    }

    public Automobile removeVehicle(int index) {
        if (index >= 0 && index < vehicles.size()) {
            return vehicles.remove(index);
        } else {
            System.out.println("Invalid index to remove vehicle.");
            return null;
        }
    }
    
    public int getNumberOfVehicles() {
        return vehicles.size();
    }

    public void listAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in inventory.");
        } else {
            for (Automobile vehicle : vehicles) {
                String[] vehicleInfo = vehicle.listVehicleInformation();
                System.out.println("Listing vehicle information:");
                for (String info : vehicleInfo) {
                    System.out.println(info);
                }
            }
        }
    }

    public static void main(String[] args) {
        VehicleInventory inventory = new VehicleInventory();
        Scanner scnr = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Vehicle Inventory Menu:");
            System.out.println("1. Add a new vehicle");
            System.out.println("2. List vehicle information");
            System.out.println("3. Remove a vehicle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scnr.nextLine()); // Parse input as integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = 0; // Set choice to 0 to continue the loop
            }

            switch (choice) {
                case 1:
                    addNewVehicle(inventory, scnr);
                    break;
                case 2:
                    inventory.listAllVehicles();
                    break;
                case 3:
                    removeVehicle(inventory, scnr);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scnr.close();
    }

    private static void addNewVehicle(VehicleInventory inventory, Scanner scnr) {
        System.out.println("Enter vehicle information:");
        System.out.print("Make: ");
        String make = scnr.nextLine();
        System.out.print("Model: ");
        String model = scnr.nextLine();
        System.out.print("Color: ");
        String color = scnr.nextLine();
        System.out.print("Year: ");
        int year = getIntInput(scnr);
        System.out.print("Mileage: ");
        int mileage = getIntInput(scnr);
        System.out.print("Selling Price: ");
        double sellingPrice = getDoubleInput(scnr);
        System.out.print("VIN: ");
        String VIN = scnr.nextLine();

        Automobile vehicle = new Automobile(make, model, color, year, mileage, sellingPrice, generateVIN());
        inventory.addVehicle(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    private static void removeVehicle(VehicleInventory inventory, Scanner scnr) {
        System.out.println("Enter the index of the vehicle to remove:");
        int index = getIntInput(scnr);
        inventory.removeVehicle(index - 1); // Adjust index to zero-based
        System.out.println("Vehicle removed successfully.");
    }

    private static String generateVIN() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    private static int getIntInput(Scanner scnr) {
        int input = 0;
        boolean isValid = false;
        do {
            try {
                input = Integer.parseInt(scnr.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a correct value.");
            }
        } while (!isValid);
        return input;
    }

    private static double getDoubleInput(Scanner scnr) {
        double input = 0.0;
        boolean isValid = false;
        do {
            try {
                input = Double.parseDouble(scnr.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (!isValid);
        return input;
    }
}