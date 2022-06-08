package br.com.haroldo.estudos.spring.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GanhadorDTO {

    private String serie;
    private String cupom;
    private String cpfCnpj;
    private String ganhador;
    private String produto;
    private String cooperativa;
    private String pa;
    private Date dataDistribuicao;
    private boolean situacao;
}
