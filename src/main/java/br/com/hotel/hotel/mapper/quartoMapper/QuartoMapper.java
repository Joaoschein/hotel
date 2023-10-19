package br.com.hotel.hotel.mapper.quartoMapper;

import br.com.hotel.hotel.model.quartoModel.QuartoResponse;
import br.com.hotel.hotel.persistence.entity.Quarto;

public class QuartoMapper {

    public static QuartoResponse quartoModelToResponseMapper (Quarto quarto) {
        return QuartoResponse.builder()
                .id(quarto.getId())
                .situacao(quarto.getSituacao())
                .numero(quarto.getNumero())
                .tipo(quarto.getTipo())
                .descricao(quarto.getDescricao())
                .valor(quarto.getValor())
                .build();
    }
}
