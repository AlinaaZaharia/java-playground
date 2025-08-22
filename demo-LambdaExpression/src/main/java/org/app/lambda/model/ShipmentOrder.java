package org.app.lambda.model;

public class ShipmentOrder {
    private String origin;
    private String destination;
    private double weight;
    private String shippingMethod;

    public ShipmentOrder(String origin, String destination, double weight, String shippingMethod) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        this.shippingMethod = shippingMethod;
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

    public String getShippingMethod() {
        return shippingMethod;
    }
}
