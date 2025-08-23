package org.demo.model;

public class ShipmentItem {
    private String itemId;
    private String description;
    private int quantity;
    private int weight;

    public ShipmentItem(String itemId, String description, int quantity, int weight) {
        super();
        this.itemId = itemId;
        this.description = description;
        this.quantity = quantity;
        this.weight = weight;
    }

    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ShipmentItem [itemId=" + itemId + ", description=" +
                description + ", quantity=" + quantity
                + ", weight=" + weight + "]";
    }
}
