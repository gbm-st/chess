import java.util.ArrayList;
import java.util.Objects;

public class Peon extends Pieza
{
    int distanciaMovimiento = 3;
    public Peon(int simbolo, int color, Jugador jugador)
    {
        super(simbolo, color, jugador);
    }

    public int obtenerDistanciaMovimieno()
    {
        return distanciaMovimiento;
    }

    public void darDistanciaMovimiento(int distancia)
    {
        distanciaMovimiento = distancia;
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

    public boolean reyAliadoEstaEnJaque(byte turno, Pieza[][] piezas, Tablero tablero)
    {
        Pieza[] piezasEnemigas;

        int distanciaMovimientoPeon = 2;

        if (jugador.color == 1)
        {
            piezasEnemigas = tablero.jugadores[1].piezasJugador;
        } else if (jugador.color == 2) {
            piezasEnemigas = tablero.jugadores[0].piezasJugador;
        }
        else {
            return false;
        }

        if (turno == 1)
        {
            turno = 2;
        }
        else
        {
            turno = 1;
        }

        for(Pieza piezaEnemiga: piezasEnemigas)
        {
            // System.out.println(piezaEnemiga);

            if (piezaEnemiga.valor == Pieza.simbolos[6] || piezaEnemiga.valor == Pieza.simbolos[12])
            {
                distanciaMovimientoPeon = ((Peon)piezaEnemiga).obtenerDistanciaMovimieno();
            }

            if (!piezaEnemiga.piezaMuerta && piezaEnemiga.estaJaqueando(turno, piezas, tablero))
            {
                System.out.println("No puedes moverte aqui porque estan jaqueando a alidado.");
                return true;
            }

            if (piezaEnemiga.valor == Pieza.simbolos[6] || piezaEnemiga.valor == Pieza.simbolos[12])
            {
                ((Peon)piezaEnemiga).darDistanciaMovimiento(distanciaMovimientoPeon);
            }
        }

        System.out.println("No se esta jaqueando a alidado.");
        return false;
    }

    public boolean estaJaqueando(byte turno, Pieza[][] piezas, Tablero tablero)
    {
        Pieza reyEnemigo = null;
        if(turno == 1 && turno != 0)
        {
            reyEnemigo = tablero.reyNegro;
        } else if (turno == 2 && turno != 0){
            reyEnemigo = tablero.reyBlanco;
        }

        boolean jaque = moverANuevaPosicion(turno, this.obtenerCoordenadaX(), this.obtenerCoordenadaY(), reyEnemigo.obtenerCoordenadaX(),
                reyEnemigo.obtenerCoordenadaY(), piezas, reyEnemigo, tablero);

        System.out.println("¿Es jaque? " + jaque);

        return jaque;
    }
}
