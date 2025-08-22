package org.app.service;

import org.app.model.ShipmentOrder;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ShipmentOrderService {
    private List<ShipmentOrder> shipmentOrders;

    public ShipmentOrderService(List<ShipmentOrder> shipmentOrders) {
        this.shipmentOrders = shipmentOrders;
    }

        // Returns delayed shipmentOrders based on predictor and weight criteria
    public List<ShipmentOrder> getDelayedShipments(Predicate<ShipmentOrder> predictor, int threshold) {
        return shipmentOrders.stream()
                        .filter(predictor.and(shipmentOrder -> shipmentOrder.getWeight() > 15))
                        .collect(Collectors.toList());
    }

        // Tracks shipmentOrders and updates status
    public void trackShipments() {
        shipmentOrders.forEach(shipmentOrder -> {
            System.out.println("Tracking shipmentOrder: " + shipmentOrder.getOrigin() + " to " + shipmentOrder.getDestination());
            // Update shipmentOrder status logic can go here
        });
    }
}
