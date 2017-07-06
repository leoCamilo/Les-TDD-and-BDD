package br.ifes.leo.navigation.control;

public class City {
    private final String name;
    private final double lat;
    private final double lng;

    public City(String name, double lat, double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() { return name; }
    public double getLat() { return lat; }
    public double getLng() { return lng; }
   
    public void answer() { System.out.println("City: "+ getName()); }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof City && getName().equals(((City) obj).getName());
    }
}