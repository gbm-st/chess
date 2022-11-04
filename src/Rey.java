import java.util.ArrayList;

public class Rey extends Pieza{
    public Rey(int simbolo, int color)
    {
        super(simbolo, color);
    }

    public boolean moverANuevaPosicion (int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, ArrayList<String> piezasMuertas) {

        try {
            /* Condición que verifica la posición deseada de la pieza hacia (x-1)(y-1). Si se cumple,
            entonces la pieza se mueve una casilla en dicha dirección*/
            if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                    && (piezas[posicionPiezaX - 1][posicionPiezaY - 1].color == 0
                    || piezas[posicionPiezaX - 1][posicionPiezaY - 1].color != turno)) {
                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY,
                        piezas, variableNuevaPosicionTemporal, piezasMuertas);
            }
            /* Condición que verifica la posición deseada de la pieza hacia (x-1)(y). Si se cumple,
            entonces la pieza se mueve una casilla en dicha dirección*/
            if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY == 0)
                    && (piezas[posicionPiezaX - 1][posicionPiezaY].color == 0
                    || piezas[posicionPiezaX - 1][posicionPiezaY].color != turno)) {
                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY,
                        piezas, variableNuevaPosicionTemporal, piezasMuertas);
            }
            /* Condición que verifica la posición deseada de la pieza hacia (x-1)(y+1). Si se cumple,
            entonces la pieza se mueve una casilla en dicha dirección*/
            if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY < 0)
                    && (piezas[posicionPiezaX - 1][posicionPiezaY + 1].color == 0
                    || piezas[posicionPiezaX - 1][posicionPiezaY + 1].color != turno)) {
                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY,
                        piezas, variableNuevaPosicionTemporal, piezasMuertas);
            }
            /* Condición que verifica la posición deseada de la pieza hacia (x)(y-1). Si se cumple,
            entonces la pieza se mueve una casilla en dicha dirección*/
            if ((posicionPiezaX - nuevaPosicionX == 0) && (posicionPiezaY - nuevaPosicionY > 0)
                    && (piezas[posicionPiezaX][posicionPiezaY - 1].color == 0
                    || piezas[posicionPiezaX][posicionPiezaY - 1].color != turno)) {
                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY,
                        piezas, variableNuevaPosicionTemporal, piezasMuertas);
            }
            /* Condición que verifica la posición deseada de la pieza hacia (x)(y+1). Si se cumple,
            entonces la pieza se mueve una casilla en dicha dirección*/
            if ((posicionPiezaX - nuevaPosicionX == 0) && (posicionPiezaY - nuevaPosicionY < 0)
                    && (piezas[posicionPiezaX][posicionPiezaY + 1].color == 0
                    || piezas[posicionPiezaX][posicionPiezaY + 1].color != turno)) {
                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY,
                        piezas, variableNuevaPosicionTemporal, piezasMuertas);
            }
            /* Condición que verifica la posición deseada de la pieza hacia (x+1)(y-1). Si se cumple,
            entonces la pieza se mueve una casilla en dicha dirección*/
            if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY > 0)
                    && (piezas[posicionPiezaX + 1][posicionPiezaY - 1].color == 0
                    || piezas[posicionPiezaX + 1][posicionPiezaY - 1].color != turno)) {
                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY,
                        piezas, variableNuevaPosicionTemporal, piezasMuertas);
            }
            /* Condición que verifica la posición deseada de la pieza hacia (x+1)(y). Si se cumple,
            entonces la pieza se mueve una casilla en dicha dirección*/
            if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY == 0)
                    && (piezas[posicionPiezaX + 1][posicionPiezaY].color == 0
                    || piezas[posicionPiezaX + 1][posicionPiezaY].color != turno)) {
                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY,
                        piezas, variableNuevaPosicionTemporal, piezasMuertas);
            }
            /* Condición que verifica la posición deseada de la pieza hacia (x+1)(y+1). Si se cumple,
            entonces la pieza se mueve una casilla en dicha dirección*/
            if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY < 0)
                    && (piezas[posicionPiezaX + 1][posicionPiezaY + 1].color == 0
                    || piezas[posicionPiezaX + 1][posicionPiezaY + 1].color != turno)) {
                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY,
                        piezas, variableNuevaPosicionTemporal, piezasMuertas);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        System.out.println("El objetivo no es alcanzable por la pieza. (out of bounds)");

        return false;
    }

    private boolean valorarEspacioEnemigo(int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                          int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, ArrayList<String> piezasMuertas)
    {
        if (turno == 0){
            piezas[nuevaPosicionX][nuevaPosicionY]=this;
            piezas[posicionPiezaX][posicionPiezaY]=variableNuevaPosicionTemporal;
            return true;
        }
        else if (turno != piezas[nuevaPosicionX][nuevaPosicionY].color)
        {
            piezas[nuevaPosicionX][nuevaPosicionY]=this;
            piezasMuertas.add(variableNuevaPosicionTemporal.valor);
            resetearPieza(variableNuevaPosicionTemporal);
            piezas[posicionPiezaX][posicionPiezaY]=variableNuevaPosicionTemporal;
            return true;
        }
        else
        {
            return false;
        }
    }
}