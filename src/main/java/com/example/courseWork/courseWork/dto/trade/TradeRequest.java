package com.example.courseWork.courseWork.dto.trade;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record TradeRequest(
        Long id,
        @NotEmpty
        String supplierName,
        @NotEmpty
        String detalName,
        @NotNull
        int detalQuantity,
        @NotEmpty
        Date purchaseDate

){

    public TradeRequest(String supplierName, String detalName, int detalQuantity, Date purchaseDate){
        this(null, supplierName, detalName, detalQuantity, purchaseDate);
    }
}
