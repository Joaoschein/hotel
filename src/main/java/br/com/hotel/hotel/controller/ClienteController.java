package br.com.hotel.hotel.controller;

import br.com.hotel.hotel.model.clienteModel.ClienteRequest;
import br.com.hotel.hotel.model.clienteModel.ClienteResponse;
import br.com.hotel.hotel.model.clienteModel.ReservaRequest;
import br.com.hotel.hotel.persistence.entity.Cliente;
import br.com.hotel.hotel.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ServiceImpl service;

    @PostMapping("/new")
    public ResponseEntity<ClienteResponse> newCliente(@RequestBody ClienteRequest request) {
        return ResponseEntity.ok(service.newCliente(request));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ClienteResponse> findClienteByCPF(@PathVariable String cpf) {

        return ResponseEntity.ok(service.findClienteByCPF(cpf));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClienteResponse>> getAll() {
        return ResponseEntity.ok(service.findAllClientes());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        service.deleteCliente(id);
        return;
    }

    @PutMapping("/checkin/{cpf}")
    public void checkin(@PathVariable String cpf) {
        service.checkin(cpf);
    }

    @PutMapping("/checkout/{cpf}")
    public void checkout(@PathVariable String cpf) {
        service.checkout(cpf);
    }
    @PutMapping("/reservar")
    public void reservarQuarto(@RequestBody ReservaRequest request) {
        service.reservar(request);
    }

    @PutMapping("/pagar/{cpf}")
    public void pagarHotel(@PathVariable String cpf) {
        service.pagarHotel(cpf);
    }
}
