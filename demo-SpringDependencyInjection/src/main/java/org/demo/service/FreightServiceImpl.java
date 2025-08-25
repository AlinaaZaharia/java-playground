package org.demo.service;

import org.demo.repository.FreightRepository;
import org.demo.model.Freight;
import java.util.List;

public class FreightServiceImpl implements FreightService {
        private FreightRepository freightRepository;

        public void setFreightRepository(FreightRepository freightRepository)
        {
            this.freightRepository = freightRepository;
        }

        @Override
        public void createFreight(Freight freight) {
            freightRepository.createFreight(freight);
            System.out.println("Created Freight: " + freight);
        }

        @Override
        public Freight getFreightById(int orderId) {
            return freightRepository.getFreightById(orderId);
        }

        @Override
        public List<Freight> getAllFreight() {
            return freightRepository.getAllFreight();
        }

        @Override
        public void updateFreight(Freight freight) {
            freightRepository.updateFreight(freight);
        }

        @Override
        public void deleteFreight(int orderId) {
            Freight freight=freightRepository.getFreightById(orderId);
            freightRepository.deleteFreight(freight);
        }
}