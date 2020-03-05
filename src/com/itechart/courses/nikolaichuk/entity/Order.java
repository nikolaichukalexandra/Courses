package com.itechart.courses.nikolaichuk.entity;

import com.itechart.courses.nikolaichuk.Main;
import com.itechart.courses.nikolaichuk.enums.OrderState;
import com.itechart.courses.nikolaichuk.exeption.NoSuchItemException;
import lombok.Data;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order implements Serializable {
    private static Logger logger = LogManager.getLogger(Main.class);
    String name;

    LocalDate creationDate;
    LocalDate planDate;
    LocalDate completionDate;

    OrderState orderState;

    Double totalCost;

    int itemsCount;

    ArrayList<Item> itemList;
    List<Photo> photoList;

    LocalDate localDate = LocalDate.now();

    public Order(String name, LocalDate planDate) {
        this.name = name;
        this.creationDate = LocalDate.now();
        this.planDate = planDate;
        this.itemList = new ArrayList<Item>();
        this.orderState = OrderState.COMPLETED;

        logger.info("Order " + name + " " + creationDate + " " + planDate + orderState + " created");
    }

    public void addItems(Item item) {
        itemList.add(item);
        logger.info("Item " + item.toString() + " was added");
    }

    public void removeItem(Item item) throws NoSuchItemException {
        if (itemList.contains(item)) {
            itemList.remove(item);
            logger.info("Item " + name + " was removed");
        } else throw new NoSuchItemException("Item is not found");
    }


    @Override
    public String toString() {
        return name + " " + creationDate + " " + planDate + " " + orderState;
    }

}
