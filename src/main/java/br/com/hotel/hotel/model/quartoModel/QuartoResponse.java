package br.com.hotel.hotel.model.quartoModel;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QuartoResponse {

    private int numero;
    private String situacao;
    private int numeroDeCamas;
}
