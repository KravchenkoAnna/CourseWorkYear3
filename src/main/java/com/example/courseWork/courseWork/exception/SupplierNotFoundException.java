package com.example.courseWork.courseWork.exception;

import com.example.courseWork.courseWork.entity.Supplier;

public class SupplierNotFoundException extends IllegalArgumentException{
    public SupplierNotFoundException(String message) {
        super(String.format("Supplier with %s doesn't exist in the database", message));
    }
}
