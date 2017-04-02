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
        Cidade cidadeResultante = getCidadeAtual();
        while(!expressoes.empty()){
            Cidade token = expressoes.pop();
            if(cidadeResultante.getLatitude() > token.getLatitude()){
                setCidadeAtual(token);
            }
        }
        return cidadeResultante;
    }

	

}
