package org.app.service;

import org.app.model.ShipmentItem;

import java.util.List;

public interface ShipmentWeightCalculatorService {
    double calculateTotalWeight(List<ShipmentItem> shipmentItems);
}
