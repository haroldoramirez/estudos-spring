package br.com.haroldo.estudos.spring.service.Impl;

import br.com.haroldo.estudos.spring.api.dto.GanhadorDTO;
import br.com.haroldo.estudos.spring.service.GanhadorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GanhadorServiceImpl implements GanhadorService {

    /**
     * Funcao responsavel por listar todos ganhadores
     *
     */
    @Override
    public List<GanhadorDTO> listarGanhadores() {

        System.out.println("Lista produtos com a campanha");

        List<GanhadorDTO> ganhadores = new ArrayList<>();

        boolean alternar = false;

        for (int i = 0; i <= 400; i++) {

            GanhadorDTO g = new GanhadorDTO();
            g.setSerie(i + "111");
            g.setCupom("222" + i);
            g.setCpfCnpj("056.709.569-07");
            g.setGanhador("Fulano " + i);
            g.setProduto(i + " Produto");
            g.setCooperativa("Cooperativa " + i + i);
            g.setPa("PA");
            g.setDataDistribuicao(new Date());

            if (!alternar) {

                g.setSituacao(true);

                alternar = true;

            } else {

                g.setSituacao(false);

                alternar = false;

            }


            ganhadores.add(g);
        }

        //TODO Implementar a query que faz a consulta baseado no objeto filtro

        return ganhadores;

    }
}
