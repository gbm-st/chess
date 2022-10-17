public class Pieza {
    //Definición de los valores unicode para cada una de las piezas del juego
    protected String[] simbolos = {" ", "\u2654", "\u2655", "\u2656", "\u2657", "\u2658", "\u2659",
                                "\u265A", "\u265B", "\u265C", "\u265D", "\u265E", "\u265F"};
    //Variable para el valor unicode de las piezas individuales
    protected String valor;
    //Variable para el formato de impresión de las piezas
    protected String formato;

    public Pieza(){
        valor = simbolos[0];
        formato = "[ " + valor + " ]";
    }

    public String getFormato() {
        return formato;
    }

    public String getValor(){
        return valor;
    }
}
