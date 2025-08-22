package org.app.service;

import org.app.logistics.LogisticsProvider;
import org.app.logistics.LogisticsProviderImpl;
import org.app.model.ShipmentOrder;
import org.app.repository.ShipmentOrderRepository;
import java.util.*;

public class ShipmentOrderServiceImpl implements ShipmentOrderService {
    private ShipmentOrderRepository shipmentOrderRepository;
    private LogisticsProvider logisticsProvider;

    public ShipmentOrderServiceImpl() {
        shipmentOrderRepository = new ShipmentOrderRepository();
        logisticsProvider=new LogisticsProviderImpl();
    }

    public ShipmentOrder addShipmentOrder(ShipmentOrder shipmentOrder) {
        shipmentOrderRepository.addShipmentOrder(shipmentOrder);
        return shipmentOrder;
    }

    public ShipmentOrderServiceImpl(ShipmentOrderRepository shipmentOrderRepository) {
        super();
        this.shipmentOrderRepository = shipmentOrderRepository;
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

    public void updateOrderStatus(String orderNumber, String
            newStatus) {
    // TODO Auto-generated method stub
        ShipmentOrder order=getShipmentOrder(orderNumber);
        order.setStatus(newStatus);
        shipmentOrderRepository.updateShipmentOrder(order);
    }

    public String getEstimatedDeliveryTime(String trackingNumber) {
        int daysToDeliver =
                logisticsProvider.getDaysToDeliver(trackingNumber);
        return "Estimated delivery in " + daysToDeliver + " days";
    }

    @Override
    public String generateTrackingNumber() {
    // TODO Auto-generated method stub
        String trackingNumber = generateTrackingNumber();
        System.out.println("Generated Tracking Number: " +
                trackingNumber);
        return trackingNumber;
    }

    @Override
    public ShipmentOrder processShipmentOrder(ShipmentOrder processOrder) {
    // TODO Auto-generated method stub
        ShipmentOrder existingOrder =
                shipmentOrderRepository.findShipmentOrderById(processOrder.getOrderId());
        if (existingOrder!=null) {
        // If the order exists, update the quantity (or perform other processing)
            ShipmentOrder orderToUpdate = existingOrder;
            orderToUpdate.setOrderId(processOrder.getOrderId());
            orderToUpdate.setOrigin(processOrder.getOrigin());
            orderToUpdate.setDestination(processOrder.getDestination());
            orderToUpdate.setStatus(processOrder.getStatus());
            orderToUpdate.setWeight(processOrder.getWeight());
        // Save the updated order
            shipmentOrderRepository.updateShipmentOrder(orderToUpdate);
            return orderToUpdate;
        } else {
        // If the order does not exist, create a new one and save
            ShipmentOrder newOrder = new ShipmentOrder(processOrder.getOrderId(),processOrder.getOrigin(),processOrder.getDestination(),processOrder.getWeight(),processOrder.getStatus());
            shipmentOrderRepository.addShipmentOrder(newOrder);
            return newOrder;
        }
    }
}