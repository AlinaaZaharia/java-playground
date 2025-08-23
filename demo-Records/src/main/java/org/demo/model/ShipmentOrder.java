package org.demo.model;

import java.util.List;

public record ShipmentOrder(String orderID, String source, String destination, List<ShipmentItem> shipmentItems, ShipmentStatus status) {
}
