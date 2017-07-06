package br.ifes.leo.incomeTax;

import br.ifes.leo.incomeTax.control.People;
import br.ifes.leo.incomeTax.model.CalcTax;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

public class Steps {

    private CalcTax calcTax;

    @Given("^My salary is \"([^\"]*)\"$")
    public void my_salary_is(String arg1) throws Throwable {
        People people = new People(Double.parseDouble(arg1));
        calcTax = new CalcTax(people);
    }

    @Then("^My income tax is \"([^\"]*)\"$")
    public void my_income_tax_is(String arg1) throws Throwable {
        assertEquals(arg1, Double.toString(calcTax.getTax()));
    }
}