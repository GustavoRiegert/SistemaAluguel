package com.api.locadoraveiculos.controllers;

import com.api.locadoraveiculos.dtos.UsuarioDto;
import com.api.locadoraveiculos.models.UsuarioModel;
import com.api.locadoraveiculos.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuario")
public class UsuarioController {

    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDto, usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioModel));
    }

    @PostMapping("/login")
    public  ResponseEntity<Object> login(@RequestBody @Valid UsuarioDto usuarioDto){
        Optional<UsuarioModel> usuario = usuarioService.findByLogin(usuarioDto.getLogin());
        if(usuario.isPresent() && usuario.get().getSenha().compareTo(usuarioDto.getSenha()) == 0){
            return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Object(){});
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioModel>> getAllUsuarios(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUsuario(@PathVariable(value = "id") UUID id){
        Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(id);
        if (!usuarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "id") UUID id){
        Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(id);
        if (!usuarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not found.");
        }
        usuarioService.delete(usuarioModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid UsuarioDto usuarioDto){
        Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(id);
        if (!usuarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not found.");
        }
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDto, usuarioModel);
        usuarioModel.setId(usuarioModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuarioModel));
    }



}
