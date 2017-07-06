package br.ifes.leo.airConditioner;

import java.util.Observable;

public class Sensor extends Observable {
    private int id;
    private int peopleCount;

    public void setCurrentPeople(int qtdPessoas, int idSensor){
        this.peopleCount = qtdPessoas;
        this.id = idSensor;
        setChanged();
        notifyObservers();
    }

    public int getId(){ return id; }
    public int getPeopleCount(){ return peopleCount; }
}
