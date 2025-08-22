package org.app.model;

public class ShipmentInfo {
    private String orderID;
    private String deliveryStatus;
    private String estimatedDeliveryTime;
    public String getOrderID() {
        return orderID;
    }
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    public String getDeliveryStatus() {
        return deliveryStatus;
    }
    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }
    public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }
    public ShipmentInfo() {
        super();
// TODO Auto-generated constructor stub
    }
    public ShipmentInfo(String orderID, String deliveryStatus, String
            estimatedDeliveryTime) {
        super();
        this.orderID = orderID;
        this.deliveryStatus = deliveryStatus;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }
    @Override
    public String toString() {
        return "ShipmentInfo [orderID=" + orderID + ", deliveryStatus=" +
                deliveryStatus + ", estimatedDeliveryTime="
                + estimatedDeliveryTime + "]";
    }
}
