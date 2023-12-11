package com.example.courseWork.courseWork.mapper;

import com.example.courseWork.courseWork.dto.trade.TradeResponse;
import com.example.courseWork.courseWork.entity.Trade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TradeMapper {
    @Mappings({
            @Mapping(target = "supplierName", source = "supplier.name"),
            @Mapping(target = "detalName", source = "detal.name")
    })
    TradeResponse toTradeResponse(Trade trade);
}