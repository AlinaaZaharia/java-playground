package org.demo.model;

public final class Electronics extends ShipmentItem{
    private double dimensions;

    public Electronics(String itemId, double dimensions) {
        super(itemId);
        this.dimensions = dimensions;
    }

    public double getDimensions() {
        return dimensions;
    }
}