package com.api.locadoraveiculos.services;

import com.api.locadoraveiculos.models.EmpregoModel;
import com.api.locadoraveiculos.repositories.EmpregoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpregoService {

    final EmpregoRepository empregoRepository;

    public EmpregoService(EmpregoRepository empregoRepository) {
        this.empregoRepository = empregoRepository;
    }

    @Transactional
    public EmpregoModel save(EmpregoModel empregoModel) {
        return empregoRepository.save(empregoModel);
    }


    public Page<EmpregoModel> findAll(Pageable pageable) {
        return empregoRepository.findAll(pageable);
    }

    public Optional<EmpregoModel> findById(UUID id) {
        return empregoRepository.findById(id);
    }

    public List<EmpregoModel> findAllByClienteId(UUID clienteId) {
        return empregoRepository.findAllByClienteId(clienteId);
    }

    @Transactional
    public void delete(EmpregoModel empregoModel) {
        empregoRepository.delete(empregoModel);
    }
}