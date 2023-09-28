package br.com.hotel.hotel.service;

public interface QuartoService {

    QuartoResponse create(QuartoRequest request);

    List<QuartoResponse> getAll();
}
