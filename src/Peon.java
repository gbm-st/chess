import java.util.ArrayList;

public class Peon extends Pieza
{
    int distanciaMovimiento = 3;
    public Peon(int simbolo, int color)
    {
        super(simbolo, color);
    }

    public boolean moverANuevaPosicion (byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal)
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
}
