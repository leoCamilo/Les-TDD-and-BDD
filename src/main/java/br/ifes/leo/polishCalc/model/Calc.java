package br.ifes.leo.polishCalc.model;

import java.util.Stack;

public class Calc {
	public double evaluate(String equation) {
        Stack<Double> stack = new Stack<Double>();

        Expression[] operator = {
            new Sum(stack),
            new Subtraction(stack),
            new Division(stack),
            new Multiplication(stack),
            new PowExpression(stack)
        };

        for(String token: equation.split(" ")) {
            int i = -1;

            if(token.equals("+")) i = 0;
            else if(token.equals("-")) i = 1;
            else if(token.equals("/")) i = 2;
            else if(token.equals("*")) i = 3;
            else if(token.equals("^")) i = 4;

            if (i == -1) {
                try {
                    stack.push(new Double(token));
                } catch(Exception e) {
                    System.out.println("Invalid operator: " + token);
                }
            }else{
                Double result = operator[i].interpret();

                if (result != null)
                    stack.push(result);
            }
        }

        return stack.pop();
    }
}