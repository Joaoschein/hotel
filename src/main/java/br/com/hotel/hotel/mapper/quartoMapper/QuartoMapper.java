package br.com.hotel.hotel.mapper.quartoMapper;

import br.com.hotel.hotel.model.quartoModel.QuartoResponse;
import br.com.hotel.hotel.persistence.entity.Quarto;

public class QuartoMapper {

    public static QuartoResponse quartoModelToResponseMapper (Quarto quarto) {
        return QuartoResponse.builder()
                .situacao(quarto.getSituacao())
                .numeroDeCamas(quarto.getNumeroDeCamas())
                .numero(quarto.getNumero())
                .build();
    }
}
