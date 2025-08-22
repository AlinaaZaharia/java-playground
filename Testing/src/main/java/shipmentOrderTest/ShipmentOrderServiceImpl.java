package shipmentOrderTest;
import java.util.*;

public class ShipmentOrderServiceImpl implements ShipmentOrderService {
    private ShipmentOrderRepository shipmentOrderRepository;
    public ShipmentOrderServiceImpl() {
        shipmentOrderRepository = new ShipmentOrderRepository();
    }
    public void addShipmentOrder(ShipmentOrder shipmentOrder) {
        shipmentOrderRepository.addShipmentOrder(shipmentOrder);
    }
    public ShipmentOrder getShipmentOrder(String orderId) {
        return shipmentOrderRepository.findShipmentOrderById(orderId);
    }
    public List<ShipmentOrder> getAllShipmentOrders() {
        return shipmentOrderRepository.getAllShipmentOrders();
    }
    public void updateShipmentOrder(ShipmentOrder updatedOrder) {
        shipmentOrderRepository.updateShipmentOrder(updatedOrder);
    }
    public void deleteShipmentOrder(String orderId) {
        shipmentOrderRepository.deleteShipmentOrder(orderId);
    }
    public void updateOrderStatus(String orderNumber, String newStatus) {
// TODO Auto-generated method stub
        ShipmentOrder order=getShipmentOrder(orderNumber);
        order.setStatus(newStatus);
        shipmentOrderRepository.updateShipmentOrder(order);
    }
}