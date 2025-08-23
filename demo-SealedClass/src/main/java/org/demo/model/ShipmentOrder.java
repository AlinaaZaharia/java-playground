package org.demo.model;

import java.util.List;

public class ShipmentOrder {
    private String orderId;
    private String source;
    private String destination;
    private ShipmentStatus status;
    private List<ShipmentItem> items;

    public ShipmentOrder(String orderId, String source, String destination, ShipmentStatus status, List<ShipmentItem> items) {
        super();
        this.orderId = orderId;
        this.source = source;
        this.destination = destination;
        this.status = status;
        this.items = items;
    }

    public ShipmentOrder() {
        super();
    }

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public ShipmentStatus getStatus() {
        return status;
    }
    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }
    public List<ShipmentItem> getItems() {
        return items;
    }
    public void setItems(List<ShipmentItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ShipmentOrder [orderId=" + orderId + ", source=" +
                source + ", destination=" + destination
                + ", status=" + status + ", items=" + items + "]";
    }
}
