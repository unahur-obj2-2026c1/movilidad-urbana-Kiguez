package ar.edu.unahur.obj2.uml.vehiculos;

public abstract class Vehiculo {
    
    private Boolean estaDisponible=true;

    public Vehiculo() {}

    public Boolean getEstaDisponible() {
        return estaDisponible;
    }

    public void alquilar() {
        estaDisponible = false;
    }
    
    public void devolver() {
        estaDisponible = true;
    }
}

