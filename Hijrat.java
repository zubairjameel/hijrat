import java.util.ArrayList;
import java.util.Scanner;

public class Hijrat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> availableDrivers = new ArrayList<>();
        ArrayList<String> availableRides = new ArrayList<>();
        ArrayList<String> availablePassengers = new ArrayList<>();

        while (true) {
            System.out.println("1: View Available Rides");
            System.out.println("2: Register as a Driver");
            System.out.println("3: Register as a Passenger");
            System.out.println("4: Match Ride");
            System.out.println("5: Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline

            if (choice == 1) {
                if (availableRides.isEmpty()) {
                    System.out.println("No available rides.");
                } else {
                    System.out.println("Available Rides:");
                    for (String ride : availableRides) {
                        System.out.println(ride);
                    }
                }
            } else if (choice == 2) {
                System.out.print("Enter your Full Name: ");
                String driverName = scanner.nextLine();
                System.out.print("Your Student ID: ");
                String driverStudentId = scanner.nextLine();
                System.out.print("Enter Your Phone Number: ");
                String driverPhone = scanner.nextLine(); // Store as String
                scanner.nextLine(); // Consume newline after integer input
                System.out.print("Your Department Name: ");
                String driverDepartmentName = scanner.nextLine();
                System.out.print("Enter Your Vehicle Name: ");
                String driverVehicle = scanner.nextLine();
                System.out.print("University Campus Name: ");
                String universityCampusName = scanner.nextLine();
                System.out.print("Enter Location: ");
                String location = scanner.nextLine();
                System.out.print("Enter Departure Time (HH:MM): ");
                String driverTime = scanner.nextLine();

                String driverDetails = driverName + "|" + driverStudentId + "|" + driverPhone + "|" + driverDepartmentName + "|" + driverVehicle + "|" + universityCampusName + "|" + location + "|" + driverTime;
                availableDrivers.add(driverDetails);
                availableRides.add(driverDetails);

                System.out.println("Driver registered successfully!");
            } else if (choice == 3) {
                System.out.print("Enter your Full Name: ");
                String passengerName = scanner.nextLine();
                System.out.print("Your Student ID: ");
                String passengerStudentId = scanner.nextLine();
                System.out.print("Your Department Name: ");
                String passengerDepartmentName = scanner.nextLine();
                System.out.print("Enter Your Campus Name: ");
                String campusName = scanner.nextLine();
                System.out.print("Your Location: ");
                String passengerLocation = scanner.nextLine();
                System.out.print("Enter Your Phone Number: ");
                String passengerPhone = scanner.nextLine(); // Store as String
                scanner.nextLine(); // Consume newline after integer input
                System.out.print("Enter Departure Time (HH:MM): ");
                String passengerTime = scanner.nextLine();

                String passengerDetails = passengerName + "|" + passengerStudentId + "|" + passengerDepartmentName + "|" + campusName + "|" + passengerLocation + "|" + passengerPhone + "|" + passengerTime;
                availablePassengers.add(passengerDetails);

                System.out.println("Passenger registered successfully!");
            } else if (choice == 4) {
                if (availableRides.isEmpty() || availablePassengers.isEmpty()) {
                    System.out.println("No available rides to match.");
                } else {
                    System.out.println("Matching Rides...");
                    matchRides(availableDrivers, availablePassengers);
                }
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Function to match rides
    public static void matchRides(ArrayList<String> availableDrivers, ArrayList<String> availablePassengers) {
        for (String passenger : availablePassengers) {
            String[] passengerDetails = passenger.split("\\|");
            String passengerLocation = passengerDetails[4]; // Passenger location
            String passengerTime = passengerDetails[6]; // Passenger time

            boolean matched = false;

            // Compare with available drivers
            for (String driver : availableDrivers) {
                String[] driverDetails = driver.split("\\|");
                String driverLocation = driverDetails[6]; // Driver location
                String driverTime = driverDetails[7]; // Driver time

                // Check if location and time match
                if (driverLocation.equals(passengerLocation) && driverTime.equals(passengerTime)) {
                    matched = true;
                    System.out.println("Ride matched! Driver: " + driverDetails[0] + " | Passenger: " + passengerDetails[0]);
                    break; // No need to check other drivers once a match is found
                }
            }

            if (!matched) {
                System.out.println("No available rides for Passenger: " + passengerDetails[0]);
            }
        }
    }
}
