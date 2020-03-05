package com.itechart.courses.nikolaichuk.exeption;

public class NoSuchPhotoException extends Exception {
    private String message;
    public NoSuchPhotoException(String mes){
        this.message = mes;
    }
    public String getMessage(){return message;};
}
