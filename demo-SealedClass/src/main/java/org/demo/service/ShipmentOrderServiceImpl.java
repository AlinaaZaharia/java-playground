package org.demo.service;

import org.demo.model.ShipmentOrder;
import org.demo.model.ShipmentStatus;
import org.demo.repo.ShipmentOrderRepository;

import java.util.List;

public class ShipmentOrderServiceImpl implements ShipmentOrderService{
    private ShipmentOrderRepository repository;

    public ShipmentOrderRepository getRepository() {
        return repository;
    }

    public ShipmentOrderServiceImpl(ShipmentOrderRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public void createShipment(ShipmentOrder shipmentOrder) {
        repository.getShipments().add(shipmentOrder);
    }
    //
    @Override
    public void updateShipmentStatus(String shipmentId, ShipmentStatus newStatus) {
        for (ShipmentOrder shipment : repository.getShipments()) {
            System.out.println("Prev Status"+shipment.getStatus());
            if (shipment.getOrderId().equals(shipmentId)) {
                shipment.setStatus(newStatus);
                break;
            }
            System.out.println("Updated Status"+shipment.getStatus());
        }
    }

    @Override
    public String generateShipmentLabel(ShipmentOrder order) {
        String shipmentLabel = """
                    Shipment Order Details
                    ----------------------
                    Order ID: %s
                    Source: %s
                    Destination: %s
                    Status: %s
                    Items:%s
                    ----------------------
                    """.formatted(order.getOrderId(), order.getSource(),
                order.getDestination(), order.getStatus(),order.getItems());
        return shipmentLabel;
    }

    @Override
    public List<ShipmentOrder> listAllShipmentOrders() {
        return repository.getShipments();
    }
}
