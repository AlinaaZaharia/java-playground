package org.app.client;

import org.app.model.Shipment;
import org.app.model.ShipmentInfo;
import org.app.model.ShipmentItem;
import org.app.service.*;

import java.util.ArrayList;
import java.util.List;

public class ShipmentOrderClient {
    public static void main(String[] args) {
    // ShipmentConsumer Example
        Shipment shipmentOrder1 = new Shipment("1001", "K010", "2023- 08-15");
                Shipment shipmentOrder2 = new Shipment("1002", "K012", "2023- 08-16");
                Shipment shipmentOrder3 = new Shipment("1003", "K014", "2023- 08-17");
                ShipmentConsumerImpl consumerService = new ShipmentConsumerImpl();
        consumerService.displayShipmentDetails(shipmentOrder1);
    // FunctionCalculator Example
        List<ShipmentItem> shipmentItems = new ArrayList();
        shipmentItems.add(new ShipmentItem("I001", 10.0));
        shipmentItems.add(new ShipmentItem("I002", 15.0));
        shipmentItems.add(new ShipmentItem("I003", 30.0));
        shipmentItems.add(new ShipmentItem("I004", 35.0));
        FunctionCalculator calculator = new FunctionCalculatorImpl();
        double totalWeight =
                calculator.calculateTotalWeight(shipmentItems);
        System.out.println("Total Weight: " + totalWeight);
    // DelayedShipmentFilter Predicate Example
        List<ShipmentInfo> shipmentList = new ArrayList();
        shipmentList.add(new ShipmentInfo("1001", "Delayed", "2023- 08-15"));
                shipmentList.add(new ShipmentInfo("1002", "On Time", "2023- 08-16"));
                        DelayedShipmentFilter shipmentFilter = new DelayedShipmentFilterImpl();
        List<ShipmentInfo> delayedShipments =
                shipmentFilter.filterDelayedShipments(shipmentList);
        System.out.println("Delayed shipments:");
        delayedShipments.forEach(shipmentOrder ->
                System.out.println("Order ID: " + shipmentOrder.getOrderID()));
    }
}
