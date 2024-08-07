package com.felps.springboot.controllers;

import com.felps.springboot.dtos.SwimmingRecordDto;
import com.felps.springboot.models.SwimmingModel;
import com.felps.springboot.repositories.SwimmingRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/swimming")
public class SwimmingController {

    @Autowired
    SwimmingRepository swimmingRepository;

    @PostMapping
    public ResponseEntity<SwimmingModel> saveSwimming(@RequestBody @Valid SwimmingRecordDto swimmingRecordDto) {
        var swimmingModel = new SwimmingModel();
        BeanUtils.copyProperties(swimmingRecordDto, swimmingModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(swimmingRepository.save(swimmingModel));
    }

    @GetMapping
    public ResponseEntity<List<SwimmingModel>> getAllSwimming() {
        return ResponseEntity.status(HttpStatus.CREATED).body(swimmingRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSwimmingById(@PathVariable(value = "id") UUID id) {
        Optional<SwimmingModel> swimming = swimmingRepository.findById(id);
        if (swimming.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Swimming not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(swimming.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSwimming(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid SwimmingRecordDto swimmingRecordDto) {
        Optional<SwimmingModel> swimming = swimmingRepository.findById(id);

        if(swimming.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Swimming not found.");
        }
        var swimmingModel = swimming.get();
        BeanUtils.copyProperties(swimmingRecordDto, swimmingModel);
        return ResponseEntity.status(HttpStatus.OK).body(swimmingRepository.save(swimmingModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSwimming(@PathVariable(value = "id") UUID id) {
        Optional<SwimmingModel> swimming = swimmingRepository.findById(id);
        if (swimming.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Swimming not found.");
        }
        swimmingRepository.delete(swimming.get());
        return ResponseEntity.status(HttpStatus.OK).body("Swimming deleted.");
    }
}
