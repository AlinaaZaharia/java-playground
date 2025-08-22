package org.app.model;

public class Shipment {
    private String orderID;
    private String trackingNumber;
    private String estimatedDeliveryTime;
    public Shipment(String orderID, String trackingNumber, String
            estimatedDeliveryTime) {
        this.orderID = orderID;
        this.trackingNumber = trackingNumber;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }
    public String getOrderID() {
        return orderID;
    }
    public String getTrackingNumber() {
        return trackingNumber;
    }
    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }
}
