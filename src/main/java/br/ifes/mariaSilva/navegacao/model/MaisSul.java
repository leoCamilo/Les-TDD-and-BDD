package br.ifes.mariaSilva.navegacao.model;

import br.ifes.mariaSilva.navegacao.control.Cidade;
import java.util.Stack;

/**
 * Created by malu.
 */

public class MaisSul extends AbstractAvaliadorDirecional{
    
    public MaisSul() {
        this.direcao = "Sul";
    }
    
    @Override
    protected String[] matchingWords() {
        return new String[]{"Sul"};
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
            if(cidadeSelecionada.getLatitude() > cidadeComparacao.getLatitude()){
                cidadeSelecionada = cidadeComparacao;
            }

        }
        return cidadeSelecionada;
    }

	

}
