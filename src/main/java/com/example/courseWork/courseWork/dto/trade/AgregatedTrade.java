package com.example.courseWork.courseWork.dto.trade;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record AgregatedTrade(
        Long id,
        String supplierName,

        String detalName,
        int detalQuantity,
        Date purchaseDate
){}

