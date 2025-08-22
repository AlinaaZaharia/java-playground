package shipmentOrderTest;

import java.util.List;

public interface ShipmentOrderService {
    public void addShipmentOrder(ShipmentOrder order);
    public ShipmentOrder getShipmentOrder(String orderId);
    public void updateShipmentOrder(ShipmentOrder updatedOrder);
    public void deleteShipmentOrder(String orderId);
    void updateOrderStatus(String orderNumber, String newStatus);
    public List<ShipmentOrder> getAllShipmentOrders();
}
