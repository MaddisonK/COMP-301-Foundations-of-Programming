package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ProximityIterator implements Iterator<Driver> {
    Iterator<Driver> pool;
    Position clientPos;
    int range;
    Driver nextDriver = null;


    public ProximityIterator(Iterable<Driver> driverPool, Position clientPosition, int proximityRange) {
        if (driverPool == null || clientPosition == null) {
            throw new IllegalArgumentException();
        }
        this.clientPos = clientPosition;
        this.range = proximityRange;
        this.pool = driverPool.iterator();
        loadDriver();
    }


    @Override
    public boolean hasNext() {
        return (nextDriver != null);
    }

    @Override
    public Driver next() {
        if (hasNext()) {
            Driver currentDriver = nextDriver;
            nextDriver = null;
            loadDriver();
            return currentDriver;
        } else {
            throw new NoSuchElementException();
        }
    }

    private void loadDriver() {
        while (nextDriver == null && pool.hasNext()) {
            Driver driver = pool.next();
            if (driver.getVehicle().getPosition().getManhattanDistanceTo(clientPos) <= range) {
                nextDriver = driver;
                return;
            }
        }
    }
}
