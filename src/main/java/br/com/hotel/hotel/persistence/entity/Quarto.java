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
@Document(collection = "quanrtos")
public class Quarto {

    @Id
    private String id;
    private int numero;
    private String situacao;
    private long valor;
    private String descricao;
    private String tipo;

}
