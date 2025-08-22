package org.app.lambda.client;

import org.app.lambda.model.ShipmentOrder;
import org.app.lambda.service.ShipmentOrderService;
import org.app.lambda.service.ShipmentPredictor;

import java.util.*;

public class ShipmentOrderClient {
    public static void main(String[] args) {
        try{
            List<ShipmentOrder> shipments = Arrays.asList(new ShipmentOrder("Origin1", "Destination1", 10.0, "Air"), new ShipmentOrder("Origin2", "Destination2", 20.0, "Ground"));

            ShipmentOrderService logisticsSystem = new ShipmentOrderService(shipments);

            ShipmentPredictor predictor = shipment -> {
                if ("Air".equals(shipment.getShippingMethod())) {
                    return 2;
                } else {
                    return 5;
                }
            };

            int delayThreshold = 3;
            List<ShipmentOrder> delayedShipments = logisticsSystem.getDelayedShipments(predictor, delayThreshold);

            System.out.println("Delayed shipments: ");
            for(ShipmentOrder shipment : delayedShipments) {
                System.out.println(shipment.getOrigin() + " to " + shipment.getDestination());
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
