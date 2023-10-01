package br.com.hotel.hotel.model.clienteModel;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ClienteResponse {

    private String id;
    private String nome;
    private String cpf;
    private String email;
}