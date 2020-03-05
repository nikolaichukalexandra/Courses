package com.itechart.courses.nikolaichuk;

import com.itechart.courses.nikolaichuk.Main;
import com.itechart.courses.nikolaichuk.entity.Customer;
import com.itechart.courses.nikolaichuk.entity.Item;
import com.itechart.courses.nikolaichuk.entity.Order;
import com.itechart.courses.nikolaichuk.exeption.NoSuchOrderException;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class Manager {
    private static Logger logger = LogManager.getLogger(Main.class);

    String name;
    ArrayList<Order> orderList;
    Customer customer;

    public Manager(String name) {
        this.name = name;
        orderList = new ArrayList<Order>();
    }


    public void addOrder(Order order) throws IOException {
        orderList.add(order);

        logger.info("Order added to Manager list.");
    }

    public void addListOrderTOFile(ArrayList<Order> list) throws IOException {
        ObjectOutputStream to = new ObjectOutputStream(new FileOutputStream("order.txt"));
        to.writeObject(list);
        to.close();
        logger.info("Order added to file.");

    }

    void showAllOrdersFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("order.txt"));
        ArrayList<Order> orders = (ArrayList<Order>) in.readObject();

        logger.info("Manager show all from file:");
        logger.info(orders.toString());

    }


}





