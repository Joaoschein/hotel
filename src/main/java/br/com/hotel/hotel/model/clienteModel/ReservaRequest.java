package br.com.hotel.hotel.model.clienteModel;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReservaRequest {

    private String cpf;
    private int quarto;
    private LocalDate chekin;
    private LocalDate chekout;


}
