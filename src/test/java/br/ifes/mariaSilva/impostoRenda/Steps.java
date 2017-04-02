package br.ifes.mariaSilva.impostoRenda;

import br.ifes.mariaSilva.impostoRenda.control.Pessoa;
import br.ifes.mariaSilva.impostoRenda.model.CalculaImpostoStrategy;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Created by malu.
 */

public class Steps {

    double minValue, maxValue;
    Pessoa pessoa;
    CalculaImpostoStrategy calcImposto;

    @Given("^Eu recebo \"([^\"]*)\" mensalmente$")
    public void eu_recebo_mensalmente(String arg1) throws Throwable {
        this.pessoa = new Pessoa(Double.parseDouble(arg1));
    }

    @When("^Valor minimo \"([^\"]*)\" e valor maximo \"([^\"]*)\"$")
    public void valor_minimo_e_valor_maximo(String arg1, String arg2) throws Throwable {
        this.minValue = Double.parseDouble(arg1);
        this.maxValue = Double.parseDouble(arg2);
    }

    @Then("^seria calculado sobre o valor de \"([^\"]*)\" %$")
    public void seria_calculado_sobre_o_valor_de(String arg1) throws Throwable {
        calcImposto = new CalculaImpostoStrategy(this.minValue, this.maxValue, Double.parseDouble(arg1));
        calcImposto.calcularImpostoRenda(pessoa);
    }

    @Then("^resultaria no valor de \"([^\"]*)\" reais$")
    public void resultaria_no_valor_de_reais(String arg1) throws Throwable {
        assertEquals(arg1, Double.toString(calcImposto.getImposto()));
    }
}