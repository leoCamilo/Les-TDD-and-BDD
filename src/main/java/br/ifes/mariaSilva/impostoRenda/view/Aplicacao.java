package br.ifes.mariaSilva.impostoRenda.view;

import br.ifes.mariaSilva.impostoRenda.control.Pessoa;
import br.ifes.mariaSilva.impostoRenda.model.CalculoImposto;

/**
 * Created by malu.
 */

public class Aplicacao {

	public static void main(String [] args){
        CalculoImposto calculoImposto;
        Pessoa pessoa = new Pessoa(4000.00);
        calculoImposto = new CalculoImposto(pessoa);
        
        pessoa = new Pessoa(-200);
        calculoImposto = new CalculoImposto(pessoa);
    }
}
