package br.ifes.leo.navigation.model;

import br.ifes.leo.navigation.control.City;
import br.ifes.leo.navigation.control.Expression;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public abstract class AbstractDirectionalAppraiser implements Expression {
    private final Map<String, City> cities;

    protected AbstractDirectionalAppraiser next;
    protected String direction;
    protected City actualCity = new City("Initial city", 0, 0);

    protected abstract String[] matchingWords();
    public abstract boolean compareCities(City city1, City city2);

    public City getActualCity() { return this.actualCity; }
    public void nextExpression(AbstractDirectionalAppraiser next) { this.next = next; }

    public AbstractDirectionalAppraiser(){
        cities = new HashMap<String, City>();

        cities.put("Dublin",        new City("Dublin", 53.35, -6.27));
        cities.put("Galway",        new City("Galway", 53.07, -8.82));
        cities.put("Waterford",     new City("Waterford", 52.26, -7.11));
        cities.put("Cork",          new City("Cork", 51.90, -8.47));
        cities.put("Paris",         new City("Paris", 48.86, 2.35));
        cities.put("Amsterdam",     new City("Amsterdam", 52.38, 4.90));
        cities.put("Barcelona",     new City("Barcelona", 41.39, 2.15));
        cities.put("Porto",         new City("Porto", 41.15, -8.63));
        cities.put("Salvador",      new City("Salvador", -12.97, -38.50));
        cities.put("Curitiba",      new City("Curitiba", -25.42, -49.26));
        cities.put("Florianopolis", new City("Florianopolis", -27.59, -48.55));
        cities.put("Vitoria",       new City("Vitoria", -20.30, -40.30));
    }

    private City execute(Stack<City> expressions) {
        City selectedCity = !expressions.empty() ? expressions.pop() : getActualCity();

        while (!expressions.empty()) {
            City tmpCity = expressions.pop();

            if(compareCities(selectedCity, tmpCity))
                selectedCity = tmpCity;
        }

        return selectedCity;
    }

    public static City process(String input){
        AbstractDirectionalAppraiser east = new FurtherEast();
        AbstractDirectionalAppraiser north = new FurtherNorth();
        AbstractDirectionalAppraiser west = new FurtherWest();
        AbstractDirectionalAppraiser south = new FurtherSouth();

        east.nextExpression(north);
        north.nextExpression(west);
        west.nextExpression(south);

        return east.interpreter(input);
    }

    public City interpreter(String route){
        Stack<City> expressions = new Stack<City>();
        boolean wordFound = matchingWords().length == 0;

        for(String words: route.split(" ")){
            if(cities.containsKey(words))
                expressions.push(cities.get(words));

            wordFound = direction.equals(words) || wordFound;
            this.actualCity = direction.equals(words) || wordFound ? execute(expressions) : this.next.interpreter(route);
        }

        return this.actualCity;
    }
}