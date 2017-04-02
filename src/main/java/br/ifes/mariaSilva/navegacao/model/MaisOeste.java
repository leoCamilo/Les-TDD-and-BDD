package br.ifes.mariaSilva.navegacao.model;

import br.ifes.mariaSilva.navegacao.control.Cidade;
import java.util.Stack;

/**
 * Created by malu.
 */

public class MaisOeste extends AbstractAvaliadorDirecional{
    
    public MaisOeste() {
        this.direcao = "Oeste";
    }
    
    @Override
    protected String[] matchingWords() {
        return new String[]{"Oeste"};
    }
    
    @Override
    public Cidade executar(Stack<Cidade> expressoes) {
        Cidade cidadeResultante = getCidadeAtual();
        while(!expressoes.empty()){
            Cidade token = expressoes.pop();
            if(cidadeResultante.getLongitude() > token.getLongitude()){
                setCidadeAtual(token);
            }
        }
        return cidadeResultante;
    }

}
