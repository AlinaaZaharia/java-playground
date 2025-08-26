package org.demo.service;

import org.demo.model.Freight;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class FreightManagementServiceImpl implements FreightManagementService{
    private final List<Freight> freights = new ArrayList<>();

    @Override
    public List<Freight> getAllFreights() {
        return freights;
    }

    @Override
    public Freight getFreightById(long orderId) {
        for (Freight freight : freights) {
            if (freight.getOrderId() == orderId) {
                return freight;
            }
        }
        return null;
    }

    public List<Freight> getFreightByOriginAndDestination(String origin,
                                                          String destination) {
        List<Freight> matchingFreights = new ArrayList<>();
        for (Freight freight : freights) {
        // Comparing after trimming whitespace and ignoring case
            if (freight.getOrigin().trim().equalsIgnoreCase(origin.trim())
                    &&
                    freight.getDestination().trim().equalsIgnoreCase(destination.trim())) {
                matchingFreights.add(freight);
            }
        }
        return matchingFreights;
    }

    @Override
    public void saveFreight(Freight freight) {
        // Check if a Freight with the same orderId already exists
        if (freightExists(freight.getOrderId())) {
            throw new IllegalArgumentException("Freight with Order ID " +
                    freight.getOrderId() + " already exists.");
        }
        // Add the freight to the list
        freights.add(freight);
    }

    public boolean freightExists(long orderId) {
        for (Freight freight : freights) {
            if (freight.getOrderId() == orderId) {
                return true; // Freight with the same Order ID exists
            }
        }
        return false; // Freight with the given Order ID doesn't exist
    }

    @Override
    public void updateFreight(Freight freight) {
        for (int i = 0; i < freights.size(); i++) {
            if (freights.get(i).getOrderId() == freight.getOrderId()) {
                freights.set(i, freight);
                break;
            }
        }
    }

    @Override
    public boolean deleteFreight(long orderId) {
        Freight freightToRemove = null;for (Freight freight : freights) {
            if (freight.getOrderId() == orderId) {
                freightToRemove = freight;
                break;
            }
        }
        if (freightToRemove != null) {
            freights.remove(freightToRemove);
            System.out.println("Freight deleted: " + freightToRemove);
            return true; // Successfully deleted
        } else {
            return false; // Freight not found
        }
    }
}