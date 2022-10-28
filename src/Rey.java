import java.util.ArrayList;

public class Rey extends Pieza{
    public Rey(int simbolo, int color)
    {
        super(simbolo, color);
    }

    public boolean moverANuevaPosicion (int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, ArrayList<String> piezasMuertas) {
        Pieza temporalRey = piezas[posicionPiezaX][posicionPiezaY];
        int posicionOriginalX = posicionPiezaX;
        int posicionOriginalY = posicionPiezaY;

        try {
            while (temporalRey != piezas[nuevaPosicionX][nuevaPosicionY]) {
                if (((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0))
                        || ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY < 0))
                        || ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY > 0))
                        || ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY < 0))) {
                    System.out.println("Las torres no se pueden mover diagonalmente.");
                    return true;
                }
            }
        } catch (Exception e) {

        }
        return true;
    }
}