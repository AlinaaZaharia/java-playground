package org.app.service;

import org.app.model.ShipmentItem;
import java.util.List;

public interface FunctionCalculator {
    double calculateTotalWeight(List<ShipmentItem> shipmentItems);
}
