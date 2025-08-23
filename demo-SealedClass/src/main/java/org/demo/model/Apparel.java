package org.demo.model;

public final class Apparel extends ShipmentItem{
    private String fabricType;

    public Apparel(String itemId, String fabricType) {
        super(itemId);
        this.fabricType = fabricType;
    }

    public String getFabricType() {
        return fabricType;
    }
}