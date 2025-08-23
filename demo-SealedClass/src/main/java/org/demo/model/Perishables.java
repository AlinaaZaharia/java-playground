package org.demo.model;

import java.time.LocalDate;

public final class Perishables extends ShipmentItem {
    private LocalDate expirationDate;

    public Perishables(String itemId, LocalDate expirationDate){
        super(itemId);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate(){
        return expirationDate;
    }
}
