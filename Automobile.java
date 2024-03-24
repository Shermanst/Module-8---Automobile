import java.util.Scanner;

public class Automobile {
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;
	private double sellingPrice;
	private String VIN;
	
	// Default constructor
	public Automobile() {}

	// Parameterized constructor
	public Automobile(String make, String model, String color, int year,
            int mileage, double sellingPrice, String VIN) {
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.mileage = mileage;
		this.sellingPrice = sellingPrice;
		this.VIN = VIN;
	}
	
	// Method to add a new vehicle
	public String addNewVehicle(String make, String model, String color, int year,
            int mileage, double sellingPrice, String VIN) {
		try {
			this.make = make;
			this.model = model;
			this.color = color;
			this.year = year;
			this.mileage = mileage;
			this.sellingPrice = sellingPrice;
			this.VIN = VIN;
			return "Vehicle added successfully.";
		}catch (Exception e) {
			return "Failed to add vehicle: " + e.getMessage();
		}
	}
	
	// Method to list vehicle information
	public String[]listVehicleInformation() {
		String[] vehicleInfo = {
			    make,
			    model,
			    color,
			    String.valueOf(year),
			    String.valueOf(mileage),
			    String.valueOf(sellingPrice),
			    VIN
			};
		return vehicleInfo;
	}
	
	// Method to remove vehicle information
	public String removeVehicle() {
		try {
			make = null;
			model = null;
			color = null;
			year = 0;
			mileage = 0;
			sellingPrice = 0.0;
			VIN = null;
			return "Vehicle information removed successfully.";
		} catch (Exception e) {
			return "Failed to remove vehicle: " + e.getMessage();
		}
	}
	
	// Method to update vehicle attributes
	public String updateVehicleAttributes(String make, String model, String color, int year,
            int mileage, double sellingPrice, String VIN) {
		try {
			this.make = make;
			this.model = model;
			this.color = color;
			this.year = year;
			this.mileage = mileage;
			this.sellingPrice = sellingPrice;
			this.VIN = VIN;
			return "Vehicle attributes updated successfully.";
		} catch (Exception e) {
			return "Failed to update vehicle attributes: " + e.getMessage();
		}
	}
}

class InputModule {
	public static String getStringInput(String prompt) {
		Scanner scnr = new Scanner(System.in);
		System.out.print(prompt);
		return scnr.nextLine();
	}
	
	public static int getIntInput (String prompt) {
		Scanner scnr = new Scanner(System.in);
		System.out.print(prompt);
		while (!scnr.hasNextInt()) {
			System.out.print("Please enter a valid value: ");
			scnr.next();
		}
		return scnr.nextInt();
	}
	
	public static double getDoubleInput(String prompt) {
		Scanner scnr = new Scanner(System.in);
		System.out.print(prompt);
		while (!scnr.hasNextDouble()) {
			System.out.print("Please enter a valid number: ");
			scnr.next();
		}
		return scnr.nextDouble();
	}
}


















