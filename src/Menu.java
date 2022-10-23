import java.util.Scanner;

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
            System.out.print("Elije las coordenadas X (en numeros naturales) para elegir una pieza: ");
            posicionPiezaX = scanner.nextInt();
            System.out.print("Elije las coordenadas Y (en numeros naturales) para elegir una pieza: ");
            posicionPiezaY = scanner.nextInt();
            System.out.print("Elije las coordenadas X (en numeros naturales) para mover una pieza: ");
            nuevaPosicionX = scanner.nextInt();
            System.out.print("Elije las coordenadas Y (en numeros naturales) para mover una pieza: ");
            nuevaPosicionY = scanner.nextInt();

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
