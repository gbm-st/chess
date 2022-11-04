import java.util.ArrayList;

public class Peon extends Pieza
{
    int distanciaMovimiento = 3;
    public Peon(int simbolo, int color)
    {
        super(simbolo, color);
    }

    public boolean moverANuevaPosicion (int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, ArrayList<String> piezasMuertas)
    {
        if (distanciaMovimiento == 3)
        {
            boolean resultado = movimientoTurno(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas, variableNuevaPosicionTemporal, piezasMuertas);
            distanciaMovimiento = 2;
            return resultado;
        }
        else
        {
            return movimientoTurno(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas, variableNuevaPosicionTemporal, piezasMuertas);
        }
    }

    private boolean movimientoTurno(int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                             int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, ArrayList<String> piezasMuertas)
    {
        if(turno == 1)
        {
            if((nuevaPosicionX - posicionPiezaX) > -distanciaMovimiento
                    && (posicionPiezaY - nuevaPosicionY == 0)
                    && piezas[nuevaPosicionX][nuevaPosicionY].color == 0)
            {
                return cambiarPosicionPieza(piezas, nuevaPosicionX, nuevaPosicionY, posicionPiezaX,
                        posicionPiezaY, variableNuevaPosicionTemporal);
            }
            else if ((nuevaPosicionX - posicionPiezaX) > -distanciaMovimiento
                    && (posicionPiezaY - nuevaPosicionY <= 1 || posicionPiezaY - nuevaPosicionY >= -1)
                    && (posicionPiezaY - nuevaPosicionY != 0)
                    && piezas[nuevaPosicionX][nuevaPosicionY].color == 2)
            {
                return atacarPieza(piezas, nuevaPosicionX, nuevaPosicionY, posicionPiezaX,
                        posicionPiezaY, variableNuevaPosicionTemporal, piezasMuertas);
            }
        }
        else if (turno == 2)
        {
            if((nuevaPosicionX - posicionPiezaX) < distanciaMovimiento
                    && (posicionPiezaY - nuevaPosicionY == 0)
                    && piezas[nuevaPosicionX][nuevaPosicionY].color == 0)
            {
                return cambiarPosicionPieza(piezas, nuevaPosicionX, nuevaPosicionY, posicionPiezaX,
                        posicionPiezaY, variableNuevaPosicionTemporal);
            }
            else if ((nuevaPosicionX - posicionPiezaX) < distanciaMovimiento
                    && (posicionPiezaY - nuevaPosicionY <= 1 || posicionPiezaY - nuevaPosicionY >= -1)
                    && (posicionPiezaY - nuevaPosicionY != 0)
                    && piezas[nuevaPosicionX][nuevaPosicionY].color == 1)
            {
                return atacarPieza(piezas, nuevaPosicionX, nuevaPosicionY, posicionPiezaX,
                        posicionPiezaY, variableNuevaPosicionTemporal, piezasMuertas);
            }
        }

        System.out.println("No se puede mover el peón a esta posición.");
        return false;
    }

    public boolean cambiarPosicionPieza (Pieza[][] piezas, int nuevaPosicionX, int nuevaPosicionY,
                                         int posicionPiezaX, int posicionPiezaY , Pieza variableNuevaPosicionTemporal)
    {
        piezas[nuevaPosicionX][nuevaPosicionY]=this;
        piezas[posicionPiezaX][posicionPiezaY]=variableNuevaPosicionTemporal;

        return true;
    }

    public boolean atacarPieza (Pieza[][] piezas, int nuevaPosicionX, int nuevaPosicionY,
                                int posicionPiezaX, int posicionPiezaY , Pieza variableNuevaPosicionTemporal,
                                ArrayList<String> piezasMuertas)
    {
        piezas[nuevaPosicionX][nuevaPosicionY]=this;
        piezasMuertas.add(variableNuevaPosicionTemporal.valor);
        resetearPieza(variableNuevaPosicionTemporal);
        piezas[posicionPiezaX][posicionPiezaY]=variableNuevaPosicionTemporal;

        return true;
    }
}
