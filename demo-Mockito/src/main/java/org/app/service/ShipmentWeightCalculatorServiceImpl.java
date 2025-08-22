package org.app.service;

import org.app.model.ShipmentItem;

import java.util.List;
import java.util.function.Function;

public class ShipmentWeightCalculatorServiceImpl implements ShipmentWeightCalculatorService {

    public double calculateTotalWeight(List<ShipmentItem> shipmentItems) {
        Function<List<ShipmentItem>, Double> calculateTotalWeight =
                itemList -> {
                    double totalWeight = 0.0;
                    for (ShipmentItem item : itemList) {
                        totalWeight += item.getWeight();
                    }
                    return totalWeight;
                };
        return calculateTotalWeight.apply(shipmentItems);
    }
}