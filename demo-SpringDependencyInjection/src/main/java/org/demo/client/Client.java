package org.demo.client;

import org.demo.model.Freight;
import org.demo.service.FreightServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;


public class Client {
    static FreightServiceImpl freightservice;
    public static void main(String[] args) {
    // ClassPathXmlApplicationContext context
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Create Freight Object via constructor injection by name value ");
            System.out.println("2. Create Freight Object via constructor injection by index ");
            System.out.println("3. Create Freight Object via constructor injection by type ");
            System.out.println("4. Create Freight Object via setter injection");
            System.out.println("-----------Demo Menu------- ------");
            System.out.println("5. Create Freight");
            System.out.println("6. Get All Freight");
            System.out.println("7. Update Freight");
            System.out.println("8. Delete Freight");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.println("Frieght Object: "+context.getBean("freightConstName"));
                    break;
                case 2:
                    System.out.println("Frieght Object: "+context.getBean("freightConstIndex"));
                    break;
                case 3:
                    System.out.println("Frieght Object: "+context.getBean("freightConstType"));
                    break;
                case 4:
                    System.out.println("Frieght Object: "+context.getBean("freight"));
                    break;
                case 5:
                    freightservice=(FreightServiceImpl) context.getBean("freightService");
                    Freight new_freight=(Freight) context.getBean("freight");

                    System.out.println("Enter the order id: ");
                    int orderid=scanner.nextInt();
                    new_freight.setOrderId(orderid);

                    System.out.println("Enter the origin: ");
                    String origin=scanner.next();
                    new_freight.setOrigin(origin);

                    System.out.println("Enter the destination: ");
                    String destination=scanner.next();
                    new_freight.setDestination(destination);
                    freightservice.createFreight(new_freight);

                    System.out.println("Freight Added successfully!!!");
                    break;
                case 6:
                    System.out.println("All Freight: " + freightservice.getAllFreight());
                    break;
                case 7:
                    System.out.print("Enter Order ID: ");
                    int updateOrderId = scanner.nextInt();
                    scanner.nextLine();

                    Freight updatedFreight = freightservice.getFreightById(updateOrderId);
                    if (updatedFreight != null) {
                        System.out.print("Enter updated Origin: ");
                        String updatedOrigin = scanner.nextLine();
                        System.out.print("Enter updated Destination: ");
                        String updatedDestination = scanner.nextLine();
                        updatedFreight.setOrigin(updatedOrigin);
                        updatedFreight.setDestination(updatedDestination);
                        freightservice.updateFreight(updatedFreight);
                        System.out.println("Freight updated: " + updatedFreight);
                    } else {
                        System.out.println("Freight not found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter Order ID: ");
                    int deleteOrderId = scanner.nextInt();
                    freightservice.deleteFreight(deleteOrderId);
                    System.out.println("Freight deleted with Order ID: " + deleteOrderId);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
        scanner.close();
        ((AbstractApplicationContext)context).close();
    }
}
