package com.example.courseWork.courseWork.service;

import com.example.courseWork.courseWork.dto.detal.DetalRequest;
import com.example.courseWork.courseWork.dto.detal.DetalResponse;
import com.example.courseWork.courseWork.exception.DetalNotFoundException;
import com.example.courseWork.courseWork.mapper.DetalMapper;
import com.example.courseWork.courseWork.repository.DetalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DetalService {
    private final DetalRepository detalRepository;
    private final DetalMapper detalMapper;

    @Transactional
    public DetalResponse create(DetalRequest detalRequest){

        var detalToCreate = detalMapper.fromDetalRequest(detalRequest);

        var createdDetal = detalRepository.save(detalToCreate);
        return detalMapper.toDetalResponse(createdDetal);
    }

    @Transactional
    public DetalResponse update(Long id, DetalRequest detalRequest){

        var currentDetal = detalRepository.findById(id)
                .orElseThrow(() -> new DetalNotFoundException("id = " + id));

        currentDetal.setName(detalRequest.name());
        currentDetal.setArtikul(detalRequest.artikul());
        currentDetal.setPrice(detalRequest.price());
        currentDetal.setDateOfSettingPrice(detalRequest.dateOfSettingPrice());

        return detalMapper.toDetalResponse(currentDetal);
    }
    @Transactional
    public void delete(Long id){
        detalRepository.findById(id)
                .orElseThrow(() -> new DetalNotFoundException("id = " + id));
        detalRepository.deleteById(id);
    }

    public DetalResponse findById(Long id){
        var retrievedDetal = detalRepository.findById(id)
                .orElseThrow(() -> new DetalNotFoundException("id = " + id));
        return detalMapper.toDetalResponse(retrievedDetal);
    }

    public List<DetalResponse> getAll(){
        return detalRepository.findAllBy(DetalResponse.class);
    }
}
