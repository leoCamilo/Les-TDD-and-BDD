package br.ifes.leo.polishCalc;

import br.ifes.leo.polishCalc.model.Calc;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class Steps {
    private Calc calc;
    private Double valor;

    @Given("^The need to calculate an equation using reverse polish notation$")
    public void the_need_to_calculate_an_equation_using_reverse_polish_notation() throws Throwable {
        this.calc = new Calc();
    }

    @When("^If the input is \"([^\"]*)\"$")
    public void if_the_input_is(String arg1) throws Throwable {
        this.valor = calc.evaluate(arg1);
    }

    @Then("^The output is \"([^\"]*)\"$")
    public void the_output_is(String arg1) throws Throwable {
        assertEquals(arg1, Double.toString(this.valor));
    }
}