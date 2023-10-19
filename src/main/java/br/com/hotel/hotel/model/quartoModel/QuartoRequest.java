package br.com.hotel.hotel.model.quartoModel;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QuartoRequest {

    private String id;
    private int numero;
    private String situacao;
    private long valor;
    private String descricao;
    private String tipo;
}
