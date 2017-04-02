package br.ifes.mariaSilva.impostoRenda.control;

/**
 * Created by malu.
 */

public class Pessoa {
    private double salario;
    
    public Pessoa(double receita){
        this.salario = receita;
    }

    public double getReceita() {
        return salario;
    }

    public void setReceita(double receita) {
        this.salario = receita;
    }
}
