import java.util.ArrayList;

public class Rey extends Pieza{
    public Rey(int simbolo, int color)
    {
        super(simbolo, color);
    }

    public boolean moverANuevaPosicion (byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal) {

        try {
        /* Condición que verifica la posición deseada de la pieza hacia (x-1)(y-1). Si se cumple,
        entonces la pieza se mueve una casilla en dicha dirección*/
            if ((piezas[posicionPiezaX - 1][posicionPiezaY - 1] == piezas[nuevaPosicionX][nuevaPosicionY])
                    && (piezas[posicionPiezaX - 1][posicionPiezaY - 1].color == 0
                    || piezas[posicionPiezaX - 1][posicionPiezaY - 1].color != turno)) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        try {
        /* Condición que verifica la posición deseada de la pieza hacia (x-1)(y). Si se cumple,
        entonces la pieza se mueve una casilla en dicha dirección*/
            if ((piezas[posicionPiezaX - 1][posicionPiezaY] == piezas[nuevaPosicionX][nuevaPosicionY])
                    && (piezas[posicionPiezaX - 1][posicionPiezaY].color == 0
                    || piezas[posicionPiezaX - 1][posicionPiezaY].color != turno)) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        try {
        /* Condición que verifica la posición deseada de la pieza hacia (x-1)(y+1). Si se cumple,
        entonces la pieza se mueve una casilla en dicha dirección*/
            if ((piezas[posicionPiezaX - 1][posicionPiezaY + 1] == piezas[nuevaPosicionX][nuevaPosicionY])
                    && (piezas[posicionPiezaX - 1][posicionPiezaY + 1].color == 0
                    || piezas[posicionPiezaX - 1][posicionPiezaY + 1].color != turno)) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        try {
        /* Condición que verifica la posición deseada de la pieza hacia (x)(y-1). Si se cumple,
        entonces la pieza se mueve una casilla en dicha dirección*/
            if ((piezas[posicionPiezaX][posicionPiezaY - 1] == piezas[nuevaPosicionX][nuevaPosicionY])
                    && (piezas[posicionPiezaX][posicionPiezaY - 1].color == 0
                    || piezas[posicionPiezaX][posicionPiezaY - 1].color != turno)) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        try {
        /* Condición que verifica la posición deseada de la pieza hacia (x)(y+1). Si se cumple,
        entonces la pieza se mueve una casilla en dicha dirección*/
            if ((piezas[posicionPiezaX][posicionPiezaY + 1] == piezas[nuevaPosicionX][nuevaPosicionY])
                    && (piezas[posicionPiezaX][posicionPiezaY + 1].color == 0
                    || piezas[posicionPiezaX][posicionPiezaY + 1].color != turno)) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        try {
        /* Condición que verifica la posición deseada de la pieza hacia (x+1)(y-1). Si se cumple,
        entonces la pieza se mueve una casilla en dicha dirección*/
            if ((piezas[posicionPiezaX + 1][posicionPiezaY - 1] == piezas[nuevaPosicionX][nuevaPosicionY])
                    && (piezas[posicionPiezaX + 1][posicionPiezaY - 1].color == 0
                    || piezas[posicionPiezaX + 1][posicionPiezaY - 1].color != turno)) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        try {
        /* Condición que verifica la posición deseada de la pieza hacia (x+1)(y). Si se cumple,
        entonces la pieza se mueve una casilla en dicha dirección*/
            if ((piezas[posicionPiezaX + 1][posicionPiezaY] == piezas[nuevaPosicionX][nuevaPosicionY])
                    && (piezas[posicionPiezaX + 1][posicionPiezaY].color == 0
                    || piezas[posicionPiezaX + 1][posicionPiezaY].color != turno)) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        try {
        /* Condición que verifica la posición deseada de la pieza hacia (x+1)(y+1). Si se cumple,
        entonces la pieza se mueve una casilla en dicha dirección*/
            if ((piezas[posicionPiezaX + 1][posicionPiezaY + 1] == piezas[nuevaPosicionX][nuevaPosicionY])
                    && (piezas[posicionPiezaX + 1][posicionPiezaY + 1].color == 0
                    || piezas[posicionPiezaX + 1][posicionPiezaY + 1].color != turno)) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        System.out.println("El objetivo no se encuentra en el rango del rey.");

        return false;
    }
}