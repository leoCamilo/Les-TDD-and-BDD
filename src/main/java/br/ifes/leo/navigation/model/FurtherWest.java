package br.ifes.leo.navigation.model;

import br.ifes.leo.navigation.control.City;

public class FurtherWest extends AbstractDirectionalAppraiser {
    public FurtherWest() { this.direction = "Oeste"; }
    
    @Override
    protected String[] matchingWords() { return new String[]{"Oeste"}; }

    public boolean compareCities(City city1, City city2) {
        return city1.getLng() > city2.getLng();
    }
}