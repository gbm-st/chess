import java.util.Scanner;

import static java.lang.Character.toLowerCase;

public class Menu {
    //Clase que manejará el inicio y final del juego secuencialmente
    public Menu(){
        Tablero tablero = new Tablero();

        int cantidadDeTurnosDisponibles = 0;

        int posicionPiezaX;
        int posicionPiezaY;
        int nuevaPosicionX;
        int nuevaPosicionY;

        Scanner scanner = new Scanner(System.in);

        // Hace falta cambiar esto para que termine cuando maten al rey
        while(true)
        {
            cantidadDeTurnosDisponibles += 1;

            // Hace falta poner try catch para validar
            System.out.print("Elije las coordenadas X  para elegir una pieza: ");
            posicionPiezaX = 8 - scanner.nextInt();
            System.out.print("Elije las coordenadas Y para elegir una pieza: ");
            posicionPiezaY = toLowerCase(scanner.next().charAt(0)) - 'a';
            System.out.print("Elije las coordenadas X para mover a una posicion una pieza: ");
            nuevaPosicionX = 8 - scanner.nextInt();
            System.out.print("Elije las coordenadas Y para mover a una posicion una pieza: ");
            nuevaPosicionY = toLowerCase(scanner.next().charAt(0)) - 'a';

            tablero.cambiarTurno((short)posicionPiezaX, (short)posicionPiezaY, (short)nuevaPosicionX, (short)nuevaPosicionY);

            if (tablero.JaqueMate)
            {
                break;
            }

            if (cantidadDeTurnosDisponibles == 50)
            {
                System.out.println("El juego no puede acabar. Es un empate.");
                break;
            }
        }

        //Cerrar scanner
        scanner.close();
    }

}
