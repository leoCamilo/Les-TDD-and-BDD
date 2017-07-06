package br.ifes.leo.polishCalc.view;

import br.ifes.leo.polishCalc.model.Calc;

public class MainApp {
	public static void main(String[] args) {
        Calc calc = new Calc();
        String input = "5 1 2 + 4 * + 3 -";

        System.out.println("input:" + input);
        System.out.println("output: " + calc.evaluate(input));
    }
}