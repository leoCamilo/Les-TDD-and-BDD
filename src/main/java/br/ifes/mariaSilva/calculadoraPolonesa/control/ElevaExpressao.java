package br.ifes.mariaSilva.calculadoraPolonesa.control;

import java.util.Stack;

/**
 * Created by malu.
 */

public class ElevaExpressao implements Expressao {
    private Stack<Double> stack;

    public ElevaExpressao(Stack<Double> stack) {
        this.stack = stack;
    }

    public Double interpret() {
        Double result = null;
        if( stack.size() > 1) {
            Double n1 = stack.pop();
            Double n2 = stack.pop();
            result = Math.pow(Math.round(n1), Math.round(n2));
        }
        return result;
    }

}
