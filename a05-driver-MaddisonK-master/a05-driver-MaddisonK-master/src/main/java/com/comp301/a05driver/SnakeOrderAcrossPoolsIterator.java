package com.comp301.a05driver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SnakeOrderAcrossPoolsIterator implements Iterator<Driver> {
    List<Iterator<Driver>> pool = new ArrayList<>();
    Driver nextDriver = null;
    int remaining = 0;
    int[] each;
    int poolsNum;
    int p = 0; //index
    boolean ascend = true;

    public SnakeOrderAcrossPoolsIterator(List<Iterable<Driver>> driverPools) {
        poolsNum = driverPools.size();
        each = new int[poolsNum];
        for (int i = 0; i<poolsNum; i++) {
            int tempCount = 0;
            for (Driver driver: driverPools.get(i)) {
                tempCount++;
            }
            remaining += tempCount;
            each[i] = tempCount;
            pool.add(driverPools.get(i).iterator());
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
            if (ascend) {
                while (p < poolsNum) {
                    if (pool.get(p).hasNext()) {
                        nextDriver = pool.get(p).next();
                        p++;
                        return;
                    }
                    p++;
                }
                ascend = false;
                p--;
                continue;
            }
            if (!ascend) {
                while (p >= 0) {
                    if (pool.get(p).hasNext()) {
                        nextDriver = pool.get(p).next();
                        p--;
                        return;
                    }
                    p--;
                }
                ascend = true;
                p++;
            }
        }
    }
}
