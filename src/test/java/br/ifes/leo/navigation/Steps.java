package br.ifes.leo.navigation;

import br.ifes.leo.navigation.control.City;
import br.ifes.leo.navigation.model.AbstractDirectionalAppraiser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class Steps {
    private String cities;
    private City output;

    @Given("^Cities are informed \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void cities_are_informed(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        this.cities = arg1 + " " + arg2 + " " + arg3 + " " + arg4;
    }

    @When("^Inserted the cardinal point \"([^\"]*)\"$")
    public void inserted_the_cardinal_point(String arg1) throws Throwable {
        String input = arg1 + " " + this.cities;
        this.output = AbstractDirectionalAppraiser.process(input);
    }

    @Then("^The answer city is \"([^\"]*)\"$")
    public void the_answer_city_is(String arg1) throws Throwable {
        assertEquals(arg1, this.output.getName());
    }
}