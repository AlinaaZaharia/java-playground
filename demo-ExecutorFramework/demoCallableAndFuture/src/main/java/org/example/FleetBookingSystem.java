package org.example;

import java.sql.Time;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FleetBookingSystem implements Callable<String> {
    public static int availableFleets = 0;
    private static final Object lock = new Object();
    private int requiredFleets;
    private boolean booking;

    public FleetBookingSystem(int requiredFleets, boolean booking){
        this.requiredFleets = requiredFleets;
        this.booking = booking;
    }


    @Override
    public String call() throws InterruptedException{
        if(booking){
            try{
                bookSeat(requiredFleets);
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            return "Booking complete!";
        } else{
            cancelSeat(requiredFleets);
            return "Cancellation complete!";
        }
    }


    public void bookSeat(int requiredFleets) throws InterruptedException{
        synchronized (lock) {
            while(availableFleets<requiredFleets){
                lock.wait();
            }

            try{
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Your fleets are booked!");
                availableFleets -= requiredFleets;
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    public void cancelSeat(int requiredFleets){
        synchronized (lock){
            try{
                TimeUnit.SECONDS.sleep(2);
                availableFleets += requiredFleets;
                System.out.println("Seat canceled successfully!");
                lock.notify();

            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
