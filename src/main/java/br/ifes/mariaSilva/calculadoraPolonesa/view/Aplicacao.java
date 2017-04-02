package br.ifes.mariaSilva.calculadoraPolonesa.view;

import br.ifes.mariaSilva.calculadoraPolonesa.model.Calculadora;

/**
 * Created by malu.
 */

public class Aplicacao {
	
	public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        String entrada = "5 1 2 + 4 * + 3 -";
        Double valor = calculadora.evaluate(entrada);
        System.out.println("Entrada:" + entrada);
        System.out.println("Saida: " + valor);
    }

}
