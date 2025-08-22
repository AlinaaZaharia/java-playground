package org.app.client;

import org.app.model.ShipmentOrder;
import org.app.service.ShipmentOrderDeliveryPredictor;
import org.app.service.ShipmentOrderService;

import java.util.Arrays;
import java.util.List;


public class ShipmentOrderClient {
    public static void main(String[] args) {

        try {
            List<ShipmentOrder> shipmentOrders = Arrays.asList(
                    new ShipmentOrder("Origin1", "Destination1", 10.0, "Air"),
                    new ShipmentOrder("Origin2", "Destination2", 20.0, "Ground")
            );
            ShipmentOrderService logisticsSystem = new ShipmentOrderService(shipmentOrders);
            logisticsSystem.trackShipments();

            // Create instances of DeliveryPredictor using method references
            ShipmentOrderDeliveryPredictor airPredictor = ShipmentOrderClient::predictAirDelivery;
            ShipmentOrderDeliveryPredictor groundPredictor = ShipmentOrderClient::predictGroundDelivery;

            int delayThreshold = 3;
            List<ShipmentOrder> delayedShipmentOrders =
                    logisticsSystem.getDelayedShipments(
                            shipmentOrder -> airPredictor.predictDeliveryTime(shipmentOrder) > delayThreshold ||
                                    groundPredictor.predictDeliveryTime(shipmentOrder) > delayThreshold,
                                    delayThreshold
                    );

            System.out.println("Delayed shipmentOrders:");
            delayedShipmentOrders.forEach(shipmentOrder ->
                                                    System.out.println(shipmentOrder.getOrigin() + " to " +
                                                    shipmentOrder.getDestination() +
                                                            " - Predicted Delivery Time: " +
                                                    (airPredictor.predictDeliveryTime(shipmentOrder) >
                                                            delayThreshold ?
                                                            airPredictor.predictDeliveryTime(shipmentOrder) :
                                                            groundPredictor.predictDeliveryTime(shipmentOrder)))
            );
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    // Predicts delivery time for air shipments
    private static int predictAirDelivery(ShipmentOrder shipmentOrder) {
        return "Air".equals(shipmentOrder.getShippingMethod()) ? 2 : 5;
    }

    // Predicts delivery time for ground shipments
    private static int predictGroundDelivery(ShipmentOrder shipmentOrder)
    {
        return "Ground".equals(shipmentOrder.getShippingMethod()) ? 5 : 2;
    }
}