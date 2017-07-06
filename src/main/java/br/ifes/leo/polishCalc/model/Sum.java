package br.ifes.leo.polishCalc.model;

import java.util.Stack;

public class Sum implements Expression {
    private Stack<Double> stack;

    public Sum(Stack<Double> stack) {
        this.stack = stack;
    }
    
    public Double interpret() {
        return stack.size() > 1 ? stack.pop() + stack.pop() : null;
    }
}