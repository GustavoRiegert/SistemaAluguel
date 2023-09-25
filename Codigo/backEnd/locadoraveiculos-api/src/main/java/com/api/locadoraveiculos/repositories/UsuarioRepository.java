package com.api.locadoraveiculos.repositories;

import com.api.locadoraveiculos.models.ClienteModel;
import com.api.locadoraveiculos.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {

    Optional<UsuarioModel> findByLogin(String login);

}
