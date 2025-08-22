package org.app.model;

public class ShipmentItem {
    private String name;
    private double weight;
    public ShipmentItem(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }
}
