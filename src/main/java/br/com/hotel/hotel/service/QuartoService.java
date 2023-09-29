package br.com.hotel.hotel.service;

public interface QuartoService {

    QuartoResponse create(QuartoRequest request);
    List<QuartoResponse> getAll();
    ClienteResponse newCliente(ClienteRequest request);
    ClienteResponse findClienteById(ClienteRequest request);


}
