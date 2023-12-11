package com.example.courseWork.courseWork.dto.detal;

import java.util.Date;

public record DetalResponse(
        String name,
        double price,
        Date dateOfSettingPrice
){}