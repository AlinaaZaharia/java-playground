package org.app.service;

import org.app.model.ShipmentInfo;

import java.util.List;

public interface DelayedShipmentFilter {
    List<ShipmentInfo> filterDelayedShipments(List<ShipmentInfo> shipmentList);
}