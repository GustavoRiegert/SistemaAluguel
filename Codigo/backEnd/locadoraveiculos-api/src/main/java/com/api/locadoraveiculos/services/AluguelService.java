package com.api.locadoraveiculos.services;

import com.api.locadoraveiculos.models.AluguelModel;
import com.api.locadoraveiculos.repositories.AluguelRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class AluguelService {

    final AluguelRepository aluguelRepository;

    public AluguelService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    @Transactional
    public AluguelModel save(AluguelModel aluguelModel) {
        return aluguelRepository.save(aluguelModel);
    }


    public Page<AluguelModel> findAll(Pageable pageable) {
        return aluguelRepository.findAll(pageable);
    }

    public Optional<AluguelModel> findById(UUID id) {
        return aluguelRepository.findById(id);
    }

    @Transactional
    public void delete(AluguelModel aluguelModel) {
        aluguelRepository.delete(aluguelModel);
    }
}