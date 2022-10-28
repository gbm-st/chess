import java.util.Scanner;

import static java.lang.Character.toLowerCase;

public class Menu {
    //Clase que manejará el inicio y final del juego secuencialmente
    public Menu(){
        Partida partida = new Partida();

        int variableTemporal = 0;

        int posicionPiezaX;
        int posicionPiezaY;
        int nuevaPosicionX;
        int nuevaPosicionY;

        Scanner scanner = new Scanner(System.in);

        // Hace falta cambiar esto para que termine cuando maten al rey
        while(true)
        {
            variableTemporal += 1;

            // Hace falta poner try catch para validar
            System.out.print("Elije las coordenadas X  para elegir una pieza: ");
            posicionPiezaX = 8 - scanner.nextInt();
            System.out.print("Elije las coordenadas Y para elegir una pieza: ");
            posicionPiezaY = toLowerCase(scanner.next().charAt(0)) - 'a';
            System.out.print("Elije las coordenadas X para mover a una posicion una pieza: ");
            nuevaPosicionX = 8 - scanner.nextInt();
            System.out.print("Elije las coordenadas Y para mover a una posicion una pieza: ");
            nuevaPosicionY = toLowerCase(scanner.next().charAt(0)) - 'a';

            partida.cambiarTurno(posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY);

            if (variableTemporal == 30)
            {
                break;
            }
        }

        //Cerrar scanner
        scanner.close();
    }

}
