public class Torre extends Pieza{
    public Torre(int simbolo, int color)
    {
        super(simbolo, color);
    }

    public boolean moverANuevaPosicion (int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal)
    {
        piezas[nuevaPosicionX][nuevaPosicionY]=this;
        piezas[posicionPiezaX][posicionPiezaY]=variableNuevaPosicionTemporal;
        return true;
    }
}
