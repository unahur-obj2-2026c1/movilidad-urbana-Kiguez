package ar.edu.unahur.obj2.uml.sistemas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.uml.vehiculos.*;
import ar.edu.unahur.obj2.uml.usuarios.*;
import ar.edu.unahur.obj2.uml.alquileres.*;

public class SistemaEmpresa {
    
    List<Vehiculo> vehiculos = new ArrayList<>();
    List<Usuario> usuarios = new ArrayList<>();
    List<Alquiler> alquileres = new ArrayList<>();

    private static SistemaEmpresa instance = new SistemaEmpresa();

    private SistemaEmpresa() {}

    public static SistemaEmpresa getInstance() {
        return instance;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void registrarUsuario(Usuario unUsuario) {
        usuarios.add(unUsuario);
    }

    public void registrarVehiculo(Vehiculo unVehiculo) {
        vehiculos.add(unVehiculo);
    }

    public Boolean existeVehiculoEnEmpresa(Vehiculo unVehiculo) {
        return
            vehiculos.contains(unVehiculo);
    }

    public Boolean existeUsuarioEnEmpresa(Usuario unUsuario) {
        return
            usuarios.contains(unUsuario);
    }

    public void alquilarVehiculo(Usuario unUsuario , Vehiculo unVehiculo , String inicioAlquiler , String finalAlquiler) {
        if (! this.existeUsuarioEnEmpresa(unUsuario)) {
            throw new RuntimeException("El usuario " + unUsuario.getNombre() + " no esta registrado");
        }
        if(! this.existeVehiculoEnEmpresa(unVehiculo) | ! unVehiculo.getEstaDisponible()) {
            throw new RuntimeException("No se puede alquilar el vehiculo solicitado");
        }
        unVehiculo.alquilar();
        alquileres.add(new Alquiler(inicioAlquiler, finalAlquiler , unVehiculo , unUsuario));
    }


}
