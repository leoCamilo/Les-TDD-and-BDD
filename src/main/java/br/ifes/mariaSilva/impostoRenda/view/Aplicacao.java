package br.ifes.mariaSilva.impostoRenda.view;

import br.ifes.mariaSilva.impostoRenda.control.Pessoa;
import br.ifes.mariaSilva.impostoRenda.model.CalculoImposto;

/**
 * Created by malu.
 */

public class Aplicacao {

        public static void main(String [] args){
                CalculoImposto calculoImposto;
                Pessoa pessoa = new Pessoa(1050.00);
                calculoImposto = new CalculoImposto(pessoa);

                pessoa = new Pessoa(1960.00);
                calculoImposto = new CalculoImposto(pessoa);

                pessoa = new Pessoa(2950.00);
                calculoImposto = new CalculoImposto(pessoa);

                pessoa = new Pessoa(4200.00);
                calculoImposto = new CalculoImposto(pessoa);

                /*Professor do ifes*/
                pessoa = new Pessoa(11000.00);
                calculoImposto = new CalculoImposto(pessoa);

                /*Aluno do ifes*/
                pessoa = new Pessoa(-600.00);
                calculoImposto = new CalculoImposto(pessoa);
        }
}
