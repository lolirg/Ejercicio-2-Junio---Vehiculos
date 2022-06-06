/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2_junio;

import java.time.LocalDate;

/**
 *
 * @author lolir
 */
public class prueba {

    public static void main(String[] args) {

        //Vehículo con matrícula errónea
        try {
            Vehiculo vehiculo1 = new Vehiculo("1234X", Color.ROJO, Color.VERDE, Color.AZUL);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        //Vehículo con más de 3 colores
        try {
            Vehiculo vehiculo2 = new Vehiculo("1234XYZ", Color.ROJO, Color.VERDE, Color.AZUL, Color.BLANCO);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        //Vehículo valido 
        try {
            Vehiculo vehiculo3 = new Vehiculo("1234XYZ", Color.ROJO, Color.VERDE);
            //Añadimos un color
            vehiculo3.addColor(Color.BLANCO);
            //Eliminamos un color
            vehiculo3.quitarColor(Color.VERDE);
            //Comprobamos color
            System.out.println("Contiene el color Rojo: " + vehiculo3.contieneColor(Color.ROJO));
            //Usamos el vehiculo
            vehiculo3.utilizar();
            //Comprobamos las veces que se ha utilizado el vehículo
            System.out.println("El vehículo se ha usado " + vehiculo3.vecesUtilizado() + " veces");
            //Comprobamos las veces que se ha utilizado antes de x dia
            System.out.println("Veces que se ha usado el vehículo antes del día 2 de junio: " + vehiculo3.vecesUtilizadoAntesDe(LocalDate.of(2022, 06, 02)));
            //Fecha de ultimo uso del vehículo
            System.out.println("Fecha de ultimo uso: " + vehiculo3.ultimoUso());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
