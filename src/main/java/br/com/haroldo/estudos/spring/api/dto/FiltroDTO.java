package br.com.haroldo.estudos.spring.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiltroDTO {

    private String campanhas;
    private String produtos;
    private Integer serie;
    private Integer numero;
    private String data_corte_carta;
    private String data_corte_recusa;
    private Integer quantidade;

}
