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

    public boolean piezaMuerta;
    protected static final String[] simbolos = {" ",
                                                "\u001b[38;5;160mK",
                                                "\u001b[38;5;160mQ",
                                                "\u001b[38;5;160mR",
                                                "\u001b[38;5;160mB",
                                                "\u001b[38;5;160mH",
                                                "\u001b[38;5;160mP",
                                                "\u001b[38;5;21mK",
                                                "\u001b[38;5;21mQ",
                                                "\u001b[38;5;21mR",
                                                "\u001b[38;5;21mB",
                                                "\u001b[38;5;21mH",
                                                "\u001b[38;5;21mP"};
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
        formato = "  " + valor + "  ";
        this.color = color;
    }

    public Pieza(Pieza piezaOriginal){
        this.jugador = piezaOriginal.jugador;
        this.valor = piezaOriginal.valor;
        formato = "  " + piezaOriginal.valor + "  ";
        this.color = piezaOriginal.color;
        this.coordenadaX = piezaOriginal.coordenadaX;
        this.coordenadaY = piezaOriginal.coordenadaY;
    }

    public void resetearPieza()
    {
        this.valor = Pieza.simbolos[0];
        this.formato = "  " + this.valor + "  ";
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
        // Validar que no elija vacío o color contrario, validar que se coma al color contrario
        // Validar que no se coma a pieza con el mismo color

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

    public boolean reyAliadoEstaEnJaque(byte turno, Pieza[][] piezas, Tablero tablero)
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
