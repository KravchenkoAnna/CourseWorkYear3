package com.example.courseWork.courseWork.dto.supplier;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record SupplierRequest(
            @NotEmpty
            String name,
            @NotNull
            String address,
            @NotNull
            String PhoneNumber
    ){}