package org.app.service;

import org.app.model.ShipmentOrder;

@FunctionalInterface
// functional interface for predicting delivery time
public interface ShipmentOrderDeliveryPredictor {
    int predictDeliveryTime(ShipmentOrder shipmentOrder);
}
