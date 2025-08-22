package org.app.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class TrackingNumberGenerator {
    public static String generateTrackingNumber() {
    // Get the current date
        String currentDate = getCurrentDate();
    // Generate a unique identifier (UUID)
        String uniqueIdentifier = generateUniqueIdentifier();
    // Combine date and identifier to create the tracking number
        return currentDate + "-" + uniqueIdentifier;
    }

    private static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(new Date(0, 0, 0));
    }

    private static String generateUniqueIdentifier() {
        return UUID.randomUUID().toString().replaceAll("-",
                "").substring(0, 8);
    }}