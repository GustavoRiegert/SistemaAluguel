package com.api.locadoraveiculos.controllers;

import com.api.locadoraveiculos.dtos.EmpregoDto;
import com.api.locadoraveiculos.dtos.EmpregoDto;
import com.api.locadoraveiculos.models.EmpregoModel;
import com.api.locadoraveiculos.services.EmpregoService;
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
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/emprego")
public class EmpregoController {

    final EmpregoService empregoService;

    public EmpregoController(EmpregoService empregoService) {
        this.empregoService = empregoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveEmprego(@RequestBody @Valid EmpregoDto empregoDto){
        var empregoModel = new EmpregoModel();
        BeanUtils.copyProperties(empregoDto, empregoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(empregoService.save(empregoModel));
    }

    @GetMapping
    public ResponseEntity<Page<EmpregoModel>> getAllEmpregos(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(empregoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneEmprego(@PathVariable(value = "id") UUID id){
        Optional<EmpregoModel> empregoModelOptional = empregoService.findById(id);
        if (!empregoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emprego not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(empregoModelOptional.get());
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<EmpregoModel>> getClienteEmprego(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(empregoService.findAllByClienteId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmprego(@PathVariable(value = "id") UUID id){
        Optional<EmpregoModel> empregoModelOptional = empregoService.findById(id);
        if (!empregoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emprego not found.");
        }
        empregoService.delete(empregoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Emprego deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmprego(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid EmpregoDto empregoDto){
        Optional<EmpregoModel> empregoModelOptional = empregoService.findById(id);
        if (!empregoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emprego not found.");
        }
        var empregoModel = new EmpregoModel();
        BeanUtils.copyProperties(empregoDto, empregoModel);
        empregoModel.setId(empregoModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(empregoService.save(empregoModel));
    }



}
