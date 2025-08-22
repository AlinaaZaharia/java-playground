package org.app.repository;

import java.util.ArrayList;
import java.util.List;
import org.app.model.ShipmentOrder;


public class ShipmentOrderRepository {
    private List shipmentOrders;
    public ShipmentOrderRepository() {
        shipmentOrders = new ArrayList();
    }

    @SuppressWarnings("unchecked")
    public ShipmentOrder addShipmentOrder(ShipmentOrder shipmentOrder) {
        shipmentOrders.add(shipmentOrder);
        return shipmentOrder;
    }

    public ShipmentOrder findShipmentOrderById(String orderId) {
        for (Object obj: shipmentOrders) {
            ShipmentOrder order=(ShipmentOrder)obj;
            if (order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    public List<ShipmentOrder> getAllShipmentOrders() {
        return new ArrayList(shipmentOrders);
    }

    public void updateShipmentOrder(ShipmentOrder updatedOrder) {
        for (int i = 0; i < shipmentOrders.size(); i++) {
            if (((ShipmentOrder)
                    shipmentOrders.get(i)).getOrderId().equals(updatedOrder.getOrderId()))
            {
                shipmentOrders.set(i, updatedOrder);
                return;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void deleteShipmentOrder(String orderId) {
        shipmentOrders.removeIf(order -> ((ShipmentOrder)
                order).getOrderId().equals(orderId));
    }
}