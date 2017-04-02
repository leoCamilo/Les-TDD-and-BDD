package br.ifes.mariaSilva.navegacao.model;

import br.ifes.mariaSilva.navegacao.control.Cidade;
import java.util.Stack;

/**
 * Created by malu.
 */

public class MaisLeste extends AbstractAvaliadorDirecional{
    
    public MaisLeste() {
        this.direcao = "Leste";
    }
    
    @Override
    protected String[] matchingWords() {
        return new String[]{"Leste"};
    }
    
    @Override
    public Cidade executar(Stack<Cidade> expressoes) {
        Cidade cidadeResultante = getCidadeAtual();
        while(!expressoes.empty()){
            Cidade token = expressoes.pop();
            if(cidadeResultante.getLongitude() < token.getLongitude()){
                setCidadeAtual(token);
            }
        }
        return cidadeResultante;
    }
}
