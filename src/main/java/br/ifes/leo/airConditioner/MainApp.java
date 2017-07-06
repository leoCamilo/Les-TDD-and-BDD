package br.ifes.leo.airConditioner;

public class MainApp {
    private static int sensorCount = 3;

    public static void main(String[] args) {
        Sensor[] sensors = new Sensor[sensorCount];
        AirConditioner airConditioner = new AirConditioner();

        for (int i = 0; i < sensorCount; i++){
            sensors[i] = new Sensor();
            sensors[i].addObserver(airConditioner);
        }

        sensors[0].setCurrentPeople(5, 1);
        sensors[1].setCurrentPeople(4, 2);
        sensors[2].setCurrentPeople(6, 3);
    }
}
