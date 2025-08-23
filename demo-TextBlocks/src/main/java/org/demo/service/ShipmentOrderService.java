package org.demo.service;

import org.demo.model.ShipmentOrder;
import org.demo.model.ShipmentStatus;

public interface ShipmentOrderService {
    void createShipment(ShipmentOrder shipmentOrder);
    void updateShipmentStatus(String shipmentId, ShipmentStatus newStatus);
    String generateShipmentLabel(ShipmentOrder order);
}