package br.ifes.mariaSilva.calculadoraPolonesa.model;

import br.ifes.mariaSilva.calculadoraPolonesa.control.Expressao;
import java.util.Stack;

/**
 * Created by malu.
 */

public class Subtracao implements Expressao {
    private Stack<Double> stack;
    public Subtracao(Stack<Double> stack) {
        this.stack = stack;
    }

    
    public Double interpret() {
        Double result = null;
        if( stack.size() > 1) {
            Double n1 = stack.pop();
            Double n2 = stack.pop();
            result = n2 - n1;
        }
        return result;
    }

}
