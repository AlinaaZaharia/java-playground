package org.demo.client;

import org.demo.model.*;
import org.demo.repo.ShipmentOrderRepository;
import org.demo.service.ShipmentOrderServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class ShipmentOrderClient {
    static void printShipmentDetails(ShipmentOrder order)
    {
        List<ShipmentItem> items=order.getItems();
        for(ShipmentItem item1:items)
        {
            if (item1 instanceof Electronics) {
                Electronics electronicsItem = (Electronics) item1;
                System.out.println("Electronics - Item ID: " +
                        electronicsItem.getItemId() +
                        ", Dimensions: " + electronicsItem.getDimensions());
            }
            else if (item1 instanceof Apparel) {
                Apparel apparelItem = (Apparel) item1;
                System.out.println("Apparel - Item ID: " +
                        apparelItem.getItemId() +
                        ", Fabric Type: " + apparelItem.getFabricType());
            } else if (item1 instanceof Perishables) {
                Perishables perishablesItem = (Perishables) item1;
                System.out.println("Perishables - Item ID: " +
                        perishablesItem.getItemId() +
                        ", Expiration Date: " + perishablesItem.getExpirationDate());
            }
        }
    }


    public static void main(String[] args) {
// Create a ShipmentRepository and ShipmentService Instance
        ShipmentOrderRepository shipmentRepository = new ShipmentOrderRepository();
        ShipmentOrderServiceImpl shipmentService = new ShipmentOrderServiceImpl(shipmentRepository);

//Create an Instance of electronics,apparel & perishables
        ShipmentItem electronics = new Electronics("E123", 30.5);
        ShipmentItem apparel = new Apparel("A456", "Cotton");
        ShipmentItem perishables = new Perishables("P789", LocalDate.of(2023, 12, 31));

        //Create an Instance of ShipmentOrders
        ShipmentOrder order1 = new ShipmentOrder("123", "Sender Company", "Receiver Company", ShipmentStatus.CREATED,List.of(electronics,apparel));
        ShipmentOrder order2 = new ShipmentOrder("456", "Another Sender", "Another Receiver",ShipmentStatus.IN_TRANSIT,List.of(apparel,perishables)
        );

//Calling Methods and creating Shipments
        shipmentService.createShipment(order1);
        shipmentService.createShipment(order2);

// Retrieve and display all shipment items
        System.out.println("All Shipment Items:");
        for (ShipmentOrder item : shipmentService.listAllShipmentOrders()) {
            printShipmentDetails(item);
        }
    }
}