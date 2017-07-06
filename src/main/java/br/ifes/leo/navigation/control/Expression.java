package br.ifes.leo.navigation.control;

import br.ifes.leo.navigation.model.AbstractDirectionalAppraiser;

public interface Expression {
    City interpreter(String route);
    void nextExpression(AbstractDirectionalAppraiser next);
}