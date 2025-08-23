package org.demo.repo;

import org.demo.exception.ShipmentOrderNotFoundException;
import org.demo.model.ShipmentOrder;
import org.demo.model.ShipmentStatus;

import java.util.*;
import java.util.Optional;


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
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst();
        return foundOrder.orElseThrow(() -> new ShipmentOrderNotFoundException("Shipment order not found"));
    }

    public void updateShipmentStatus(String orderId, ShipmentStatus newStatus) {
        Optional<ShipmentOrder> foundOrder = shipments.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst();
        if (foundOrder.isPresent()) {
            shipments.remove(foundOrder.get());
            shipments.add(new
                    ShipmentOrder(orderId,foundOrder.get().getSource(),
                    foundOrder.get().getDestination(), newStatus,foundOrder.get().getItems()));
        } else {
            throw new ShipmentOrderNotFoundException("Shipment order not found");
        }
    }
}
