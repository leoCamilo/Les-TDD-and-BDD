package br.ifes.mariaSilva.navegacao.view;

import br.ifes.mariaSilva.navegacao.control.Cidade;
import br.ifes.mariaSilva.navegacao.model.AbstractAvaliadorDirecional;

/**
 * Created by malu.
 */

public class Aplicacao {
    public static void main(String[] args) {
        
        Cidade saida = AbstractAvaliadorDirecional.processar("Sul Paris Amsterdam Barcelona Porto");
        saida.resposta();
    }
}
