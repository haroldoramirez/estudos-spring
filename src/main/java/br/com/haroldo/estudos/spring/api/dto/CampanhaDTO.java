package br.com.haroldo.estudos.spring.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampanhaDTO {

    private Long idcampanhas;
    private Integer codigoCampanha;
    private String numeroIndentificador;
    private String numeroSerie;
    private String numeroCupom;
    private String descricaoRegiao;
    private Integer numeroPa;
    private String numeroCpfCnpj;
    private String nomeCliente;
    private Integer codigoSituacaoCupom;
    private String descricaoSituacaoCupom;
    private Date dataHoraVinculoCupom; //Timestamp analisar
    private Date dataHoraAlteracaoStatusCupom; //Timestamp analisar
    private Integer anoMesReferencia;
    private String descricaoAnoMesReferencia;
    private BigDecimal valorCredito;
    private BigDecimal valorDebito;
    private String nomeArquivo;
    private Date dataReferenciaMovimento;
    private Date dataHoraCriacaoRegistro; //Timestamp analisar
    private Integer qtdcredito;
    private Integer qtddebito;
    private Integer numcentral;
    private String descobservacao;

}
