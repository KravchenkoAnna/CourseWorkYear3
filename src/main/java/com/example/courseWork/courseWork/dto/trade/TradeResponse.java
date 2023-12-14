package com.example.courseWork.courseWork.dto.trade;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record TradeResponse(
        Long id,
        @NotEmpty
        String supplierName,
        @NotEmpty
        String detalName,
        @NotEmpty
        int detalQuantity,
        @NotEmpty
        LocalDate purchaseDate
){}

