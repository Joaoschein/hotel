package br.com.hotel.hotel.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


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
}





