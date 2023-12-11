package com.example.courseWork.courseWork.dto.detal;

import java.util.Date;

public record DetalResponse(
        Long artikul,
        String name,
        double price,
        Date dateOfSettingPrice
){}