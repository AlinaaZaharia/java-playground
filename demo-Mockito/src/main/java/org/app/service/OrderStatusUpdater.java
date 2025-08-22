package org.app.service;

public interface OrderStatusUpdater {
    void updateOrderStatus(String orderID, String destination);
}
