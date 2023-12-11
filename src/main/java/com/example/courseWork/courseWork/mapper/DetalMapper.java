package com.example.courseWork.courseWork.mapper;

import com.example.courseWork.courseWork.dto.detal.DetalRequest;
import com.example.courseWork.courseWork.dto.detal.DetalResponse;
import com.example.courseWork.courseWork.entity.Detal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetalMapper {
    DetalRequest toDetalRequest(Detal detal);

    DetalResponse toDetalResponse(Detal detal);

    Detal fromDetalRequest(DetalRequest detalRequest);
}
