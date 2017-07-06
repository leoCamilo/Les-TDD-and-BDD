package br.ifes.leo.incomeTax.view;

import br.ifes.leo.incomeTax.control.People;
import br.ifes.leo.incomeTax.model.CalcTax;

public class MainApp {
    private static final int size = 6;

    public static void main(String [] args){
        CalcTax[] calcTax = new CalcTax[size];
        People[] people = new People[size];

        double[] salaries = {1050.00, 1960.00, 2950.00, 4200.00, 11000.00, -600.00};

        for (int i = 0; i < size; i++){
            people[i] = new People(salaries[i]);
            calcTax[i] = new CalcTax(people[i]);

            double tax = calcTax[i].getTax();
            System.out.println(tax == -1 ? "invalid salary" : "salary: " + people[i].getSalary() + " tax: " + calcTax[i].getTax());
        }
    }
}