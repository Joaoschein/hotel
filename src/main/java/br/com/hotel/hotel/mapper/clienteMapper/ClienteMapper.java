package br.com.hotel.hotel.mapper.clienteMapper;

import br.com.hotel.hotel.model.clienteModel.ClienteResponse;
import br.com.hotel.hotel.persistence.entity.Cliente;

public class ClienteMapper {

    public static ClienteResponse clienteModelToResponseMapper (Cliente cliente) {

        return ClienteResponse.builder()
                .cpf(cliente.getCpf())
                .email(cliente.getEmail())
                .nome(cliente.getNome())
                .id(cliente.getId())
                .build();
    }
}
