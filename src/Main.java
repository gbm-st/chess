import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Character.toLowerCase;

public class Main
{
    private Tablero tablero;
    private Scanner scanner;
    public static void main(String[] args)
    {
        Main main = new Main();
        main.iniciarJuego();
    }

    public Main()
    {
        tablero = new Tablero();

        scanner = new Scanner(System.in);
    }

    public void iniciarJuego()
    {
        int posicionPiezaX;
        int posicionPiezaY;
        int nuevaPosicionX;
        int nuevaPosicionY;

        // Hace falta cambiar esto para que termine cuando maten al rey
        while(!tablero.JaqueMate)
        {
            // Hace falta poner try catch para validar
            System.out.print("Elige una letra para una pieza: ");
            try{
                posicionPiezaY = toLowerCase(scanner.next().charAt(0)) - 'a';
                if(posicionPiezaY < 0)
                    continue;
            }
            catch (InputMismatchException i)
            {
                continue;
            }
            System.out.print("Elige un número para una pieza: ");
            try {
                posicionPiezaX = 8 - scanner.nextInt();
            }
            catch (InputMismatchException i)
            {
                continue;
            }
            System.out.print("Elige una letra para mover a una posición una pieza: ");
            try {
                nuevaPosicionY = toLowerCase(scanner.next().charAt(0)) - 'a';
                if(nuevaPosicionY < 0)
                    continue;
            }
            catch (InputMismatchException i)
            {
                continue;
            }
            System.out.print("Elige un número para mover a una posición una pieza: ");
            try {
                nuevaPosicionX = 8 - scanner.nextInt();
            }
            catch (InputMismatchException i)
            {
                continue;
            }

            tablero.cambiarTurno((short)posicionPiezaX, (short)posicionPiezaY, (short)nuevaPosicionX, (short)nuevaPosicionY);

            if((tablero.jugadores[0].estaEnJaque || tablero.jugadores[1].estaEnJaque) && tablero.terminarPartida(tablero.getTurno()))
            {
                tablero.JaqueMate = true;
            }
        }

        //Cerrar scanner
        scanner.close();
    }
}