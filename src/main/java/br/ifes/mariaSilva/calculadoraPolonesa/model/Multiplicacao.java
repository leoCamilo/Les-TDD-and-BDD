package br.ifes.mariaSilva.calculadoraPolonesa.model;

import br.ifes.mariaSilva.calculadoraPolonesa.control.Expressao;
import java.util.Stack;

/**
 * Created by malu.
 */

public class Multiplicacao implements Expressao {
    private Stack<Double> stack;

    public Multiplicacao(Stack<Double> stack) {
        this.stack = stack;
    }
    
    public Double interpret() {
        Double result = null;
        if( stack.size() > 1) {
            Double n1 = stack.pop();
            Double n2 = stack.pop();
            result = n1*n2;
        }
        return result;
    }

}
