package br.ifes.leo.polishCalc.model;

import java.util.Stack;

public class PowExpression implements Expression {
    private Stack<Double> stack;

    public PowExpression(Stack<Double> stack) {
        this.stack = stack;
    }

    public Double interpret() {
        return stack.size() > 1 ? Math.pow(Math.round(stack.pop()), Math.round(stack.pop())) : null;
    }
}