package br.com.hotel.hotel.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document (collection = "clientes")
public class Cliente {

    @Id
    private String id;
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





