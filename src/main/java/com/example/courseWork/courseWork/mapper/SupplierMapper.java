package com.example.courseWork.courseWork.mapper;

import com.example.courseWork.courseWork.dto.supplier.SupplierRequest;
import com.example.courseWork.courseWork.dto.supplier.SupplierResponse;
import com.example.courseWork.courseWork.entity.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierRequest toSupplierRequest(Supplier supplier);

    Supplier fromSupplierRequest(SupplierRequest supplierRequest);

    SupplierResponse toSupplierResponse(Supplier supplier);

}
