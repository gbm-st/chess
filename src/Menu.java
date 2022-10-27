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
        char posicionLetraY;
        char nuevaPosicionLetraY;

        Scanner scanner = new Scanner(System.in);

        // Hace falta cambiar esto para que termine cuando maten al rey
        while(true)
        {
            variableTemporal += 1;

            // Hace falta poner try catch para validar
            System.out.print("Elije las coordenadas X  para elegir una pieza: ");
            posicionPiezaX = scanner.nextInt();
            System.out.print("Elije las coordenadas Y para elegir una pieza: ");
            posicionLetraY = scanner.next().charAt(0);
            System.out.print("Elije las coordenadas X para mover a una posicion una pieza: ");
            nuevaPosicionX = scanner.nextInt();
            System.out.print("Elije las coordenadas Y para mover a una posicion una pieza: ");
            nuevaPosicionLetraY = scanner.next().charAt(0);

            posicionPiezaX = 8 - posicionPiezaX;
            nuevaPosicionX = 8 - nuevaPosicionX;

            posicionPiezaY = toLowerCase(posicionLetraY) - 'a';
            nuevaPosicionY = toLowerCase(nuevaPosicionLetraY) - 'a';

//            System.out.println(posicionPiezaX);
//            System.out.println(posicionPiezaY);
//            System.out.println(nuevaPosicionX);
//            System.out.println(nuevaPosicionY);

            partida.cambiarTurno(posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY);

            if (variableTemporal == 10)
            {
                break;
            }
        }

        //Cerrar scanner
        scanner.close();
    }

}
