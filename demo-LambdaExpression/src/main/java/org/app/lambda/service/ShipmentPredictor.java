package org.app.lambda.service;

import org.app.lambda.model.ShipmentOrder;

@FunctionalInterface
public interface ShipmentPredictor {
    int predictDeliveryTime(ShipmentOrder shipment);
}
