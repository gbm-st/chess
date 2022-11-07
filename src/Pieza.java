import java.util.ArrayList;

public class Pieza {
    //Definición de los valores unicode para cada una de las piezas del juego
    /*
    * 0 = Casilla vacía
    * BLANCOS
    * 1 = Rey
    * 2 = Reina
    * 3 = Torre
    * 4 = Alfil
    * 5 = Caballo
    * 6 = Peón
    * NEGROS
    * 7 = Rey
    * 8 = Reina
    * 9 = Torre
    * 10 = Alfil
    * 11 = Caballo
    * 12 = Peón
    * */
    public Jugador jugador;
    protected static final String[] simbolos = {" ",
                                                "\u001b[37m\u2654\u001b[0m",
                                                "\u001b[37m\u2655\u001b[0m",
                                                "\u001b[37m\u2656\u001b[0m",
                                                "\u001b[37m\u2657\u001b[0m",
                                                "\u001b[37m\u2658\u001b[0m",
                                                "\u001b[37m\u2659\u001b[0m",
                                                "\u001b[30m\u265A\u001b[0m",
                                                "\u001b[30m\u265B\u001b[0m",
                                                "\u001b[30m\u265C\u001b[0m",
                                                "\u001b[30m\u265D\u001b[0m",
                                                "\u001b[30m\u265E\u001b[0m",
                                                "\u001b[30m\u2659\u001b[0m"};
    //Variable para el valor unicode de las piezas individuales
    protected String valor;
    //Variable para el formato de impresión de las piezas
    protected String formato;

    protected int coordenadaX;
    protected int coordenadaY;

    /*Variable para determinar el color/jugador que controla la pieza
    0 = vacio, 1 = blanco, 2 = negro
     */
    protected int color;

    public Pieza(int simbolo, int color, Jugador jugador){
        this.jugador = jugador;
        this.valor = Pieza.simbolos[simbolo];
        formato = "[ " + valor + " ]";
        this.color = color;
    }

    public void resetearPieza()
    {
        this.valor = Pieza.simbolos[0];
        this.formato = "[ " + this.valor + " ]";
        this.color = 0;
        this.jugador = null;
    }

    public String getFormato() {
        return formato;
    }

    public String getValor(){
        return valor;
    }

    public String toString(){
        return getValor();
    }

    public boolean validacionBasica (byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX, int nuevaPosicionY, Pieza variableNuevaPosicionTemporal)
    {
        // Validar que no se salga del tablero
        if(posicionPiezaX > 7 || posicionPiezaY > 7 || nuevaPosicionX > 7 || nuevaPosicionY > 7 ||
                posicionPiezaX < 0 || posicionPiezaY < 0 || nuevaPosicionX < 0 || nuevaPosicionY < 0)
        {
            System.out.println("No te puedes salir de los limites.");
            return false;
        }

        // Validar que no elija vacio o color contrario, validar que se coma al color contrario
        // Validar que no se coma a pieza con el mismo color
        // Validar condicion de exito para un color (pendiente)

        if (this.color == 0) {
            System.out.println("No puedes mover espacios vacios.");
            return false;
        }
        if ((this.color == 1 && turno == 2) || (this.color == 2 && turno == 1)) {
            System.out.println("No puedes mover una pieza de color distinto al tuyo.");
            return false;
        }
        if ((this.color == 1 && variableNuevaPosicionTemporal.color == 1) ||
                (this.color == 2 && variableNuevaPosicionTemporal.color == 2)) {
            System.out.println("No puedes comerte a una pieza del mismo color.");
            return false;
        }

        return true;
    }

    // Método base para realizar polimorfismo.
    public boolean moverANuevaPosicion(byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                       int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, Tablero tablero)
    {
        return false;
    }

    public boolean estaJaqueando(byte turno, Pieza[][] piezas, Tablero tablero)
    {
        return false;
    }

    public void asignarCoordenadas(int x, int y)
    {
        coordenadaX = x;
        coordenadaY = y;
    }

    public void imprimirCoordenadas()
    {
        System.out.println("Coordenada X: " + coordenadaX + " Coordenada Y: " + coordenadaY);
    }

    public int obtenerCoordenadaX()
    {
        return coordenadaX;
    }

    public int obtenerCoordenadaY()
    {
        return coordenadaY;
    }
}
