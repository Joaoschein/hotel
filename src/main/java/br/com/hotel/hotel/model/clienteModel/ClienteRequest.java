package br.com.hotel.hotel.model.clienteModel;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ClienteRequest {

    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cidade;
    private String situacao;
    private int quartoReservado;
    private LocalDate checkin;
    private LocalDate checkout;
    private long pagamento;
}
