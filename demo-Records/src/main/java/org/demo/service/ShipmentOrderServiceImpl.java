package org.demo.service;

import org.demo.model.ShipmentOrder;
import org.demo.model.ShipmentStatus;
import org.demo.repository.ShipmentOrderRepository;
import java.util.List;


public class ShipmentOrderServiceImpl implements ShipmentOrderService {
    private final ShipmentOrderRepository shipmentOrderRepository;

    public ShipmentOrderServiceImpl(ShipmentOrderRepository shipmentOrderRepository) {
        this.shipmentOrderRepository = shipmentOrderRepository;
    }

    @Override
    public void createShipment(ShipmentOrder shipmentOrder) {
        shipmentOrderRepository.getShipments().add(shipmentOrder);
    }

    @Override
    public void updateShipmentStatus(String shipmentId, ShipmentStatus newStatus) {
        shipmentOrderRepository.updateShipmentStatus(shipmentId, newStatus);
    }

    @Override
    public ShipmentOrder viewShipmentOrder(String orderId) {
        return shipmentOrderRepository.viewShipmentOrder(orderId);
    }

    @Override
    public List<ShipmentOrder> listAllShipmentOrders() {
        return shipmentOrderRepository.listAllShipmentOrders();
    }
}