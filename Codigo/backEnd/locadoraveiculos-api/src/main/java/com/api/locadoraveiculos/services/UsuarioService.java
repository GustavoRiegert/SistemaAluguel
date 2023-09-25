package com.api.locadoraveiculos.services;

import com.api.locadoraveiculos.models.ClienteModel;
import com.api.locadoraveiculos.models.EmpregoModel;
import com.api.locadoraveiculos.models.UsuarioModel;
import com.api.locadoraveiculos.repositories.EmpregoRepository;
import com.api.locadoraveiculos.repositories.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public UsuarioModel save(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }


    public Page<UsuarioModel> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    public Optional<UsuarioModel> findById(UUID id) {
        return usuarioRepository.findById(id);
    }

    public Optional<UsuarioModel> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    @Transactional
    public void delete(UsuarioModel usuarioModel) {
        usuarioRepository.delete(usuarioModel);
    }
}