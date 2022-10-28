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
    protected static final String[] simbolos = {" ", "\u2654", "\u2655", "\u2656", "\u2657", "\u2658", "\u2659",
                                "\u265A", "\u265B", "\u265C", "\u265D", "\u265E", "\u265F"};
    //Variable para el valor unicode de las piezas individuales
    protected String valor;
    //Variable para el formato de impresión de las piezas
    protected String formato;

    /*Variable para determinar el color/jugador que controla la pieza
    0 = vacio, 1 = blanco, 2 = negro
     */
    protected int color;

    public Pieza(int simbolo, int color){
        this.valor = Pieza.simbolos[simbolo];
        formato = "[ " + valor + " ]";
        this.color = color;
    }

    public void resetearPieza(Pieza pieza)
    {
        pieza.valor = Pieza.simbolos[0];
        pieza.formato = "[ " + pieza.valor + " ]";
        pieza.color = 0;
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

    public boolean validacionBasica (int turno, Pieza variableNuevaPosicionTemporal)
    {
        // Validar que no elija vacio o color contrario, validar que se coma al color contrario
        // Validar que no se coma a pieza con el mismo color
        // Validar condicion de exito para un color (pendiente)

        if (this.color == 0) {
            System.out.println("No puedes mover espacios vacios.");
            return true;
        }
        if ((this.color == 1 && turno == 2) || (this.color == 2 && turno == 1)) {
            System.out.println("No puedes mover una pieza de color distinto al tuyo.");
            return true;
        }
        if ((this.color == 1 && variableNuevaPosicionTemporal.color == 1) ||
                (this.color == 2 && variableNuevaPosicionTemporal.color == 2)) {
            System.out.println("No puedes comerte a una pieza del mismo color.");
            return true;
        }

        return false;
    }

    // Método base para realizar polimorfismo.
    public boolean moverANuevaPosicion(int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                       int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, ArrayList<String> piezasMuertas) {
        return true;
    }
}
