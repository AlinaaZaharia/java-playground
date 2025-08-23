package org.demo.client;

import org.demo.exception.ShipmentOrderNotFoundException;
import org.demo.model.ShipmentItem;
import org.demo.model.ShipmentOrder;
import org.demo.model.ShipmentStatus;
import org.demo.repository.ShipmentOrderRepository;
import org.demo.service.ShipmentOrderServiceImpl;
import java.util.List;


public class ShipmentOrderClient {
    public static void main(String[] args) {

// TODO Auto-generated method stub
        ShipmentOrderRepository shipmentRepository = new ShipmentOrderRepository();
        ShipmentOrderServiceImpl shipmentService = new ShipmentOrderServiceImpl(shipmentRepository);

        ShipmentItem item1=new ShipmentItem();
        item1.setItemId("1001");
        item1.setDescription("Item1");
        item1.setQuantity(10);
        item1.setWeight(20);

        ShipmentItem item2=new ShipmentItem();
        item2.setItemId("1002");
        item2.setDescription("Item2");
        item2.setQuantity(20);
        item2.setWeight(30);

// Create sample shipment orders
        ShipmentOrder order1 = new ShipmentOrder("123", "Sender Company", "Receiver Company",
                List.of(item1), ShipmentStatus.CREATED);
        ShipmentOrder order2 = new ShipmentOrder("456", "Another Sender", "Another Receiver",
                List.of(item2), ShipmentStatus.IN_TRANSIT);
        shipmentService.createShipment(order1);
        shipmentService.createShipment(order2);

// View a shipment order
        String orderIdToView = "123";
        try {
            ShipmentOrder viewedOrder = shipmentService.viewShipmentOrder(orderIdToView);
            System.out.println("Viewed Shipment Order:");
            System.out.println(viewedOrder);
        } catch (ShipmentOrderNotFoundException ex) {
            System.out.println("Shipment order not found.");
        }

// Update shipment status
        String orderIdToUpdate = "456";
        try {
            shipmentService.updateShipmentStatus(orderIdToUpdate, ShipmentStatus.DELIVERED);
            System.out.println("Shipment status updated successfully.");
        } catch (ShipmentOrderNotFoundException ex) {
            System.out.println("Shipment order not found.");
        }

// List all shipment orders
        List<ShipmentOrder> allOrders = shipmentService.listAllShipmentOrders();
        System.out.println("All Shipment Orders:");
        for (ShipmentOrder order : allOrders) {
            System.out.println(order);
        }
    }
}