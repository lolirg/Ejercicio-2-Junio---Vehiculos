/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2_junio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lolir
 */
public class Vehiculo {

    private static final int MIN_COLORES = 1;
    private static final int MAX_COLORES = 3;
    private final String matricula;
    private TreeSet<Color> coloresVehiculo = new TreeSet<Color>();
    private ArrayList<LocalDate> fechasUsado = new ArrayList<LocalDate>();

    public Vehiculo(String matricula, Color... colores) throws IllegalArgumentException {

        Pattern patron = Pattern.compile("[0-9]{4}[A-Z]{3}");
        Matcher comprobacion = patron.matcher(matricula);
        if (!comprobacion.matches()) {
            throw new IllegalArgumentException("Error: la matrícula no cumple con el patrón");
        }

        TreeSet<Color> conjuntoColores = new TreeSet<Color>(Set.of(colores));
        if (conjuntoColores.size() < MIN_COLORES || conjuntoColores.size() > MAX_COLORES) {
            throw new IllegalArgumentException("Error: Los colores tienen que ser mínimo 1 y máximo 3");
        }

        this.matricula = matricula;
        this.coloresVehiculo.addAll(conjuntoColores);
    }

    public boolean addColor(Color color) throws Exception {
        boolean colorAñadido = false;
        if (this.coloresVehiculo.size() >= MAX_COLORES) {
            throw new Exception("Error: No se pueden añadir mas colores");
        } else if (this.coloresVehiculo.contains(color)) {
            throw new Exception("Error: este color ya existe");
        } else {
            this.coloresVehiculo.add(color);
            colorAñadido = true;
        }
        return colorAñadido;
    }

    public boolean quitarColor(Color color) throws Exception {
        boolean colorEliminado = false;
        if (this.coloresVehiculo.size() == MIN_COLORES) {
            throw new Exception("Error: No se pueden eliminar ningún color");
        } else if (!this.coloresVehiculo.contains(color)) {
            throw new Exception("Error: este color no existe");
        } else {
            this.coloresVehiculo.remove(color);
            colorEliminado = false;
        }
        return colorEliminado;
    }

    public boolean contieneColor(Color color) {
        boolean colorAñadido = false;
        if (this.coloresVehiculo.contains(color)) {
            colorAñadido = true;
        }
        return colorAñadido;
    }

    public int utilizar() {
        LocalDate fechaActual = LocalDate.now();
        this.fechasUsado.add(fechaActual);
        return this.fechasUsado.size();
    }

    public int vecesUtilizado() {
        return this.fechasUsado.size();
    }

    public int vecesUtilizadoAntesDe(LocalDate fecha) {
        int numeroVeces = 0;
        for (LocalDate elemento : this.fechasUsado) {
            if (elemento.isBefore(fecha)) {
                numeroVeces++;
            }
        }
        return numeroVeces;
    }

    public LocalDate ultimoUso() {
        LocalDate uUso;
        if (this.fechasUsado.isEmpty()) {
            uUso = null;
        } else {
            uUso = this.fechasUsado.get(0);
        }
        return uUso;
    }

    @Override
    public String toString() {
        return String.format("Matrícula: %s, Colores: %s, Usos: %s",
                this.matricula,
                this.coloresVehiculo,
                this.fechasUsado);
    }
}
