package com.example.courseWork.courseWork.dto.detal;

import java.time.LocalDate;
import java.util.Date;

public record DetalResponse(
        Long id,
        String name,
        int artikul,
        double price,
        LocalDate dateOfSettingPrice
){}