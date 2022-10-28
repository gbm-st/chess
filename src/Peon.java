import java.util.ArrayList;

public class Peon extends Pieza {
    boolean primerMovimiento = true;
    public Peon(int simbolo, int color)
    {
        super(simbolo, color);
    }

    public boolean moverANuevaPosicion (int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, ArrayList<String> piezasMuertas)
    {
        if (primerMovimiento)
        {
            if(turno == 1)
            {
                if((nuevaPosicionX - posicionPiezaX) > -3
                        && (posicionPiezaY - nuevaPosicionY == 0)
                        && piezas[nuevaPosicionX][nuevaPosicionY].color == 0)
                {
                    piezas[nuevaPosicionX][nuevaPosicionY]=this;
                    piezas[posicionPiezaX][posicionPiezaY]=variableNuevaPosicionTemporal;

                    primerMovimiento = false;
                    return false;
                }
                else if ((nuevaPosicionX - posicionPiezaX) > -3
                        && (posicionPiezaY - nuevaPosicionY <= 1 || posicionPiezaY - nuevaPosicionY >= -1)
                        && (posicionPiezaY - nuevaPosicionY != 0)
                        && piezas[nuevaPosicionX][nuevaPosicionY].color == 2)
                {
                    piezas[nuevaPosicionX][nuevaPosicionY]=this;
                    piezasMuertas.add(variableNuevaPosicionTemporal.valor);
                    resetearPieza(variableNuevaPosicionTemporal);
                    piezas[posicionPiezaX][posicionPiezaY]=variableNuevaPosicionTemporal;

                    primerMovimiento = false;
                    return false;
                }
            }
            else if (turno == 2)
            {
                if((nuevaPosicionX - posicionPiezaX) < 3
                        && (posicionPiezaY - nuevaPosicionY == 0)
                        && piezas[nuevaPosicionX][nuevaPosicionY].color == 0)
                {
                    piezas[nuevaPosicionX][nuevaPosicionY]=this;
                    piezas[posicionPiezaX][posicionPiezaY]=variableNuevaPosicionTemporal;

                    primerMovimiento = false;
                    return false;
                }
                else if ((nuevaPosicionX - posicionPiezaX) < 3
                        && (posicionPiezaY - nuevaPosicionY <= 1 || posicionPiezaY - nuevaPosicionY >= -1)
                        && (posicionPiezaY - nuevaPosicionY != 0)
                        && piezas[nuevaPosicionX][nuevaPosicionY].color == 1)
                {
                    piezas[nuevaPosicionX][nuevaPosicionY]=this;
                    piezasMuertas.add(variableNuevaPosicionTemporal.valor);
                    resetearPieza(variableNuevaPosicionTemporal);
                    piezas[posicionPiezaX][posicionPiezaY]=variableNuevaPosicionTemporal;

                    primerMovimiento = false;
                    return false;
                }
            }
        }
        else
        {
            if(turno == 1)
            {
                if((nuevaPosicionX - posicionPiezaX) > -2
                        && (posicionPiezaY - nuevaPosicionY == 0)
                        && piezas[nuevaPosicionX][nuevaPosicionY].color == 0)
                {
                    piezas[nuevaPosicionX][nuevaPosicionY]=this;
                    piezas[posicionPiezaX][posicionPiezaY]=variableNuevaPosicionTemporal;
                    return false;
                }
                else if ((nuevaPosicionX - posicionPiezaX) > -2
                        && (posicionPiezaY - nuevaPosicionY <= 1 || posicionPiezaY - nuevaPosicionY >= -1)
                        && (posicionPiezaY - nuevaPosicionY != 0)
                        && piezas[nuevaPosicionX][nuevaPosicionY].color == 2)
                {
                    piezas[nuevaPosicionX][nuevaPosicionY]=this;
                    piezasMuertas.add(variableNuevaPosicionTemporal.valor);
                    resetearPieza(variableNuevaPosicionTemporal);
                    piezas[posicionPiezaX][posicionPiezaY]=variableNuevaPosicionTemporal;
                    return false;
                }
            }
            else if (turno == 2)
            {
                if((nuevaPosicionX - posicionPiezaX) < 2
                        && (posicionPiezaY - nuevaPosicionY == 0)
                        && piezas[nuevaPosicionX][nuevaPosicionY].color == 0)
                {
                    piezas[nuevaPosicionX][nuevaPosicionY]=this;
                    piezas[posicionPiezaX][posicionPiezaY]=variableNuevaPosicionTemporal;
                    return false;
                }
                else if ((nuevaPosicionX - posicionPiezaX) < 2
                        && (posicionPiezaY - nuevaPosicionY <= 1 || posicionPiezaY - nuevaPosicionY >= -1)
                        && (posicionPiezaY - nuevaPosicionY != 0)
                        && piezas[nuevaPosicionX][nuevaPosicionY].color == 1)
                {
                    piezas[nuevaPosicionX][nuevaPosicionY]=this;
                    piezasMuertas.add(variableNuevaPosicionTemporal.valor);
                    resetearPieza(variableNuevaPosicionTemporal);
                    piezas[posicionPiezaX][posicionPiezaY]=variableNuevaPosicionTemporal;
                    return false;
                }
            }
        }

        System.out.println("No se pudo mover el peón a esta posición.");
        return true;
    }
}
