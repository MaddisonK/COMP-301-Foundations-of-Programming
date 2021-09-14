package com.comp301.a05driver;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void test1() {
        Position pos1 = new PositionImpl(5, 5);
        Position pos2 = new PositionImpl(7, 7);
        Position pos3 = new PositionImpl(2, 2);

        Vehicle veh1 = new VehicleImpl("1", "1", "1", pos1);
        Vehicle veh2 = new VehicleImpl("2", "2", "2", pos2);
        Vehicle veh3 = new VehicleImpl("3", "3", "3", pos3);

        Driver driv1 = new DriverImpl("a", "1",1, veh1);
        Driver driv2 = new DriverImpl("b", "1",2, veh2);
        Driver driv3 = new DriverImpl("c", "1",3, veh3);

        Driver driv4 = new DriverImpl("a", "2",1, veh1);
        Driver driv5 = new DriverImpl("b", "2",2, veh2);
        Driver driv6 = new DriverImpl("c", "2",3, veh3);

        Driver driv7 = new DriverImpl("a", "3",1, veh1);
        Driver driv8 = new DriverImpl("b", "3",2, veh2);
        Driver driv9 = new DriverImpl("c", "3",3, veh3);


        List<Driver> array1 = new ArrayList<Driver>();
        array1.add(driv1);
        array1.add(driv2);
        array1.add(driv3);

        List<Driver> array2 = new ArrayList<Driver>();
        array2.add(driv4);
        array2.add(driv5);
        array2.add(driv6);

        List<Driver> array3 = new ArrayList<Driver>();
        array3.add(driv7);
        array3.add(driv8);
        array3.add(driv9);

        List<Iterable<Driver>> input = new ArrayList<>();
        input.add(array1);
        input.add(array2);
        input.add(array3);

        SnakeOrderAcrossPoolsIterator prox = new SnakeOrderAcrossPoolsIterator(input);

        System.out.println(prox.remaining);
        for (int item: prox.each) {
            System.out.println(item);
        }

        Driver next = prox.next(); // 1
        System.out.print(next.getFirstName()); System.out.println(next.getLastName());
        next = prox.next(); // 2
        System.out.print(next.getFirstName()); System.out.println(next.getLastName());
        next = prox.next(); // 3
        System.out.print(next.getFirstName()); System.out.println(next.getLastName());
        next = prox.next(); // 4
        System.out.print(next.getFirstName()); System.out.println(next.getLastName());
        next = prox.next(); // 5
        System.out.print(next.getFirstName()); System.out.println(next.getLastName());
        next = prox.next(); // 6
        System.out.print(next.getFirstName()); System.out.println(next.getLastName());
        next = prox.next(); // 7
        System.out.print(next.getFirstName()); System.out.println(next.getLastName());
        next = prox.next(); // 8
        System.out.print(next.getFirstName()); System.out.println(next.getLastName());
        next = prox.next(); // 9
        System.out.print(next.getFirstName()); System.out.println(next.getLastName());
        System.out.println(prox.hasNext());
    }
}
