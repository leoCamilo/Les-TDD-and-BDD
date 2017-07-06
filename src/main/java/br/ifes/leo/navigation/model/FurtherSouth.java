package br.ifes.leo.navigation.model;

import br.ifes.leo.navigation.control.City;

public class FurtherSouth extends AbstractDirectionalAppraiser {
    public FurtherSouth() { this.direction = "Sul"; }
    
    @Override
    protected String[] matchingWords() { return new String[]{"Sul"}; }

    public boolean compareCities(City city1, City city2) {
        return city1.getLat() > city2.getLat();
    }
}