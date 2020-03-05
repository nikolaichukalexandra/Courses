package com.itechart.courses.nikolaichuk;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import com.itechart.courses.nikolaichuk.entity.Item;
import com.itechart.courses.nikolaichuk.entity.Order;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Manager manager = new Manager("Manager_01");

        Order orderFirst = new Order("01_order", LocalDate.of(2020, 03, 19));
        Order orderSecond = new Order("02_order", LocalDate.of(2020, 04, 10));

        Item itemFirst = new Item("01_item");
        Item itemSecond = new Item("02_item");
        Item itemThird = new Item("03_item");

        orderFirst.addItems(itemFirst);
        orderFirst.addItems(itemSecond);

        ArrayList<Order> orders = new ArrayList<Order>();
        orders.add(orderFirst);
        orders.add(orderSecond);
        try {
            manager.addOrder(orderFirst);
            manager.addOrder(orderSecond);

manager.addListOrderTOFile(orders);
            manager.showAllOrdersFromFile();
        } catch (IOException ex) {
            logger.info(ex.getMessage());
        }
    }
}



