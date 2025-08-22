package org.app.model;

public class ShipmentOrder {
    private String orderId;
    private String origin;
    private String destination;
    private String status;
    private double weight;
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "ShipmentOrder [orderId=" + orderId + ", origin=" +
                origin + ", destination=" + destination + ", status="
                + status + ", weight=" + weight + "]";
    }
    public ShipmentOrder() {
        super();
// TODO Auto-generated constructor stub
    }
    public ShipmentOrder(String orderId, String origin, String
            destination, String status, double weight) {
        super();
        this.orderId = orderId;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
        this.weight = weight;
    }
}
