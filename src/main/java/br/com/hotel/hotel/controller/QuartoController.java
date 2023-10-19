package br.com.hotel.hotel.controller;

import br.com.hotel.hotel.model.clienteModel.ClienteRequest;
import br.com.hotel.hotel.model.clienteModel.ClienteResponse;
import br.com.hotel.hotel.model.quartoModel.QuartoRequest;
import br.com.hotel.hotel.model.quartoModel.QuartoResponse;
import br.com.hotel.hotel.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/quarto")
public class QuartoController {

    @Autowired
    ServiceImpl service;

    @PostMapping("/new")
    public ResponseEntity<QuartoResponse> newCliente(@RequestBody QuartoRequest request) {
        return ResponseEntity.ok(service.newQuarto(request));
    }
    @GetMapping("/all")
    public ResponseEntity<List<QuartoResponse>> getAll() {
        return ResponseEntity.ok(service.findAllQuartos());
    }

    @GetMapping("/numero/{numero}")
    public ResponseEntity<QuartoResponse> findByNumero(@PathVariable int numero) {
        return ResponseEntity.ok(service.findQuartoByNumero(numero));
    }

    @DeleteMapping("delete/{id}")
    public Void deleteQuarto(@PathVariable String id) {
        service.deleteQuarto(id);
        return null;
    }
}
