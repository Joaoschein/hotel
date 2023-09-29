package br.com.hotel.hotel.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuartoRequest {

    private int numero;
    private String situacao;
    private int numeroDeCamas;
}
