package br.ifes.mariaSilva.navegacao;

import br.ifes.mariaSilva.navegacao.control.Cidade;
import br.ifes.mariaSilva.navegacao.model.AbstractAvaliadorDirecional;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Created by malu.
 */

public class Steps {

    String cidades, entrada;
    Cidade saida;

    @Given("^Sao informadas as cidades \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void sao_informadas_as_cidades(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        this.cidades = arg1 + " " + arg2 + " " + arg3 + " " + arg4;
    }

    @When("^inserido o ponto cardeal \"([^\"]*)\"$")
    public void inserido_o_ponto_cardeal(String arg1) throws Throwable {
        this.entrada = arg1 + " " + this.cidades;
        this.saida = AbstractAvaliadorDirecional.processar(this.entrada.toString());
    }

    @Then("^terei como retorno a cidade \"([^\"]*)\"$")
    public void terei_como_retorno_a_cidade(String arg1) throws Throwable {
        assertEquals(arg1, this.saida.getNome());
    }
}
