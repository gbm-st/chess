import java.util.Scanner;

import static java.lang.Character.toLowerCase;

public class Menu {
    //Clase que manejará el inicio y final del juego secuencialmente
    public Menu(){
        Tablero tablero = new Tablero();

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
            System.out.print("Elige las coordenadas X  para elegir una pieza: ");
            posicionPiezaX = 8 - scanner.nextInt();
            System.out.print("Elige las coordenadas Y para elegir una pieza: ");
            posicionPiezaY = toLowerCase(scanner.next().charAt(0)) - 'a';
            System.out.print("Elige las coordenadas X para mover a una posición una pieza: ");
            nuevaPosicionX = 8 - scanner.nextInt();
            System.out.print("Elige las coordenadas Y para mover a una posición una pieza: ");
            nuevaPosicionY = toLowerCase(scanner.next().charAt(0)) - 'a';

            tablero.cambiarTurno((short)posicionPiezaX, (short)posicionPiezaY, (short)nuevaPosicionX, (short)nuevaPosicionY);

            if (variableTemporal == 30)
            {
                break;
            }
        }

        //Cerrar scanner
        scanner.close();
    }

}
