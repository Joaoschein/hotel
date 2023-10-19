package br.com.hotel.hotel.service;

import br.com.hotel.hotel.model.clienteModel.ClienteRequest;
import br.com.hotel.hotel.model.clienteModel.ClienteResponse;
import br.com.hotel.hotel.persistence.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    ClienteResponse newCliente(ClienteRequest request);
    ClienteResponse findClienteByCPF(String CPF);
    List<ClienteResponse> findAllClientes();
    Void deleteCliente(String id);
    Void checkin(String cpf);
    Void checkout(String cpf);

}
