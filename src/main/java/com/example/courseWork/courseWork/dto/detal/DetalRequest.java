package com.example.courseWork.courseWork.dto.detal;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.Date;

public record DetalRequest(
        @NotEmpty
        String name,
        @NotEmpty
        int artikul,
        @NotEmpty
        double price,
        @NotEmpty
        LocalDate dateOfSettingPrice
){}