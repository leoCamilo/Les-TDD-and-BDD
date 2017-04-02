package br.ifes.mariaSilva.calculadoraPolonesa;

import static org.junit.Assert.assertEquals;

import br.ifes.mariaSilva.calculadoraPolonesa.model.Calculadora;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by malu.
 */

public class Steps {

    Calculadora calculadora;
    Double valor;

    @Given("^a necessidade de realizar um calculo em notacao polonesa inversa$")
    public void a_necessidade_de_realizar_um_calculo_em_notacao_polonesa_inversa() throws Throwable {
        this.calculadora = new Calculadora();
    }

    @When("^for inserida a entrada \"([^\"]*)\"$")
    public void for_inserida_a_entrada(String arg1) throws Throwable {
        this.valor = calculadora.evaluate(arg1);
    }

    @Then("^terei a saida \"([^\"]*)\"$")
    public void terei_a_saida(String arg1) throws Throwable {
        assertEquals(arg1, Double.toString(this.valor));
    }

}
