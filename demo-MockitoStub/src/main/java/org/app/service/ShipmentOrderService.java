package org.app.service;

import java.util.List;
import org.app.model.ShipmentOrder;

public interface ShipmentOrderService {
    public ShipmentOrder addShipmentOrder(ShipmentOrder order);
    public ShipmentOrder getShipmentOrder(String orderId);
    public void updateShipmentOrder(ShipmentOrder updatedOrder);
    public void deleteShipmentOrder(String orderId);
    void updateOrderStatus(String orderNumber, String newStatus);
    public List<ShipmentOrder> getAllShipmentOrders();
    public String getEstimatedDeliveryTime(String trackingNumber);
    public String generateTrackingNumber();
    public ShipmentOrder processShipmentOrder(ShipmentOrder processOrder);
}
