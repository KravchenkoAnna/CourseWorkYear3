package com.example.courseWork.courseWork.service;

import com.example.courseWork.courseWork.dto.trade.AgregatedTrade;
import com.example.courseWork.courseWork.dto.trade.TradeRequest;
import com.example.courseWork.courseWork.dto.trade.TradeResponse;
import com.example.courseWork.courseWork.entity.Detal;
import com.example.courseWork.courseWork.entity.Supplier;
import com.example.courseWork.courseWork.entity.Trade;
import com.example.courseWork.courseWork.exception.DetalNotFoundException;
import com.example.courseWork.courseWork.exception.SupplierNotFoundException;
import com.example.courseWork.courseWork.exception.TradeNotFoundException;
import com.example.courseWork.courseWork.mapper.TradeMapper;
import com.example.courseWork.courseWork.repository.DetalRepository;
import com.example.courseWork.courseWork.repository.SupplierRepository;
import com.example.courseWork.courseWork.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TradeService {
    private final TradeRepository tradeRepository;
    private final TradeMapper tradeMapper;

    private final SupplierRepository supplierRepository;
    private final DetalRepository detalRepository;


    @Transactional
    public TradeResponse create(TradeRequest tradeRequest){

        Supplier supplier = mapToSupplier(tradeRequest);
        Detal detal = mapToDetal(tradeRequest);
        Trade trade = mapToTrade(tradeRequest, detal, supplier);

        tradeRepository.save(trade);
        return tradeMapper.toTradeResponse(trade);
    }


    public TradeResponse update(Long id, TradeRequest tradeRequest){
        Trade trade = tradeRepository.findById(id)
                .orElseThrow(() -> new TradeNotFoundException("id = " + id));

        Supplier supplier = supplierRepository.findByNameIgnoreCase(tradeRequest.supplierName())
                .orElseThrow(() -> new SupplierNotFoundException("name = " + tradeRequest.supplierName()));

        Detal detal = mapToDetal(tradeRequest);

        trade.setSupplier(supplier);
        trade.setDetal(detal);
        trade.setDetalQuantity(tradeRequest.detalQuantity());
        trade.setPurchaseDate(tradeRequest.purchaseDate());

        return tradeMapper.toTradeResponse(trade);
    }
    @Transactional
    public void delete(Long id){
        /*var retrievedTrade = */tradeRepository
                .findById(id).orElseThrow(() -> new TradeNotFoundException("id = " + id));
        tradeRepository.deleteById(id);
    }

    public List<AgregatedTrade> findAll() {
        return tradeRepository.findAllByOrderById(AgregatedTrade.class);
    }

    public TradeResponse findById(Long id) {
        return tradeRepository.findTradeById(id, TradeResponse.class)
                .orElseThrow(() -> new TradeNotFoundException("id = " + id));
    }



    private Detal mapToDetal(TradeRequest tradeRequest) {
        return detalRepository.findByNameIgnoreCase(tradeRequest.detalName())
                .orElseThrow(() -> new DetalNotFoundException("name = " + tradeRequest.detalName()));

    }

    private Supplier mapToSupplier(TradeRequest tradeRequest) {
        return supplierRepository.findByNameIgnoreCase(tradeRequest.supplierName())
                .orElse(new Supplier(tradeRequest.supplierName(), "None", "None"));
    }
    private Trade mapToTrade(TradeRequest tradeRequest, Detal detal, Supplier supplier){
        return Trade
                .builder()
                .detal(detal)
                .supplier(supplier)
                .detalQuantity(tradeRequest.detalQuantity())
                .purchaseDate(tradeRequest.purchaseDate())
                .build();
    }
}
