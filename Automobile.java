/*
Description:
This class represents an Automobile with attributes such as make, model, color, year, mileage, selling price, and VIN (Vehicle Identification Number). It provides methods to add a new vehicle, list vehicle information, remove a vehicle, update vehicle attributes, and generate a random VIN.

Consistent Error Handling: Ensure consistency in error handling across methods. Use the same error message format or handling mechanism in all methods for uniformity.

Parameter Validation: Parameter validation is implemented in the addVehicle method to ensure that the input values are valid (e.g., non-null strings, positive integers for year and mileage, non-negative selling price).

Explicit Null Assignment: In the removeVehicle method, attributes are explicitly assigned to default values (-1 for integers, 0.0 for doubles, and empty strings) to avoid potential confusion or unexpected behavior.

Documentation: Each method is documented to explain its purpose and functionality, aiding in code comprehension and maintenance.
*/
import java.util.Random;

public class Automobile {
    // Attributes of the Automobile class
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;
    private double sellingPrice;
    private String VIN;

    // Constructor with parameters
    public Automobile(String make, String model, String color, int year, int mileage, double sellingPrice, String VIN) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
        this.sellingPrice = sellingPrice;
        this.VIN = VIN;
    }

    // Default constructor
    public Automobile() {
        // No default values initialized here
    }

    /**
     * Method to add a new vehicle with given attributes.
     * @param make          The make of the vehicle.
     * @param model         The model of the vehicle.
     * @param color         The color of the vehicle.
     * @param year          The year of manufacture of the vehicle.
     * @param mileage       The mileage of the vehicle.
     * @param sellingPrice  The selling price of the vehicle.
     * @param VIN           The VIN (Vehicle Identification Number) of the vehicle.
     * @throws IllegalArgumentException if any of the input parameters are invalid.
     */
    public void addVehicle(String make, String model, String color, int year, int mileage, double sellingPrice, String VIN) {
        // Validate parameters
        if (make == null || model == null || color == null || VIN == null || year <= 0 || mileage < 0 || sellingPrice < 0) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }
        
        // Assigning values to the attributes
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
        this.sellingPrice = sellingPrice;
        this.VIN = VIN;
    }

    /**
     * Method to list vehicle information as an array of strings.
     * @return An array of strings containing vehicle information.
     */
    public String[] listVehicleInformation() {
        String[] info = new String[7];
        info[0] = "Make: " + make;
        info[1] = "Model: " + model;
        info[2] = "Color: " + color;
        info[3] = "Year: " + year;
        info[4] = "Mileage: " + mileage;
        info[5] = "Selling Price: " + sellingPrice;
        info[6] = "VIN: " + VIN;
        return info;
    }

    /**
     * Method to remove all vehicle information.
     */
    public void removeVehicle() {
        // Explicitly assign default values
        make = "";
        model = "";
        color = "";
        year = -1;
        mileage = -1;
        sellingPrice = 0.0;
        VIN = "";
    }

    /**
     * Method to update vehicle attributes with new values.
     * @param make          The make of the vehicle.
     * @param model         The model of the vehicle.
     * @param color         The color of the vehicle.
     * @param year          The year of manufacture of the vehicle.
     * @param mileage       The mileage of the vehicle.
     * @param sellingPrice  The selling price of the vehicle.
     * @param VIN           The VIN (Vehicle Identification Number) of the vehicle.
     * @throws IllegalArgumentException if any of the input parameters are invalid.
     */
    public void updateVehicleAttributes(String make, String model, String color, int year, int mileage, double sellingPrice, String VIN) {
        // Validate parameters
        if (make == null || model == null || color == null || VIN == null || year <= 0 || mileage < 0 || sellingPrice < 0) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }

        // Updating attribute values
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
        this.sellingPrice = sellingPrice;
        this.VIN = VIN;
    }

    /**
     * Method to generate a random alphanumeric VIN (Vehicle Identification Number) with 10 characters.
     * @return The generated VIN.
     */
    public static String generateVIN() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }
}