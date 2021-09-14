package com.comp301.a05driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ExpandingProximityIterator implements Iterator<Driver> {
    Iterable<Driver> driverPool;
    Iterator<Driver> pool;
    Position clientPos;
    int step;
    int stage = 0;
    Driver nextDriver = null;
    int remaining;

    public ExpandingProximityIterator(Iterable<Driver> driverPool, Position clientPosition, int expansionStep) {
        if (driverPool == null) {
            throw new IllegalArgumentException();
        }
        this.driverPool = driverPool;
        this.pool = driverPool.iterator();
        this.step = expansionStep;
        this.clientPos = clientPosition;
        for (Driver driver: driverPool) {
            remaining++;
        }
        loadDriver();
    }

    @Override
    public boolean hasNext() {
        return (remaining != 0);
    }

    @Override
    public Driver next() {
        if (hasNext()) {
            Driver currentDriver = nextDriver;
            nextDriver = null;
            remaining--;
            loadDriver();
            return currentDriver;
        } else {
            throw new NoSuchElementException();
        }
    }

    private void loadDriver() {
        if (!hasNext()) {
            return;
        }
        while (true) {
            while (pool.hasNext()) {
                Driver driver = pool.next();
                int distance = driver.getVehicle().getPosition().getManhattanDistanceTo(clientPos);
                if (distance <= (1 + stage * step) && distance > (1 + (stage - 1) * step)) {
                    nextDriver = driver;
                    return;
                }
            }
            stage++;
            pool = driverPool.iterator();
        }
    }
}
