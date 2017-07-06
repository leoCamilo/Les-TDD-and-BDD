package br.ifes.leo.airConditioner;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class AirConditioner implements Observer{
    public int externalTemperature;
    public int peopleAverage;

    private int temperatureAlert = 25;
    private HashMap<Integer, Sensor> sensors = new  HashMap<Integer, Sensor>();

    public int GetTemperatureAlert() { return temperatureAlert; }

    public void update(Observable obs, Object obj) {
        Sensor sensor = (Sensor) obs;
        sensors.put(sensor.getId(), sensor);

        if (sensors.size() != 3){
            System.out.println("Waiting others sensors.");
            return;
        }

        this.temperatureAlert = this.temperatureAlert + SensorsAverage(sensors.get(1), sensors.get(2), sensors.get(3));
        System.out.println(temperatureAlert + " degrees. Ideal: 25");

        if(temperatureAlert > 25){
            this.temperatureAlert = this.temperatureAlert - peopleAverage;

            System.out.println("Normalizing temperature");
            System.out.println("Temperature normalized");
        } else {
            System.out.println("No change needed");
        }
    }

    public int SensorsAverage(Sensor... sensors){
        int total = 0, i;

        for (i = 0; i < sensors.length; i++)
            total += sensors[i].getPeopleCount();

        this.peopleAverage = Math.round(total / i);
        return peopleAverage <= 0 ? 0 : peopleAverage;
    }

    public void TemperatureAverage(int... temperatures){
        int total = 0, i;

        for (i = 0; i < temperatures.length; i++)
            total += temperatures[i];

        this.externalTemperature = Math.round(total / i);
    }
}