package org.demo;

import org.demo.model.Freight;
import org.demo.service.FreightManagementService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class AppMain implements CommandLineRunner {
    private final FreightManagementService freightService;

    public AppMain(FreightManagementService freightService){
        this.freightService = freightService;
    }

    public static void main(String[] args){
        SpringApplication.run(AppMain.class, args);
    }

    @Override
    public void run(String... args){
        Scanner sc = new Scanner(System.in);
        int inputNumber = 0;

        // Display the main menu and handle user input
        while (inputNumber != -1) {
            runFreightManagementMenu();
        }

        sc.close();
    }

    private void runFreightManagementMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Freight Management System");
            System.out.println("1. Add Freight");
            System.out.println("2. Delete Freight");
            System.out.println("3. Update Freight");
            System.out.println("4. View Freight by ID");
            System.out.println("5. View Freight by Origin and Destination");
            System.out.println("6. View All Freights");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addFreight();
                    break;
                case 2:
                    deleteFreight();
                    break;
                case 3:
                    updateFreight();
                    break;
                case 4:
                    viewFreightById();
                    break;
                case 5:
                    viewFreightByOriginAndDestination();
                    break;
                case 6:
                    viewAllFreights();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!\n");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewAllFreights() {
        List<Freight> freights = freightService.getAllFreights();
        for (Freight freight : freights) {
            System.out.println(freight.toString());
            System.out.println();
        }
    }

    private void viewFreightById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Freight ID: ");
        int id = scanner.nextInt();
        Freight freight = freightService.getFreightById(id);
        if (freight != null) {
            System.out.println();
            System.out.println(freight.toString());
        } else {
            System.out.println("Freight not found.");
        }
        System.out.println();
    }

    private void viewFreightByOriginAndDestination() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Origin: ");
        String origin = scanner.next().toLowerCase(); // Convert to lowercase
        System.out.print("Enter Destination: ");
        String destination = scanner.next().toLowerCase(); // Convert to lowercase
        List<Freight> freights =
                freightService.getFreightByOriginAndDestination(origin, destination);
        if (!freights.isEmpty()) {
            for (Freight freight : freights) {
                System.out.println(freight.toString());
            }
        } else {
            System.out.println("No matching freights found.");
        }
        System.out.println();
    }

    private void addFreight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Order ID: ");
        long orderId = scanner.nextLong();

        // Check if a Freight with the same orderId already exists
        Freight existingFreight = freightService.getFreightById(orderId);
        if (existingFreight != null) {
            System.out.println("Freight with Order ID " + orderId + " already exists.");
            return;
        }
        System.out.print("Enter Origin: ");
        String origin = scanner.next();
        System.out.print("Enter Destination: ");
        String destination = scanner.next();

        // Create the Freight object
        Freight freight = new Freight(orderId, origin, destination);
        freightService.saveFreight(freight);
        System.out.println("Freight added successfully!");
        System.out.println();
    }

    private void updateFreight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Freight ID to update: ");
        int id = scanner.nextInt();
        Freight freight = freightService.getFreightById(id);
        if (freight != null) {
            System.out.println("1. Update Origin");
            System.out.println("2. Update Destination");
            System.out.println("0. Cancel");
            System.out.print("Enter your choice: ");
            int updateOption = scanner.nextInt();
            switch (updateOption) {
                case 1:
                    updateOrigin(freight);
                    break;
                case 2:
                    updateDestination(freight);
                    break;
                case 0:
                    System.out.println("Update canceled.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Freight not found.");
        }
        System.out.println();
    }

    private void updateOrigin(Freight freight) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new Origin: ");
        String newOrigin = scanner.next();

        // Update the origin
        freight.setOrigin(newOrigin);

        // Update the freight in the service
        freightService.updateFreight(freight);
        System.out.println("Origin updated successfully!");
        System.out.println();
    }

    private void updateDestination(Freight freight) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new Destination: ");
        String newDestination = scanner.next();
        freight.setDestination(newDestination);
        freightService.updateFreight(freight);
        System.out.println("Destination updated successfully!");
        System.out.println();
    }

    private void deleteFreight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Freight ID to delete: ");
        int id = scanner.nextInt();
        boolean freightRemoved = freightService.deleteFreight(id);
        if (freightRemoved) {
            System.out.println("Freight deleted successfully!");
        } else {
            System.out.println("Freight with orderId " + id + " not found.");
        }
        System.out.println();
    }

    public void run() throws Exception {
        Scanner sc = new Scanner(System.in);
        int inputNumber = 0;
        // Display the main menu and handle user input
        while (inputNumber != -1) {
            runFreightManagementMenu();
        }
        sc.close();
    }
}