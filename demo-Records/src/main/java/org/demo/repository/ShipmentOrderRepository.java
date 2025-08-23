package org.demo.repository;

import java.util.*;

import org.demo.exception.ShipmentOrderNotFoundException;
import org.demo.model.*;


public class ShipmentOrderRepository {
    private List<ShipmentOrder> shipments = new ArrayList<>();

    public List<ShipmentOrder> getShipments() {
        return shipments;
    }

    public void setShipments(List<ShipmentOrder> shipments) {
        this.shipments = shipments;
    }

    public ShipmentOrder viewShipmentOrder(String orderId) {
        Optional<ShipmentOrder> foundOrder = shipments.stream()
                .filter(order -> order.orderID().equals(orderId))
                .findFirst();
        return foundOrder.orElseThrow(() -> new
                ShipmentOrderNotFoundException("Shipment order not found"));
    }

    public void updateShipmentStatus(String orderId, ShipmentStatus
            newStatus) {
        Optional<ShipmentOrder> foundOrder = shipments.stream()
                .filter(order -> order.orderID().equals(orderId))
                .findFirst();
        if (foundOrder.isPresent()) {
            shipments.remove(foundOrder.get());
            shipments.add(new ShipmentOrder(orderId,foundOrder.get().source(), foundOrder.get().destination(), foundOrder.get().shipmentItems(), newStatus));
        } else {
            throw new ShipmentOrderNotFoundException("Shipment order not found");
        }
    }

    public List<ShipmentOrder> listAllShipmentOrders() {
        return shipments;
    }
}