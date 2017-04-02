package br.ifes.mariaSilva.arCondicionado;

import java.util.Observable;

/**
 * Created by malu.
 */

public class Sensor extends Observable{
    private int quantidadePessoas = 0;
    private int idSensor;

    public void setCurrentPessoas(int qtdPessoas, int idSensor){
        this.quantidadePessoas = qtdPessoas;
        this.idSensor = idSensor;
        setChanged();
        notifyObservers();
    }

    public int getQtdPessoas(){
        return quantidadePessoas;
    }

    public int getIdSensor(){
        return idSensor;
    }

}
