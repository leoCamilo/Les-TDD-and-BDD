package br.ifes.mariaSilva.navegacao.model;

import br.ifes.mariaSilva.navegacao.control.Cidade;
import br.ifes.mariaSilva.navegacao.control.Expressao;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by malu.
 */

public abstract class AbstractAvaliadorDirecional implements Expressao {
    private final Map<String, Cidade> cidades;
    protected AbstractAvaliadorDirecional proximo;
    protected String direcao;
    protected Cidade cidadeAtual = new Cidade("aqui", 0, 0);
    protected abstract Cidade executar(Stack<Cidade> expressoes);
    protected abstract String[] matchingWords();

    public void setCidadeAtual(Cidade args){
        this.cidadeAtual = args;
    }

    public Cidade getCidadeAtual() {
        return this.cidadeAtual;
    }
   
    public AbstractAvaliadorDirecional(){
        cidades = new HashMap<String, Cidade>();

        cidades.put("Dublin", new Cidade("Dublin", 53.35, -6.27));
        cidades.put("Galway", new Cidade("Galway", 53.07, -8.82));
        cidades.put("Waterford", new Cidade("Waterford", 52.26, -7.11));
        cidades.put("Cork", new Cidade("Cork", 51.90, -8.47));
        cidades.put("Paris", new Cidade("Paris", 48.86, 2.35));
        cidades.put("Amsterdam", new Cidade("Amsterdam", 52.38, 4.90));
        cidades.put("Barcelona", new Cidade("Barcelona", 41.39, 2.15));
        cidades.put("Porto", new Cidade("Porto", 41.15, -8.63));
        cidades.put("Salvador", new Cidade("Salvador", -12.97, -38.50));
        cidades.put("Curitiba", new Cidade("Curitiba", -25.42, -49.26));
        cidades.put("Florianopolis", new Cidade("Florianopolis", -27.59, -48.55));
        cidades.put("Vitoria", new Cidade("Vitoria", -20.30, -40.30));
        
    }
    
    public static Cidade processar(String entrada){
        
        AbstractAvaliadorDirecional leste = new MaisLeste();
        AbstractAvaliadorDirecional norte = new MaisNorte();
        AbstractAvaliadorDirecional oeste = new MaisOeste();
        AbstractAvaliadorDirecional sul = new MaisSul();
        leste.proximaExpressao(norte);
        norte.proximaExpressao(oeste);
        oeste.proximaExpressao(sul);
        
        return leste.interpreter(entrada);
    }
    
    public void proximaExpressao(AbstractAvaliadorDirecional prox) {
        this.proximo = prox;
    }
    
    public Cidade interpreter(String rota){
        Stack<Cidade> expressoes = new Stack<Cidade>();
        boolean palavraEncontrada = false;
        
        if(matchingWords().length == 0){
            palavraEncontrada = true;
        }
       
        for(String token: rota.split(" ")){
            
            if(cidades.containsKey(token)){
                expressoes.push(cidades.get(token));
            }
            if(direcao.equals(token) || palavraEncontrada == true ){
                palavraEncontrada = true;
                this.cidadeAtual = executar(expressoes);
            } 
            else {
                this.cidadeAtual = this.proximo.interpreter(rota);
            }
        }
        return this.cidadeAtual;
    }
}
