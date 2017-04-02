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
        Cidade cidadeSelecionada = null;

        if(!expressoes.empty()){
            cidadeSelecionada = expressoes.pop();
        }
        else {
            cidadeSelecionada = getCidadeAtual();
        }

        while(!expressoes.empty()){
            Cidade cidadeComparacao = expressoes.pop();
            if(cidadeSelecionada.getLongitude() < cidadeComparacao.getLongitude()){
                cidadeSelecionada = cidadeComparacao;
            }
        }
        return cidadeSelecionada;
    }
}
