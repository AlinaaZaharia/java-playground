package org.app.service;

import org.app.model.Shipment;

import java.util.function.Consumer;

public class ShipmentConsumerImpl implements ShipmentConsumer{
    @Override
    public void displayShipmentDetails(Shipment shipment) {
        Consumer<Shipment> shipmentConsumer = s -> {
            System.out.println("Order ID: " + s.getOrderID());
            System.out.println("Tracking Number: " +
                    s.getTrackingNumber());
            System.out.println("Estimated Delivery Time: " +
                    s.getEstimatedDeliveryTime());
        };
        shipmentConsumer.accept(shipment);
    }
}