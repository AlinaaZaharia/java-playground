package org.demo.exception;

public class ShipmentOrderNotFoundException extends RuntimeException {
    public ShipmentOrderNotFoundException(String message) {
        super(message);
    }
}
