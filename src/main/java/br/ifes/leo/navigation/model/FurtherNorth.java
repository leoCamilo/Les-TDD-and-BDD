package br.ifes.leo.navigation.model;

import br.ifes.leo.navigation.control.City;

public class FurtherNorth extends AbstractDirectionalAppraiser {
    public FurtherNorth(){ this.direction = "Norte"; }
    
    @Override
    protected String[] matchingWords() { return new String[]{"Norte"}; }

    public boolean compareCities(City city1, City city2) {
        return city1.getLat() < city2.getLat();
    }
}