package br.ifes.mariaSilva.arCondicionado;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by malu.
 */

public class ArCondicionado implements Observer{
    int mediaPessoas, tempCalc, tempExterna;

    public int TEMPERATURA_ALERT = 25;
    HashMap<Integer, Sensor> registroSensores = new  HashMap<Integer, Sensor>();


    public void update(Observable obs, Object obj) {
        Sensor sensor = (Sensor) obs;
        registroSensores.put(sensor.getIdSensor(), sensor);

        if(registroSensores.size() == 3){
            this.TEMPERATURA_ALERT = this.TEMPERATURA_ALERT + media_sensores(registroSensores.get(1), registroSensores.get(2),
                    registroSensores.get(3));
            System.out.println(TEMPERATURA_ALERT + " graus. Ideal: 25 graus");

            if(TEMPERATURA_ALERT > 25){
                this.tempCalc = this.TEMPERATURA_ALERT;
                System.out.println("Normalizando Temperatura...");
                this.TEMPERATURA_ALERT = this.TEMPERATURA_ALERT - mediaPessoas;
                System.out.println("Temperatura Normalizada com Sucesso!");
            }
            else {
                System.out.println("Nenhuma mudanca.");
            }
        }
        else{
            System.out.println("Esperando outros sensores.");
        }

    }

    public int media_sensores(Sensor sensor1, Sensor sensor2, Sensor sensor3){
        this.mediaPessoas = (int) Math.round((sensor1.getQtdPessoas() + sensor2.getQtdPessoas()
                + sensor3.getQtdPessoas())/3);

        if(mediaPessoas<=0){
            return 0;
        }
        else{
            return mediaPessoas;
        }
    }

    public void media_temp_externa(int temp1, int temp2, int temp3){
        this.tempExterna = (int) Math.round((temp1 + temp2 + temp3)/3);
    }
}