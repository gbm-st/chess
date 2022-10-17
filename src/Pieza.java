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
    True = Negro / Falso = Blanco
     */
    protected boolean color;

    public Pieza(String valor){
        this.valor = valor;
        formato = "[ " + valor + " ]";
    }

    public String getFormato() {
        return formato;
    }

    public String getValor(){
        return valor;
    }
}
