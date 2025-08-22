package shipmentOrderTest;

import java.util.List;
import java.util.Scanner;

public class GloLogisticsApp {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        ShipmentOrderService shipmentOrderService = new
                ShipmentOrderServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create Shipment Order");
            System.out.println("2. Get Shipment Order by ID");
            System.out.println("3. Get All Shipment Orders");
            System.out.println("4. Update Shipment Order");
            System.out.println("5. Delete Shipment Order");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    System.out.print("Enter order ID: ");
                    String orderId = scanner.nextLine();
                    System.out.print("Enter origin: ");
                    String origin = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter Status ");
                    String status = scanner.nextLine();
                    System.out.print("Enter weight: ");
                    double weight = scanner.nextDouble();

            ShipmentOrder newOrder = new ShipmentOrder(orderId, origin,
                    destination, weight,status);
            shipmentOrderService.addShipmentOrder(newOrder);
            System.out.println("Shipment Order created successfully.");
            break;
            case 2:
                System.out.print("Enter order ID: ");
                String searchOrderId = scanner.nextLine();
                ShipmentOrder foundOrder =
                        shipmentOrderService.getShipmentOrder(searchOrderId);
                if (foundOrder != null) {
                    System.out.println("Found Shipment Order:");
                    System.out.println(foundOrder);
                } else {
                    System.out.println("Shipment Order not found.");
                }
                break;
            case 3:
                List allOrders = shipmentOrderService.getAllShipmentOrders();
                System.out.println("All Shipment Orders:");
                for (Object obj : allOrders) {
                    ShipmentOrder order=(ShipmentOrder)obj;
                    System.out.println(order);
                }
                break;
            case 4:
                System.out.print("Enter order ID to update: ");
                String updateOrderId = scanner.nextLine();
                ShipmentOrder existingOrder =
                        shipmentOrderService.getShipmentOrder(updateOrderId);
                if (existingOrder != null) {
                    System.out.print("Enter new origin: ");
                    String newOrigin = scanner.nextLine();
                    System.out.print("Enter new destination: ");
                    String newDestination = scanner.nextLine();
                    System.out.print("Enter new weight: ");
                    double newWeight = scanner.nextDouble();
                    existingOrder.setOrigin(newOrigin);
                    existingOrder.setDestination(newDestination);
                    existingOrder.setWeight(newWeight);
                    shipmentOrderService.updateShipmentOrder(existingOrder);
                    System.out.println("Shipment Order updated successfully.");
                } else {
                    System.out.println("Shipment Order not found.");
                }
                break;
                case 5:
                    System.out.print("Enter order ID to delete: ");
                    String deleteOrderId = scanner.nextLine();
                    shipmentOrderService.deleteShipmentOrder(deleteOrderId);
                    System.out.println("Shipment Order deleted successfully.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}