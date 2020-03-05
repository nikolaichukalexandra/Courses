package com.itechart.courses.nikolaichuk.exeption;

import lombok.Data;

@Data
public class NoSuchItemException extends Exception {
    String message;
    public NoSuchItemException(String message){
        this.message = message;
    }
    public String getMessage(){return message;};
}
