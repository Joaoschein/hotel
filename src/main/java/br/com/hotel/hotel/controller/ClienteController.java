package br.com.hotel.hotel.controller;

import br.com.hotel.hotel.model.clienteModel.ClienteRequest;
import br.com.hotel.hotel.model.clienteModel.ClienteResponse;
import br.com.hotel.hotel.persistence.entity.Cliente;
import br.com.hotel.hotel.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ServiceImpl service;

    @PostMapping("/new")
    public ResponseEntity<ClienteResponse> newCliente(@RequestBody ClienteRequest request) {
        return ResponseEntity.ok(service.newCliente(request));
    }

    @GetMapping("/cpf/{cpf}")
    public Cliente findClienteByCPF(@PathVariable String cpf) {
        return service.findClienteByCPF(cpf);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClienteResponse>> getAll() {
        return ResponseEntity.ok(service.findAllClientes());
    }
}
