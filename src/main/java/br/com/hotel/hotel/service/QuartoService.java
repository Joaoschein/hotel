package br.com.hotel.hotel.service;

import br.com.hotel.hotel.model.quartoModel.QuartoRequest;
import br.com.hotel.hotel.model.quartoModel.QuartoResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuartoService {

    QuartoResponse newQuarto(QuartoRequest request);
    List<QuartoResponse> findAllQuartos();
    QuartoResponse findQuartoByNumero(int numero);
    Void deleteQuarto(String id);
}
