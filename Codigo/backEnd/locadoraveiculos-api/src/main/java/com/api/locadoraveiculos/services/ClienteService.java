package com.api.locadoraveiculos.services;

import com.api.locadoraveiculos.models.ClienteModel;
import com.api.locadoraveiculos.models.EmpregoModel;
import com.api.locadoraveiculos.models.ClienteModel;
import com.api.locadoraveiculos.repositories.EmpregoRepository;
import com.api.locadoraveiculos.repositories.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteModel save(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }


    public Page<ClienteModel> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Optional<ClienteModel> findById(UUID id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public void delete(ClienteModel clienteModel) {
        clienteRepository.delete(clienteModel);
    }
}