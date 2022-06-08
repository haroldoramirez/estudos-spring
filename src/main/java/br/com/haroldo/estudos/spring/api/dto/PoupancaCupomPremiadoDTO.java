package br.com.haroldo.estudos.spring.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoupancaCupomPremiadoDTO {

    private String produto;
    private String serie;
    private String cupom;
    private String central;
    private String cpfCnpj;
    private String cliente;
    private Long cooperativa;
    private Long pa;
    private Boolean status;
    private String situacao;
    private String descSituacao;
    private String dataVinculo;
    private String dataCarga;
    private String dataDistribuicao;
    private String observacao;
    private String dataInativacao;
    private Integer quantidadeRegistros;
    private String poupancaPremiada;
    private String poupancaCliente;
    private String campanha;
    private Boolean promocaoPremiada;

}
