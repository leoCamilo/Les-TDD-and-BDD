package br.ifes.mariaSilva.calculadoraPolonesa.model;

import br.ifes.mariaSilva.calculadoraPolonesa.control.ElevaExpressao;
import br.ifes.mariaSilva.calculadoraPolonesa.control.Expressao;
import java.util.Stack;

/**
 * Created by malu.
 */

public class Calculadora {
	
	public double evaluate(String equacao) {
        Stack<Double> stack = new Stack<Double>();
        for(String token: equacao.split(" ")) {            
            
            if(token.equals("+")) {
                Expressao exp = new Adicao( stack );
                Double result = exp.interpret();
                if (result != null) { 
                    stack.push( result );                
                }
            }
            else if(token.equals("-")) {
                Expressao exp =  new Subtracao( stack );
                Double result = exp.interpret();
                if (result != null) { 
                    stack.push( result );                
                }
            }
            else if(token.equals("/")) {
                Expressao exp = new Divisao( stack );
                Double result = exp.interpret();
                if (result != null) { 
                    stack.push( result );                
                }
            }
            else if(token.equals("*")) {
                Expressao exp = new Multiplicacao( stack );
                Double result = exp.interpret();
                 if (result != null) { 
                    stack.push( result );                
                }
           }
            else if(token.equals("^")) {
                Expressao exp = new ElevaExpressao( stack );
                Double result = exp.interpret();
                 if (result != null) { 
                    stack.push( result );                
                }
           }
            else {
                try {
                    Double numero = new Double(token);
                    stack.push(numero);
                }
                catch(Exception e) {
                    System.out.println("Ops.. operador invalido:: " + token);
                }
            }
        }
        return stack.pop();
    }

}
