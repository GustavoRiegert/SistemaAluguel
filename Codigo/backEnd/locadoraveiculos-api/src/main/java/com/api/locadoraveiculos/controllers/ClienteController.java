package com.api.locadoraveiculos.controllers;

import com.api.locadoraveiculos.dtos.ClienteDto;
import com.api.locadoraveiculos.models.ClienteModel;
import com.api.locadoraveiculos.models.EmpregoModel;
import com.api.locadoraveiculos.services.ClienteService;
import com.api.locadoraveiculos.services.EmpregoService;
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
@RequestMapping("/cliente")
public class ClienteController {

    final ClienteService clienteService;
    final EmpregoService empregoService;

    public ClienteController(ClienteService clienteService,
                             EmpregoService empregoService) {
        this.clienteService = clienteService;
        this.empregoService = empregoService;
    }



    @PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteDto clienteDto){
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }

    @GetMapping
    public ResponseEntity<Page<ClienteModel>> getAllClientes(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCliente(@PathVariable(value = "id") UUID id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if (!clienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") UUID id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if (!clienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente not found.");
        }
        clienteService.delete(clienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid ClienteDto clienteDto){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if (!clienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente not found.");
        }
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        clienteModel.setId(clienteModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));
    }



}
