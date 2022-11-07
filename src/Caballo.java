import java.util.ArrayList;
import java.util.Objects;

public class Caballo extends Pieza {
    public Caballo(int simbolo, int color)
    {
        super(simbolo, color);
    }

    public boolean moverANuevaPosicion (int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, ArrayList<String> piezasMuertas)
    {
        try {
                    /* Condición que verifica la posición deseada de la pieza hacia (x-1)(y-2). Si se cumple,
                    entonces la pieza se mueve una casilla en dicha dirección*/
            if (piezas[posicionPiezaX - 1][posicionPiezaY - 2] == piezas [nuevaPosicionX][nuevaPosicionY]
                    && (piezas[posicionPiezaX - 1][posicionPiezaY - 2].color == 0
                    || piezas[posicionPiezaX - 1][posicionPiezaY - 2].color != turno)) {

                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas, variableNuevaPosicionTemporal, piezasMuertas);

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

                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas, variableNuevaPosicionTemporal, piezasMuertas);
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

                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas, variableNuevaPosicionTemporal, piezasMuertas);
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

                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas, variableNuevaPosicionTemporal, piezasMuertas);
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

                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas, variableNuevaPosicionTemporal, piezasMuertas);
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

                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas, variableNuevaPosicionTemporal, piezasMuertas);
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

                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas, variableNuevaPosicionTemporal, piezasMuertas);
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

                return valorarEspacioEnemigo(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas, variableNuevaPosicionTemporal, piezasMuertas);
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored)
        {
        }

        System.out.println("El objetivo no se encuentra en el rango del caballo.");

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

    @Override
    protected void validarJaque(int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                   int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal,
                                   ArrayList<String> piezasMuertas) {
        try {
            /* Condición que verifica si el rey enemigo se encuentra en (x-1)(y-2). Si se cumple,
            entonces el juego entra en jaque para el oponente.*/
            if ((turno == 1 && Objects.equals(piezas[nuevaPosicionX - 1][nuevaPosicionY - 2].getValor(), "\u265A")) ||
                (turno == 2 && Objects.equals(piezas[nuevaPosicionX - 1][nuevaPosicionY - 2].getValor(), "\u2654")))
            {
                Partida.esJaque = true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {

        }
        try {
            /* Condición que verifica si el rey enemigo se encuentra en (x-2)(y-1). Si se cumple,
            entonces el juego entra en jaque para el oponente.*/
            if ((turno == 1 && Objects.equals(piezas[nuevaPosicionX - 2][nuevaPosicionY - 1].getValor(), "\u265A")) ||
                (turno == 2 && Objects.equals(piezas[nuevaPosicionX - 2][nuevaPosicionY - 1].getValor(), "\u2654")))
            {
                Partida.esJaque = true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {

        }
        try {
            /* Condición que verifica si el rey enemigo se encuentra en (x-2)(y+1). Si se cumple,
            entonces el juego entra en jaque para el oponente.*/
            if ((turno == 1 && Objects.equals(piezas[nuevaPosicionX - 2][nuevaPosicionY + 1].getValor(), "\u265A")) ||
                    (turno == 2 && Objects.equals(piezas[nuevaPosicionX - 2][nuevaPosicionY + 1].getValor(), "\u2654")))
            {
                Partida.esJaque = true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {

        }
        try {
            /* Condición que verifica si el rey enemigo se encuentra en (x-1)(y+2). Si se cumple,
            entonces el juego entra en jaque para el oponente.*/
            if ((turno == 1 && Objects.equals(piezas[nuevaPosicionX - 1][nuevaPosicionY + 2].getValor(), "\u265A")) ||
                    (turno == 2 && Objects.equals(piezas[nuevaPosicionX - 1][nuevaPosicionY + 2].getValor(), "\u2654")))
            {
                Partida.esJaque = true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {

        }
        try {
            /* Condición que verifica si el rey enemigo se encuentra en (x+2)(y+1). Si se cumple,
            entonces el juego entra en jaque para el oponente.*/
            if ((turno == 1 && Objects.equals(piezas[nuevaPosicionX + 2][nuevaPosicionY + 1].getValor(), "\u265A")) ||
                    (turno == 2 && Objects.equals(piezas[nuevaPosicionX + 2][nuevaPosicionY + 1].getValor(), "\u2654")))
            {
                Partida.esJaque = true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {

        }
        try {
            /* Condición que verifica si el rey enemigo se encuentra en (x+1)(y+2). Si se cumple,
            entonces el juego entra en jaque para el oponente.*/
            if ((turno == 1 && Objects.equals(piezas[nuevaPosicionX + 1][nuevaPosicionY + 2].getValor(), "\u265A")) ||
                    (turno == 2 && Objects.equals(piezas[nuevaPosicionX + 1][nuevaPosicionY + 2].getValor(), "\u2654")))
            {
                Partida.esJaque = true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {

        }
        try {
            /* Condición que verifica si el rey enemigo se encuentra en (x+2)(y-1). Si se cumple,
            entonces el juego entra en jaque para el oponente.*/
            if ((turno == 1 && Objects.equals(piezas[nuevaPosicionX + 2][nuevaPosicionY - 1].getValor(), "\u265A")) ||
                    (turno == 2 && Objects.equals(piezas[nuevaPosicionX + 2][nuevaPosicionY - 1].getValor(), "\u2654")))
            {
                Partida.esJaque = true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {

        }
        try {
            /* Condición que verifica si el rey enemigo se encuentra en (x-1)(y+2). Si se cumple,
            entonces el juego entra en jaque para el oponente.*/
            if ((turno == 1 && Objects.equals(piezas[nuevaPosicionX - 1][nuevaPosicionY + 2].getValor(), "\u265A")) ||
                    (turno == 2 && Objects.equals(piezas[nuevaPosicionX - 1][nuevaPosicionY + 2].getValor(), "\u2654")))
            {
                Partida.esJaque = true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {

        }
    }
}