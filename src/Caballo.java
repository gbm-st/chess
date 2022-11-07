import java.util.ArrayList;

public class Caballo extends Pieza {
    public Caballo(int simbolo, int color)
    {
        super(simbolo, color);
    }

    public boolean moverANuevaPosicion (byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal)
    {


        try {
                    /* Condición que verifica la posición deseada de la pieza hacia (x-1)(y-2). Si se cumple,
                    entonces la pieza se mueve una casilla en dicha dirección*/
            if (piezas[posicionPiezaX - 1][posicionPiezaY - 2] == piezas [nuevaPosicionX][nuevaPosicionY]
                    && (piezas[posicionPiezaX - 1][posicionPiezaY - 2].color == 0
                    || piezas[posicionPiezaX - 1][posicionPiezaY - 2].color != turno)) {

                return true;

            }
        }
        catch (ArrayIndexOutOfBoundsException ignored)
        {
        }

        try {
                    /* Condición que verifica la posición deseada de la pieza hacia (x-2)(y-1). Si se cumple,
                    entonces la pieza se mueve una casilla en dicha dirección*/
            if (piezas[posicionPiezaX - 2][posicionPiezaY - 1] == piezas [nuevaPosicionX][nuevaPosicionY]
                    && (piezas[posicionPiezaX - 2][posicionPiezaY - 1].color == 0
                    || piezas[posicionPiezaX - 2][posicionPiezaY - 1].color != turno)) {

                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored)
        {
        }

        try {
                    /* Condición que verifica la posición deseada de la pieza hacia (x-2)(y+1). Si se cumple,
                    entonces la pieza se mueve una casilla en dicha dirección*/
            if (piezas[posicionPiezaX - 2][posicionPiezaY + 1] == piezas [nuevaPosicionX][nuevaPosicionY]
                    && (piezas[posicionPiezaX - 2][posicionPiezaY + 1].color == 0
                    || piezas[posicionPiezaX - 2][posicionPiezaY + 1].color != turno)) {

                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored)
        {
        }

        try {
                    /* Condición que verifica la posición deseada de la pieza hacia (x-1)(y+2). Si se cumple,
                    entonces la pieza se mueve una casilla en dicha dirección*/
            if (piezas[posicionPiezaX - 1][posicionPiezaY + 2] == piezas [nuevaPosicionX][nuevaPosicionY]
                    && (piezas[posicionPiezaX - 1][posicionPiezaY + 2].color == 0
                    || piezas[posicionPiezaX - 1][posicionPiezaY + 2].color != turno)) {

                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored)
        {
        }

        try {
                    /* Condición que verifica la posición deseada de la pieza hacia (x+1)(y+2). Si se cumple,
                    entonces la pieza se mueve una casilla en dicha dirección*/
            if (piezas[posicionPiezaX + 1][posicionPiezaY + 2] == piezas [nuevaPosicionX][nuevaPosicionY]
                    && (piezas[posicionPiezaX + 1][posicionPiezaY + 2].color == 0
                    || piezas[posicionPiezaX + 1][posicionPiezaY + 2].color != turno)) {

                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored)
        {
        }

        try {
                    /* Condición que verifica la posición deseada de la pieza hacia (x+2)(y+1). Si se cumple,
                    entonces la pieza se mueve una casilla en dicha dirección*/
            if (piezas[posicionPiezaX + 2][posicionPiezaY + 1] == piezas [nuevaPosicionX][nuevaPosicionY]
                    && (piezas[posicionPiezaX + 2][posicionPiezaY + 1].color == 0
                    || piezas[posicionPiezaX + 2][posicionPiezaY + 1].color != turno)) {

                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored)
        {
        }

        try {
                    /* Condición que verifica la posición deseada de la pieza hacia (x+2)(y-1). Si se cumple,
                    entonces la pieza se mueve una casilla en dicha dirección*/
            if (piezas[posicionPiezaX + 2][posicionPiezaY - 1] == piezas [nuevaPosicionX][nuevaPosicionY]
                    && (piezas[posicionPiezaX + 2][posicionPiezaY - 1].color == 0
                    || piezas[posicionPiezaX + 2][posicionPiezaY - 1].color != turno)) {

                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored)
        {
        }

        try {
                    /* Condición que verifica la posición deseada de la pieza hacia (x+1)(y-2). Si se cumple,
                    entonces la pieza se mueve una casilla en dicha dirección*/
            if (piezas[posicionPiezaX + 1][posicionPiezaY - 2] == piezas [nuevaPosicionX][nuevaPosicionY]
                    && (piezas[posicionPiezaX + 1][posicionPiezaY - 2].color == 0
                    || piezas[posicionPiezaX + 1][posicionPiezaY - 2].color != turno)) {

                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored)
        {
        }

        System.out.println("El objetivo no se encuentra en el rango del caballo.");

        return false;
    }

    private void verificarPrimerCamino(byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                       int nuevaPosicionY, Pieza[][] piezas, Pieza piezaTemporal) {
       /* Condición que verifica la posición deseada de la pieza hacia (x-1)(y-2). Si se cumple,
       entonces la pieza se mueve una casilla en dicha dirección*/
        if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                && (piezas[posicionPiezaX - 1][posicionPiezaY - 2].color == 0
                || piezas[posicionPiezaX - 1][posicionPiezaY - 2].color != turno)) {
            piezaTemporal = piezas[posicionPiezaX - 1][posicionPiezaY - 2];
        }
    }

    private void verificarSegundoCamino(byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza piezaTemporal) {
       /* Condición que verifica la posición deseada de la pieza hacia (x-2)(y-1). Si se cumple,
       entonces la pieza se mueve una casilla en dicha dirección*/
        if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                && (piezas[posicionPiezaX - 2][posicionPiezaY - 1].color == 0
                || piezas[posicionPiezaX - 2][posicionPiezaY - 1].color != turno)) {
            piezaTemporal = piezas[posicionPiezaX - 2][posicionPiezaY - 1];
        }
    }

    private void verificarTercerCamino(byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                       int nuevaPosicionY, Pieza[][] piezas, Pieza piezaTemporal) {
       /* Condición que verifica la posición deseada de la pieza hacia (x-2)(y+1). Si se cumple,
       entonces la pieza se mueve una casilla en dicha dirección*/
        if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                && (piezas[posicionPiezaX - 2][posicionPiezaY + 1].color == 0
                || piezas[posicionPiezaX - 2][posicionPiezaY + 1].color != turno)) {
            piezaTemporal = piezas[posicionPiezaX -= 2][posicionPiezaY += 1];
        }
    }

    private void verificarCuartoCamino(byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                       int nuevaPosicionY, Pieza[][] piezas, Pieza piezaTemporal) {
       /* Condición que verifica la posición deseada de la pieza hacia (x-1)(y+2). Si se cumple,
       entonces la pieza se mueve una casilla en dicha dirección*/
        if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                && (piezas[posicionPiezaX - 1][posicionPiezaY + 2].color == 0
                || piezas[posicionPiezaX - 1][posicionPiezaY + 2].color != turno)) {
            piezaTemporal = piezas[posicionPiezaX -= 1][posicionPiezaY += 2];
        }
    }

    private void verificarQuintoCamino(byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                       int nuevaPosicionY, Pieza[][] piezas, Pieza piezaTemporal) {
       /* Condición que verifica la posición deseada de la pieza hacia (x+1)(y+2). Si se cumple,
       entonces la pieza se mueve una casilla en dicha dirección*/
        if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                && (piezas[posicionPiezaX + 1][posicionPiezaY + 2].color == 0
                || piezas[posicionPiezaX + 1][posicionPiezaY + 2].color != turno)) {
            piezaTemporal = piezas[posicionPiezaX += 1][posicionPiezaY += 2];
        }
    }

    private void verificarSextoCamino(byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                      int nuevaPosicionY, Pieza[][] piezas, Pieza piezaTemporal) {
       /* Condición que verifica la posición deseada de la pieza hacia (x+2)(y+1). Si se cumple,
       entonces la pieza se mueve una casilla en dicha dirección*/
        if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                && (piezas[posicionPiezaX + 2][posicionPiezaY + 1].color == 0
                || piezas[posicionPiezaX + 2][posicionPiezaY + 1].color != turno)) {
            piezaTemporal = piezas[posicionPiezaX += 2][posicionPiezaY += 1];
        }
    }

    private void verificarSeptimoCamino(byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza piezaTemporal) {
       /* Condición que verifica la posición deseada de la pieza hacia (x+2)(y-1). Si se cumple,
       entonces la pieza se mueve una casilla en dicha dirección*/
        if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                && (piezas[posicionPiezaX + 2][posicionPiezaY - 1].color == 0
                || piezas[posicionPiezaX + 2][posicionPiezaY - 1].color != turno)) {
            piezaTemporal = piezas[posicionPiezaX += 2][posicionPiezaY -= 1];
        }
    }

    private void verificarOctavoCamino(byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                       int nuevaPosicionY, Pieza[][] piezas, Pieza piezaTemporal) {
       /* Condición que verifica la posición deseada de la pieza hacia (x+1)(y-2). Si se cumple,
       entonces la pieza se mueve una casilla en dicha dirección*/
        if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                && (piezas[posicionPiezaX + 1][posicionPiezaY - 2].color == 0
                || piezas[posicionPiezaX + 1][posicionPiezaY - 2].color != turno)) {
            piezaTemporal = piezas[posicionPiezaX += 1][posicionPiezaY -= 2];
        }
    }
}