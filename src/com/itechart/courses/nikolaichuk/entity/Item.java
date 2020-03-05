package com.itechart.courses.nikolaichuk.entity;

import com.itechart.courses.nikolaichuk.Main;
import com.itechart.courses.nikolaichuk.exeption.NoSuchPhotoException;
import lombok.Data;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class Item implements Serializable {
    private static Logger logger = LogManager.getLogger(Main.class);
    String name;
    Double cost;
    int releaseDateFrom;
    int releaseDateTo;
    String color;
    String category;

    ArrayList<Photo> photos;
    boolean isFresh;

    String note;

    public Item(String name) {
        this.name = name;
    }


    public Item(String name, Double cost, boolean isFresh) {
        this.name = name;
        this.cost = cost;
        this.isFresh = isFresh;
    }

    public void addPhoto(String name, byte[] image) {
        photos.add(new Photo(name, image));
        logger.info("Photo " + name + " was added");
    }

    public void deletePhotoByName(Photo photo) throws NoSuchPhotoException {
        if (photos.contains(photo)) {
            photos.remove(photo);
            logger.info("Photo " + photo.toString() + " was removed");
        } else throw new NoSuchPhotoException("Photo is not found");
    }

    @Override
    public String toString() {
        return name + " " + cost;
    }


}