package br.ifes.leo.incomeTax.model;

import br.ifes.leo.incomeTax.control.ICalcTax;
import br.ifes.leo.incomeTax.control.People;

public class CalcTaxStrategy implements ICalcTax {
	private double minimum;
	private double maximum;
	private double aliquot;
    private double tax;
    
	public CalcTaxStrategy(double minimum, double maximum, double aliquot){
        this.minimum = minimum;
        this.maximum = maximum;
        this.aliquot = aliquot;
    }

    public double getMinimum() { return minimum; }
	public double getMaximum() { return maximum; }
	public double getTax() { return tax; }
	
	public double calcIncomeTax(People people){
        if (people.getSalary() >= this.minimum && people.getSalary() <= this.maximum){
             this.tax = (people.getSalary() * this.aliquot);
             return this.tax;
        }
        else{
            throw new UnsupportedOperationException("invalid salary to this aliquot \n" + this.toString());
        }
    }
}