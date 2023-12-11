package com.example.courseWork.courseWork.exception;

public class TradeNotFoundException  extends IllegalArgumentException{
    public TradeNotFoundException(String message){
        super(String.format("Trade with %s doesn't exist in the database", message));
    }
}
