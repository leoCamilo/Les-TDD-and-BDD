package br.ifes.mariaSilva.navegacao.control;

import br.ifes.mariaSilva.navegacao.model.AbstractAvaliadorDirecional;

/**
 * Created by malu.
 */

public interface Expressao {
    Cidade interpreter(String rota);
    void proximaExpressao(AbstractAvaliadorDirecional proximo);
}
