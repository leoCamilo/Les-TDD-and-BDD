package br.ifes.leo.navigation.model;

import br.ifes.leo.navigation.control.City;

public class FurtherEast extends AbstractDirectionalAppraiser {
    public FurtherEast() { this.direction = "Leste"; }

    @Override
    protected String[] matchingWords() { return new String[]{"Leste"}; }

    public boolean compareCities(City city1, City city2) {
        return city1.getLng() < city1.getLng();
    }
}