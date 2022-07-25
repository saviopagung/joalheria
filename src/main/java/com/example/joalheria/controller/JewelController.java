package com.example.joalheria.controller;

import com.example.joalheria.model.Jewel;
import com.example.joalheria.service.IServiceJewel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/jewel")
public class JewelController {

    @Autowired
    private IServiceJewel service;

    @PostMapping
    public ResponseEntity<Jewel> inserir(@RequestBody Jewel jewel){
        return new ResponseEntity<>(
                service.insert(jewel),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Jewel>> listar(){
        return new ResponseEntity<>(
                service.listar(),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<Jewel> atualizar(@RequestBody Jewel jewel){
        return ResponseEntity.ok(service.atualizar(jewel));
    }

}
