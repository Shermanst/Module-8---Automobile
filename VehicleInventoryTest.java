/**
 * This class contains a test for the VehicleInventory class.
 * It adds 100 vehicles to the inventory, removes 10 random vehicles, and checks if all tests passed.
 */

import java.text.DecimalFormat;
import java.util.Random;

public class VehicleInventoryTest {
    public static void main(String[] args) {
        // Create a VehicleInventory object to manage the inventory
        VehicleInventory inventory = new VehicleInventory();
        DecimalFormat df = new DecimalFormat("#.##");
        boolean allTestsPassed = true; // Variable to track whether all tests passed

        // Start of test
        System.out.println("Starting test...");

        // Create and add 100 different vehicles to the inventory
        for (int i = 0; i < 100; i++) {
            String make = "Make" + i;
            String model = "Model" + i;
            String color = "Color" + i;
            int year = 2022 - i;
            int mileage = 1000 * i;
            double sellingPrice = Double.parseDouble(df.format(Math.random() * 1000)); // Random two-decimal selling price
            String VIN = "VIN" + i;

            // Create a new vehicle instance
            Automobile vehicle = new Automobile();

            // Add vehicle to inventory
            try {
                vehicle.addVehicle(make, model, color, year, mileage, sellingPrice, VIN);
                inventory.addVehicle(vehicle);
            } catch (IllegalArgumentException e) {
                allTestsPassed = false; // Set to false if any test fails
                break; // Exit loop if a test fails
            }
        }

        // Check if all vehicles were added successfully
        if (allTestsPassed) {
            // Remove 10 random vehicles from the inventory
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int randomIndex = random.nextInt(inventory.getNumberOfVehicles());
                // Remove vehicle from inventory
                inventory.removeVehicle(randomIndex);
            }

            System.out.println("All tests passed!"); // Indicate all tests passed
        } else {
            System.out.println("Some tests failed."); // Indicate some tests failed
        }
    }
}