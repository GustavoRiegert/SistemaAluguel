package com.api.locadoraveiculos.controllers;

import com.api.locadoraveiculos.dtos.AluguelDto;
import com.api.locadoraveiculos.models.AluguelModel;
import com.api.locadoraveiculos.services.AluguelService;
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
@RequestMapping("/aluguel")
public class AluguelController {

    final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAluguel(@RequestBody @Valid AluguelDto aluguelDto){
        var aluguelModel = new AluguelModel();
        BeanUtils.copyProperties(aluguelDto, aluguelModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluguelService.save(aluguelModel));
    }

    @GetMapping
    public ResponseEntity<Page<AluguelModel>> getAllAluguels(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(aluguelService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneAluguel(@PathVariable(value = "id") UUID id){
        Optional<AluguelModel> aluguelModelOptional = aluguelService.findById(id);
        if (!aluguelModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluguel not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(aluguelModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAluguel(@PathVariable(value = "id") UUID id){
        Optional<AluguelModel> aluguelModelOptional = aluguelService.findById(id);
        if (!aluguelModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluguel not found.");
        }
        aluguelService.delete(aluguelModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Aluguel deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAluguel(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid AluguelDto aluguelDto){
        Optional<AluguelModel> aluguelModelOptional = aluguelService.findById(id);
        if (!aluguelModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluguel not found.");
        }
        var aluguelModel = new AluguelModel();
        BeanUtils.copyProperties(aluguelDto, aluguelModel);
        aluguelModel.setId(aluguelModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(aluguelService.save(aluguelModel));
    }



}
