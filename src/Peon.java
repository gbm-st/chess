import java.util.ArrayList;
import java.util.Objects;

public class Peon extends Pieza
{
    int distanciaMovimiento = 3;
    Jugador jugador;
    public Peon(int simbolo, int color, Jugador jugador)
    {
        super(simbolo, color, jugador);
    }

    public boolean moverANuevaPosicion (byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, Tablero tablero)
    {
        if (distanciaMovimiento == 3)
        {
            boolean resultado = movimientoTurno(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas, variableNuevaPosicionTemporal);
            distanciaMovimiento = 2;
            return resultado;
        }
        else
        {
            return movimientoTurno(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas, variableNuevaPosicionTemporal);
        }
    }

    private boolean movimientoTurno(byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                             int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal)
    {
        if(turno == 1)
        {
            if((nuevaPosicionX - posicionPiezaX) > -distanciaMovimiento
                    && (posicionPiezaY - nuevaPosicionY == 0)
                    && piezas[nuevaPosicionX][nuevaPosicionY].color == 0)
            {
                return true;
            }
            else if ((nuevaPosicionX - posicionPiezaX) > -distanciaMovimiento
                    && (posicionPiezaY - nuevaPosicionY <= 1 || posicionPiezaY - nuevaPosicionY >= -1)
                    && (posicionPiezaY - nuevaPosicionY != 0)
                    && piezas[nuevaPosicionX][nuevaPosicionY].color == 2)
            {
                return true;
            }
        }
        else if (turno == 2)
        {
            if((nuevaPosicionX - posicionPiezaX) < distanciaMovimiento
                    && (posicionPiezaY - nuevaPosicionY == 0)
                    && piezas[nuevaPosicionX][nuevaPosicionY].color == 0)
            {
                return true;
            }
            else if ((nuevaPosicionX - posicionPiezaX) < distanciaMovimiento
                    && (posicionPiezaY - nuevaPosicionY <= 1 || posicionPiezaY - nuevaPosicionY >= -1)
                    && (posicionPiezaY - nuevaPosicionY != 0)
                    && piezas[nuevaPosicionX][nuevaPosicionY].color == 1)
            {
                return true;
            }
        }

        System.out.println("No se puede mover el peón a esta posición.");
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
