package com.itechart.courses.nikolaichuk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Photo {

    private String name;
    private byte[] image;
    private LocalDate date;
    private String note;

    public Photo(String name, byte[] image) {
        this.name = name;
        this.image = image;
    }

    public Photo(String name, byte[] image, String note) {
        this.name = name;
        this.image = image;
        this.note = note;
    }

    @Override
    public String toString(){
        return name + " " + note;
    }
}
