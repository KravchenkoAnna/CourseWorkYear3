package com.example.courseWork.courseWork.dto.detal;

import java.time.LocalDate;
import java.util.Date;

public record DetalResponse(
        String name,
        double price,
        LocalDate dateOfSettingPrice
){}