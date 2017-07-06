package br.ifes.leo.airConditioner;

import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

    private static int sensorCount = 3;
    private Sensor[] sensors;
    private AirConditioner airConditioner;

    @Given("^The air conditioner needs to control the temperature on room$")
    public void the_air_conditioner_needs_to_control_the_temperature_on_room() throws Throwable {
        sensors = new Sensor[sensorCount];
        airConditioner = new AirConditioner();

        for (int i = 0; i < sensorCount; i++){
            sensors[i] = new Sensor();
            sensors[i].addObserver(airConditioner);
        }
    }

    @When("^The Count of people \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" was registered by the three internal sensors$")
    public void the_count_of_people_was_registered_by_the_three_internal_sensors(String arg1, String arg2, String arg3) throws Throwable {
        sensors[0].setCurrentPeople(Integer.parseInt(arg1), 1);
        sensors[1].setCurrentPeople(Integer.parseInt(arg2), 2);
        sensors[2].setCurrentPeople(Integer.parseInt(arg3), 3);
    }

    @When("^With the values \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" registered by the external sensors$")
    public void with_the_values_registered_by_the_external_sensors(String arg1, String arg2, String arg3) throws Throwable {
        airConditioner.TemperatureAverage(Integer.parseInt(arg1), Integer.parseInt(arg2), Integer.parseInt(arg3));
    }

    @Then("^The people average \"([^\"]*)\" and the external temperature \"([^\"]*)\" are calculated$")
    public void the_people_average_and_the_external_temperature_are_calculated(String arg1, String arg2) throws Throwable {
        assertEquals(Integer.parseInt(arg1), airConditioner.peopleAverage);
        assertEquals(Integer.parseInt(arg2), airConditioner.externalTemperature);
    }

    @Then("^The room temperature is calculated and normalized$")
    public void the_room_temperature_is_calculated_and_normalized() throws Throwable {
        assertEquals(25, airConditioner.GetTemperatureAlert());
    }
}