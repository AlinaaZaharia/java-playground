package org.demo.service;

import org.demo.model.Freight;

import java.util.List;

public interface FreightManagementService {
    List<Freight> getAllFreights();
    Freight getFreightById(long orderId);
    List<Freight> getFreightByOriginAndDestination(String origin, String destination);
    void saveFreight(Freight freight);
    void updateFreight(Freight freight);
    boolean deleteFreight(long orderId);
}