package ar.edu.unahur.obj2.uml.sistemas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import ar.edu.unahur.obj2.uml.usuarios.*;
import ar.edu.unahur.obj2.uml.alquileres.*;
import ar.edu.unahur.obj2.uml.vehiculos.*;

public class SistemaEmpresaTest {

    private Usuario matias = new Usuario("Matias");
    private Usuario ludmila = new Usuario("Ludmila");
    private Usuario cristian = new Usuario("Cristian");
    private SistemaEmpresa empresa = SistemaEmpresa.getInstance();
    private Monopatin monopatin = new Monopatin(null);
    private Bicicleta bici = new Bicicleta(38);
    private Bicicleta biciSinRegistrar = new Bicicleta(22);

    @BeforeEach
    void init() {
        empresa.registrarUsuario(cristian);
        empresa.registrarUsuario(matias);
        empresa.registrarVehiculo(bici);
        empresa.registrarVehiculo(monopatin);
    }

    @Test
    void testUnUsuarioSinRegistrarNoPuedeAlquilarUnAuto() {
        assertThrows(RuntimeException.class, 
            () -> {ludmila.solicitarAlquilerDeVehiculo(bici, "13Enero", "20febrero");}
        );
    }

    @Test
    void testNoSePuedeAlquilarUnAutoQueNoEsDeLaEmpresa() {
        assertThrows(RuntimeException.class, 
            () -> {matias.solicitarAlquilerDeVehiculo(biciSinRegistrar, "17Abril", "21Abril");}
        );
    }

    @Test
    void testUnUsuarioRegistradoPuedeAlquilarUnVehiculoDisponibleDeLaEmpresa() {
        empresa.getAlquileres().clear();
        matias.solicitarAlquilerDeVehiculo(bici, "14Mayo", "12Junio");
        assertAll(
            () -> assertFalse(bici.getEstaDisponible()) ,
            () -> assertEquals(1, empresa.getAlquileres().size())
        );
    }

    @Test
    void testNoSePuedeAlquilarUnVehiculoNoDisponible() {
        matias.solicitarAlquilerDeVehiculo(bici, "14Mayo", "12Junio");
        assertThrows(RuntimeException.class,
            () -> {matias.solicitarAlquilerDeVehiculo(bici, "12Mayo", "13Junio");}
        );
    }

    @Test
    void testLosAlquileresSeRegistranCorrectamente() {
        empresa.getAlquileres().clear();
        cristian.solicitarAlquilerDeVehiculo(bici, "14Mayo", "12Junio");
        Alquiler alquilerCreado = empresa.getAlquileres().getFirst();
        Bicicleta biciAlquilada = (Bicicleta) alquilerCreado.getVehiculoAlquilado();
        assertAll(
            () -> assertEquals("14Mayo", alquilerCreado.getFechaInicio()),
            () -> assertEquals("12Junio", alquilerCreado.getFechaFin()),
            () -> assertEquals("Cristian", alquilerCreado.getUsuarioAlquiler().getNombre()),
            () -> assertEquals(38, biciAlquilada.getRodado())
        );
    }

} 
