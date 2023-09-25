package com.api.locadoraveiculos.repositories;

import com.api.locadoraveiculos.models.AluguelModel;
import com.api.locadoraveiculos.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AluguelRepository extends JpaRepository<AluguelModel, UUID> {


}
