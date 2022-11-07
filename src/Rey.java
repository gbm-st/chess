import java.util.ArrayList;
import java.util.Objects;

public class Rey extends Pieza{
    public Rey(int simbolo, int color, Jugador jugador)
    {
        super(simbolo, color, jugador);
    }

    public boolean moverANuevaPosicion (byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, Tablero tablero) {

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

    public boolean estaEnJaque()
    {
        return false;
    }

    public boolean estaJaqueando(byte turno, Pieza[][] piezas, Tablero tablero)
    {
        Pieza[] piezasJugador;
        Pieza reyEnemigo = null;
        if(turno == 1)
        {
            piezasJugador = tablero.jugadores[1].piezasJugador;
        } else {
            piezasJugador = tablero.jugadores[0].piezasJugador;
        }

        for (Pieza pieza: piezasJugador)
        {
            try {
                if (Objects.equals(pieza.valor, Pieza.simbolos[1]) || Objects.equals(pieza.valor, Pieza.simbolos[7]))
                {
                    reyEnemigo = pieza;
                    break;
                }
            }catch (NullPointerException ignored)
            {

            }
        }

        boolean jaque = moverANuevaPosicion(turno, this.obtenerCoordenadaX(), this.obtenerCoordenadaY(), reyEnemigo.obtenerCoordenadaX(),
                reyEnemigo.obtenerCoordenadaY(), piezas, reyEnemigo, tablero);

        System.out.println("¿Es jaque? " + jaque);

        return jaque;
    }
}