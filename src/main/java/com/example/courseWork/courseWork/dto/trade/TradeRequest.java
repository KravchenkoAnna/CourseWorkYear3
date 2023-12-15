package com.example.courseWork.courseWork.dto.trade;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record TradeRequest(
        Long id,
        @NotEmpty
        String supplierName,
        @NotEmpty
        String detalName,
        @NotNull
        int detalQuantity,

        LocalDate purchaseDate

){

}
