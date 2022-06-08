package br.com.haroldo.estudos.spring.api.resource;

import br.com.haroldo.estudos.spring.api.dto.GanhadorDTO;
import br.com.haroldo.estudos.spring.service.GanhadorService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api/ganhadores")
@RequiredArgsConstructor
public class GanhadorResource {

    private final GanhadorService service;

    @GetMapping("/hello/{nome}")
    public ResponseEntity hello(@PathVariable("nome") String nome) {

        return ResponseEntity.ok(nome);

    }

    @GetMapping("/excel")
    public ResponseEntity gerarRelatorioExcel() {

        Calendar agora = Calendar.getInstance();
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        String dataAtual = dataFormatada.format(agora.getTime());

        List<GanhadorDTO> listaGanhadores =  new ArrayList<>();

        try {

            //Lista do back-end
            listaGanhadores = service.listarGanhadores();

            //Objetos da planilha
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheetsGanhadores = workbook.createSheet("Ganhadores");

            int rownum = 0;
            Row row = sheetsGanhadores.createRow(rownum++);

            //Adiciona o header da planilha
            row.createCell(0).setCellValue("serie");
            row.createCell(1).setCellValue("cupom");
            row.createCell(2).setCellValue("cpfCnpj");
            row.createCell(3).setCellValue("ganhador");
            row.createCell(4).setCellValue("produto");
            row.createCell(5).setCellValue("cooperativa");
            row.createCell(6).setCellValue("pa");
            row.createCell(7).setCellValue("dataDistribuicao");
            row.createCell(8).setCellValue("situacao");

            //Percorro a lista para formatar valores de forma condicional antes de adicionar na celula
            for (GanhadorDTO ganhador : listaGanhadores) {

                row = sheetsGanhadores.createRow(rownum++);
                int cellnum = 0;

                Cell cellSerie = row.createCell(cellnum++);
                cellSerie.setCellValue(ganhador.getSerie());

                Cell cellCupom = row.createCell(cellnum++);
                cellCupom.setCellValue(ganhador.getCupom());

                Cell cellCpfCnpj = row.createCell(cellnum++);
                cellCpfCnpj.setCellValue(ganhador.getCpfCnpj());

                Cell cellGanhador = row.createCell(cellnum++);
                cellGanhador.setCellValue(ganhador.getGanhador());

                Cell cellProduto = row.createCell(cellnum++);
                cellProduto.setCellValue(ganhador.getProduto());

                Cell cellCooperativa = row.createCell(cellnum++);
                cellCooperativa.setCellValue(ganhador.getCooperativa());

                Cell cellPa = row.createCell(cellnum++);
                cellPa.setCellValue(ganhador.getPa());

                Cell cellDataDistribuicao = row.createCell(cellnum++);
                cellDataDistribuicao.setCellValue(dataFormatada.format(ganhador.getDataDistribuicao()));

                Cell cellSituacao = row.createCell(cellnum++);

                if (ganhador.isSituacao()) {

                    cellSituacao.setCellValue("Ativo");

                } else {

                    cellSituacao.setCellValue("Inativo");

                }

            }

            FileOutputStream out = new FileOutputStream(new File("/ganhadores-" + dataAtual + ".xls"));

            workbook.write(out);
            out.close();

            return ResponseEntity.ok(new File("/ganhadores-" + dataAtual + ".xls"));

        } catch (IOException e) {

            System.out.println("Ocorreu um erro");

        } finally {

            System.out.println("Processo final");

        }

        return null;
    }

}
