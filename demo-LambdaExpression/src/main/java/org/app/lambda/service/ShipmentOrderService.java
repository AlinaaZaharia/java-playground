package org.app.lambda.service;

import org.app.lambda.model.ShipmentOrder;

import java.util.ArrayList;
import java.util.List;


public class ShipmentOrderService {
    private List<ShipmentOrder> shipments;

    public ShipmentOrderService(List<ShipmentOrder> shipments) {
        this.shipments = shipments;
    }

    public List<ShipmentOrder> getDelayedShipments(ShipmentPredictor predictor, int threshold){
        List<ShipmentOrder> delayedShipments = new ArrayList<>();
        shipments.forEach(shipment -> {
            if(predictor.predictDeliveryTime(shipment) > threshold){
                delayedShipments.add(shipment);
            }
        });
        return delayedShipments;
    }

    public void trackShipments(){
        for(ShipmentOrder shipment : shipments){
            System.out.println("Tracking shipment: " + shipment.getOrigin() + " to " + shipment.getDestination());
        }
    }
}