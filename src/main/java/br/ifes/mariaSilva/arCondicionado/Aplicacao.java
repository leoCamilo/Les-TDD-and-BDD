package br.ifes.mariaSilva.arCondicionado;

/**
 * Created by malu.
 */
public class Aplicacao {

    public static void main(String[] args){

        Sensor sensor1 = new Sensor();
        Sensor sensor2 = new Sensor();
        Sensor sensor3 = new Sensor();
        ArCondicionado arCondicionado = new ArCondicionado();

        sensor1.addObserver(arCondicionado);
        sensor1.setCurrentPessoas(5, 1);
        sensor2.addObserver(arCondicionado);
        sensor2.setCurrentPessoas(4, 2);
        sensor3.addObserver(arCondicionado);
        sensor3.setCurrentPessoas(6, 3);

    }

}
