package org.app.service;

import org.app.model.ShipmentInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DelayedShipmentFilterImpl implements  DelayedShipmentFilter{
    @Override
    public List<ShipmentInfo> filterDelayedShipments(List<ShipmentInfo> shipmentList) {
        Predicate<ShipmentInfo> delayedPredicate = shipment -> {
            String deliveryStatus = shipment.getDeliveryStatus();
            System.out.println(deliveryStatus); // Debugging line
            return "Delayed".equals(deliveryStatus);
        };
        List<ShipmentInfo> delayedShipments = new ArrayList<>();
        for (ShipmentInfo shipment : shipmentList) {
            if (delayedPredicate.test(shipment)) {
                delayedShipments.add(shipment);
            }
        }
        return delayedShipments;
    }
}