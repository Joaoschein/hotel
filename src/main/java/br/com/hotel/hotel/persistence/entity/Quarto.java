package br.com.hotel.hotel.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Quarto {

    @Id
    private String id;
    private int numero;
    private String situacao;
    private int numeroDeCamas;

}
