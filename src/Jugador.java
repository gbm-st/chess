public class Jugador
{
    public Pieza[] piezasJugador;

    public boolean esJaque;

    public Tablero tablero;

    byte color;

    public Jugador(byte turno, Tablero tablero)
    {
        this.tablero = tablero;
        color = turno;
        piezasJugador = new Pieza[16];
        inicializarPiezas(turno);
    }

    private void inicializarPiezas(byte turno)
    {
        if (turno == 1)
        {

            //Piezas de la fila 1
            piezasJugador[0] = new Torre( 3, 1, this);
            piezasJugador[1] = new Caballo( 5, 1, this);
            piezasJugador[2] = new Alfil( 4, 1, this);
            piezasJugador[3] = new Reina( 2, 1, this);
            piezasJugador[4] = new Rey( 1, 1, this);
            piezasJugador[5] = new Alfil( 4, 1, this);
            piezasJugador[6] = new Caballo( 5, 1, this);
            piezasJugador[7] = new Torre( 3, 1, this);

            //*************BLANCOS*****************
            //Piezas de la fila 2
            for(int x = 8; x < 16; x++) {
                piezasJugador[x] = new Peon(6, 1, this);
            }

        } else if (turno == 2)
        {
            //*************NEGROS*****************
            //Piezas de la fila 8
            piezasJugador[0] = new Torre( 9, 2, this);
            piezasJugador[1] = new Caballo( 11, 2, this);
            piezasJugador[2] = new Alfil( 10, 2, this);
            piezasJugador[3] = new Reina(8, 2, this);
            piezasJugador[4] = new Rey( 7, 2, this);
            piezasJugador[5] = new Alfil( 10, 2, this);
            piezasJugador[6] = new Caballo( 11, 2, this);
            piezasJugador[7] = new Torre( 9, 2, this);

            //Piezas de la fila 7
            for(int x = 8; x < 16; x++) {
                piezasJugador[x] = new Peon(12, 2, this);
            }
        }
    }

    public Pieza[] obtenerPiezasJugador()
    {
        return piezasJugador;
    }

    public boolean moverPieza(byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX, int nuevaPosicionY, Pieza[][] piezas)
    {
        boolean resultado;

        if(!(piezas[posicionPiezaX][posicionPiezaY].validacionBasica(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas[nuevaPosicionX][nuevaPosicionY])))
        {
            return false;
        }

        // Mandar a llamar el método que contenga las reglas de la pieza y
        // verificar que las reglas se cumplan (ej. no te puedes saltar piezas excepto caballo,
        // no puedes ir adelante como alfil o diagonal como torre, etc.)

        boolean valorEjecucion = piezas[posicionPiezaX][posicionPiezaY].moverANuevaPosicion(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX,
                nuevaPosicionY, piezas, piezas[nuevaPosicionX][nuevaPosicionY], tablero);

        if (valorEjecucion && (piezas[nuevaPosicionX][nuevaPosicionY].color != turno && piezas[nuevaPosicionX][nuevaPosicionY].color != 0))
        {
            resultado = atacarPieza(piezas, nuevaPosicionX, nuevaPosicionY, posicionPiezaX, posicionPiezaY);

            piezas[nuevaPosicionX][nuevaPosicionY].estaJaqueando(turno, piezas, tablero);

            return resultado;
        } else if (valorEjecucion && (piezas[nuevaPosicionX][nuevaPosicionY].color == 0)) {
            resultado = cambiarPosicionPieza(piezas, nuevaPosicionX, nuevaPosicionY, posicionPiezaX, posicionPiezaY);

            piezas[nuevaPosicionX][nuevaPosicionY].estaJaqueando(turno, piezas, tablero);

            return resultado;
        }

        return valorEjecucion;
    }

    public boolean cambiarPosicionPieza (Pieza[][] piezas, int nuevaPosicionX, int nuevaPosicionY,
                                         int posicionPiezaX, int posicionPiezaY)
    {
        Pieza nuevaPosicion = piezas[nuevaPosicionX][nuevaPosicionY];
        Pieza posicionOriginal = piezas[posicionPiezaX][posicionPiezaY];

        piezas[nuevaPosicionX][nuevaPosicionY]=posicionOriginal;
        piezas[posicionPiezaX][posicionPiezaY]=nuevaPosicion;

        piezas[nuevaPosicionX][nuevaPosicionY].asignarCoordenadas(nuevaPosicionX, nuevaPosicionY);
        piezas[posicionPiezaX][posicionPiezaY].asignarCoordenadas(posicionPiezaX, posicionPiezaY);

        return true;
    }

    public boolean atacarPieza (Pieza[][] piezas, int nuevaPosicionX, int nuevaPosicionY,
                                int posicionPiezaX, int posicionPiezaY)
    {
        Pieza piezaQueSeVaAMover = piezas[posicionPiezaX][posicionPiezaY];
        Pieza piezaEliminada = piezas[nuevaPosicionX][nuevaPosicionY];

        piezas[nuevaPosicionX][nuevaPosicionY]=piezaQueSeVaAMover;
        piezaEliminada.resetearPieza();
        tablero.eliminarPiezaJugador(piezaEliminada);
        piezas[posicionPiezaX][posicionPiezaY]=piezaEliminada;

        piezas[nuevaPosicionX][nuevaPosicionY].asignarCoordenadas(nuevaPosicionX, nuevaPosicionY);
        piezas[posicionPiezaX][posicionPiezaY].asignarCoordenadas(posicionPiezaX, posicionPiezaY);

        return true;
    }
}
