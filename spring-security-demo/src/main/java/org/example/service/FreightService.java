package org.example.service;

import org.example.payload.FreightDto;

import java.util.List;

public interface FreightService {
    FreightDto createFreight(long customerId, FreightDto freightDto);
    List<FreightDto> getFreightByCustomerId(long customerId);
    FreightDto getFreightById(long customerId,long orderId);
    FreightDto updateFreightById(long customerId, long orderId, FreightDto freightDto);
    void removeFreight(long customerId, long orderId);
}