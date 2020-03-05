package com.itechart.courses.nikolaichuk.entity;

import com.itechart.courses.nikolaichuk.Main;
import com.itechart.courses.nikolaichuk.exeption.NoSuchOrderException;
import lombok.Data;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

@Data
public class Customer {
    private static Logger logger = LogManager.getLogger(Main.class);
    String name;
    String email;
    ArrayList<Order> customerOrderList;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;

        logger.info("Customer " + name + " created");
    }

    public void createOrder(Order order) {
        customerOrderList.add(order);

        logger.info("Order " + order.toString() + " was created");
    }

    public void deleteOrder(Order order) throws NoSuchOrderException {
        if (customerOrderList.contains(order)){
            customerOrderList.remove(order);
        } else throw new NoSuchOrderException(order.toString() + " order is not exist");
    }

}
