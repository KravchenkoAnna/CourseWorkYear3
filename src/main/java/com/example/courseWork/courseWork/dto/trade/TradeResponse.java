package com.example.courseWork.courseWork.dto.trade;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record TradeResponse(
        Long id,
        String supplierName,
        String detalName,

        int detalQuantity,

        LocalDate purchaseDate
){}

