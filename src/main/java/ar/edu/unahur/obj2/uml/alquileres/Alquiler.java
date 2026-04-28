package ar.edu.unahur.obj2.uml.alquileres;

import ar.edu.unahur.obj2.uml.usuarios.*;
import ar.edu.unahur.obj2.uml.vehiculos.*;

public class Alquiler {
    
    private String fechaInicio;
    private String fechaFin;
    private Vehiculo vehiculoAlquilado;
    private Usuario usuarioAlquiler;
    
    public Alquiler(String fechaInicio, String fechaFin, Vehiculo vehiculoAlquilado, Usuario usuarioAlquiler) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.vehiculoAlquilado = vehiculoAlquilado;
        this.usuarioAlquiler = usuarioAlquiler;
    }
    public String getFechaInicio() {
        return fechaInicio;
    }
    public String getFechaFin() {
        return fechaFin;
    }
    public Vehiculo getVehiculoAlquilado() {
        return vehiculoAlquilado;
    }
    public Usuario getUsuarioAlquiler() {
        return usuarioAlquiler;
    }
    
    

    
}
