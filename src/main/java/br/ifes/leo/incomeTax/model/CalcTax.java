package br.ifes.leo.incomeTax.model;

import br.ifes.leo.incomeTax.control.People;
import java.util.ArrayList;
import java.util.List;

public class CalcTax {
    private List<CalcTaxStrategy> strategies;
    private double tax;

    public double getTax() { return tax; }

    public CalcTax(People people){
        this.tax = -1;

        Aliquot1 aliquot1 = new Aliquot1();
        Aliquot2 aliquot2 = new Aliquot2();
        Aliquot3 aliquot3 = new Aliquot3();
        Aliquot4 aliquot4 = new Aliquot4();
        Aliquot5 aliquot5 = new Aliquot5();

        this.strategies = new ArrayList<CalcTaxStrategy>();

        this.strategies.add(aliquot1);
        this.strategies.add(aliquot2);
        this.strategies.add(aliquot3);
        this.strategies.add(aliquot4);
        this.strategies.add(aliquot5);

        this.calculate(people);
    }

    private void calculate(People people) {
        for (CalcTaxStrategy strategy: this.strategies)
            if (people.getSalary() >= strategy.getMinimum()&& people.getSalary() <= strategy.getMaximum())
                this.tax = strategy.calcIncomeTax(people);
    }
}