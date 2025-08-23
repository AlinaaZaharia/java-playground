package org.demo.client;

import org.demo.model.ShipmentItem;
import org.demo.model.ShipmentOrder;
import org.demo.model.ShipmentStatus;
import org.demo.repo.ShipmentOrderRepository;
import org.demo.service.ShipmentOrderServiceImpl;
import java.util.ArrayList;
import java.util.List;


public class ShipmentOrderClient {
    public static void main(String[] args) {
        ShipmentOrderRepository shipmentRepository = new ShipmentOrderRepository();
        ShipmentOrderServiceImpl shipmentService = new ShipmentOrderServiceImpl(shipmentRepository);

        List al = new ArrayList();
        al.add(new ShipmentItem("1","Fridge",1,20));
        al.add(new ShipmentItem("2","AC",1,50));

        ShipmentOrder shipmentOrder = new ShipmentOrder();
        shipmentOrder.setOrderId("1001");
        shipmentOrder.setSource("Pune");
        shipmentOrder.setDestination("Bangalore");
        ShipmentStatus status=ShipmentStatus.CREATED;
        shipmentOrder.setStatus(status);
        shipmentOrder.setItems(al);
        shipmentService.createShipment(shipmentOrder);
        String shipmentLabel = shipmentService.generateShipmentLabel(shipmentOrder);
        System.out.println(shipmentLabel);
    }
}