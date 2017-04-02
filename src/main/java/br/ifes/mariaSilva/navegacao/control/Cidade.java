package br.ifes.mariaSilva.navegacao.control;

/**
 * Created by malu.
 */

public class Cidade {
    private final String nome;
    private final double latitude;
    private final double longitude;

    public Cidade(String nome, double latitude, double longitude) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    
   
    public void resposta() {
        System.out.println("Cidade: "+ getNome());
    }

    @Override
    public int hashCode() {
        return getNome().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cidade)) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        return getNome().equals(other.getNome());
    }
    
}
