package com.example.courseWork.courseWork.dto.detal;

import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public record DetalRequest(
        @NotEmpty
        String name,
        @NotEmpty
        double price,
        @NotEmpty
        Date dateOfSettingPrice
){}