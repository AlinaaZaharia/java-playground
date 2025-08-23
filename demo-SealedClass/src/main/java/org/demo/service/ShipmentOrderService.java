package org.demo.service;

import org.demo.model.ShipmentOrder;
import org.demo.model.ShipmentStatus;
import java.util.List;

public interface ShipmentOrderService {
    void createShipment(ShipmentOrder shipmentOrder);
    void updateShipmentStatus(String shipmentId, ShipmentStatus newStatus);
    String generateShipmentLabel(ShipmentOrder order);
    public List<ShipmentOrder> listAllShipmentOrders();
}