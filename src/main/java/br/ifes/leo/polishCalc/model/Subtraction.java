package br.ifes.leo.polishCalc.model;

import java.util.Stack;

public class Subtraction implements Expression {
    private Stack<Double> stack;

    public Subtraction(Stack<Double> stack) {
        this.stack = stack;
    }

    public Double interpret() {
        return stack.size() > 1 ? stack.pop() - stack.pop() : null;
    }
}
