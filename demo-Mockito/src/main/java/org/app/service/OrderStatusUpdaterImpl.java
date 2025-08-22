package org.app.service;

public class OrderStatusUpdaterImpl implements OrderStatusUpdater{
    @Override
    public void updateOrderStatus(String orderID, String destination) {
        System.out.println("Order " + orderID + " marked as shipped to: " + destination);
    }
}