package org.demo.model;

public class Freight {
    private Long orderId;
    private String origin;
    private String destination;

    public Freight(Long orderId, String origin, String destination) {
        this.orderId = orderId;
        this.origin = origin;
        this.destination = destination;
    }

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        System.out.println("setOrderId method invoked");
        this.orderId = orderId;
    }
    public String getOrigin() {
        System.out.println("setOrigin method invoked");
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

    @Override
    public String toString() {
        return "Freight{" +
                "orderId=" + orderId +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}