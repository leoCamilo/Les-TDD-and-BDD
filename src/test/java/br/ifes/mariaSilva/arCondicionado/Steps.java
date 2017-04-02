package br.ifes.mariaSilva.arCondicionado;

import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by malu.
 */

public class Steps {

    Sensor sensorInterno1 = new Sensor();
    Sensor sensorInterno2 = new Sensor();
    Sensor sensorInterno3 = new Sensor();
    ArCondicionado arCondicionado;

    @Given("^O ar condicionado precisa controlar a temperatura interna da sala$")
    public void o_ar_condicionado_precisa_controlar_a_temperatura_interna_da_sala() throws Throwable {
        arCondicionado = new ArCondicionado();
    }

    @When("^As quantidades de pessoas \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" foram registrados pelos tres sensores internos\"$")
    public void as_quantidades_de_pessoas_foram_registrados_pelos_tres_sensores_internos(String arg1, String arg2, String arg3) throws Throwable {
        sensorInterno1.addObserver(arCondicionado);
        sensorInterno1.setCurrentPessoas(Integer.parseInt(arg1), 1);
        sensorInterno2.addObserver(arCondicionado);
        sensorInterno2.setCurrentPessoas(Integer.parseInt(arg2), 2);
        sensorInterno3.addObserver(arCondicionado);
        sensorInterno3.setCurrentPessoas(Integer.parseInt(arg3), 3);
    }

    @When("^Tendo os valores \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" registrados pelos sensores de temperatura externos\"$")
    public void tendo_os_valores_registrados_pelos_sensores_de_temperatura_externos(String arg1, String arg2, String arg3) throws Throwable {
        arCondicionado.media_temp_externa(Integer.parseInt(arg1), Integer.parseInt(arg2), Integer.parseInt(arg3));
    }

    @Then("^Tanto a media de pessoas \"([^\"]*)\" quanto a media da temperatura externa \"([^\"]*)\" são calculados$")
    public void tanto_a_media_de_pessoas_quanto_a_media_da_temperatura_externa_são_calculados(String arg1, String arg2) throws Throwable {
        assertEquals(Integer.parseInt(arg1), arCondicionado.mediaPessoas);
        assertEquals(Integer.parseInt(arg2), arCondicionado.tempExterna);
    }

    @Then("^eh calculada e normalizada a temperatura da sala$")
    public void eh_calculada_e_normalizada_a_temperatura_da_sala() throws Throwable {
        assertEquals(25, arCondicionado.TEMPERATURA_ALERT);
    }

}
