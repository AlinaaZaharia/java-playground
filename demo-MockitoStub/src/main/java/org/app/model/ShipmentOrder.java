package org.app.model;

import java.util.Objects;

public class ShipmentOrder {
    private String orderId;
    private String origin;
    private String destination;
    private double weight;
    private String status;
    public ShipmentOrder(String orderId, String origin, String destination, double weight, String status) {
        super();
        this.orderId = orderId;
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        this.status = status;
    }

    public ShipmentOrder(String orderId, String origin, String
            destination, double weight) {
        super();
        this.orderId = orderId;
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ShipmentOrder() {
        super();
    // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "ShipmentOrder [orderId=" + orderId + ", origin=" +
                origin + ", destination=" + destination + ", weight="
                + weight + ", status=" + status + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, orderId, origin, status,
                weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ShipmentOrder other = (ShipmentOrder) obj;
        return Objects.equals(destination, other.destination) &&
                Objects.equals(orderId, other.orderId)
                && Objects.equals(origin, other.origin) &&
                Objects.equals(status, other.status)
                && Double.doubleToLongBits(weight) ==
                Double.doubleToLongBits(other.weight);
    }
}