package com.api.locadoraveiculos.repositories;

import com.api.locadoraveiculos.models.EmpregoModel;
import com.api.locadoraveiculos.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmpregoRepository extends JpaRepository<EmpregoModel, UUID> {
    List<EmpregoModel> findAllByClienteId(UUID clienteId);
}
