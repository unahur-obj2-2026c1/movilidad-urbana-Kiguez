package ar.edu.unahur.obj2.uml.usuarios;

import ar.edu.unahur.obj2.uml.sistemas.SistemaEmpresa;
import ar.edu.unahur.obj2.uml.vehiculos.*;


public class Usuario {
    
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void solicitarAlquilerDeVehiculo(Vehiculo unVehiculo , String fechaInicio , String fechaFin) {
        SistemaEmpresa.getInstance().alquilarVehiculo(this , unVehiculo, fechaInicio, fechaFin);
    }

}
