package org.demo.repository;

import org.demo.model.Freight;

import java.util.List;

public interface FreightRepository {
    void createFreight(Freight freight);
    Freight getFreightById(int orderId);
    List<Freight> getAllFreight();
    void updateFreight(Freight freight);
    void deleteFreight(Freight freight);
}