public class Jugador
{
    public Pieza[] piezasJugador;

    public boolean estaEnJaque;

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

            //*************BLANCOS*****************
            //Piezas de la fila 1
            piezasJugador[0] = new Torre( 3, 1, this);
            piezasJugador[1] = new Caballo( 5, 1, this);
            piezasJugador[2] = new Alfil( 4, 1, this);
            piezasJugador[3] = new Reina( 2, 1, this);
            piezasJugador[4] = new Rey( 1, 1, this);
            piezasJugador[5] = new Alfil( 4, 1, this);
            piezasJugador[6] = new Caballo( 5, 1, this);
            piezasJugador[7] = new Torre( 3, 1, this);

            tablero.reyBlanco = piezasJugador[4];

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

            tablero.reyNegro = piezasJugador[4];

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

    public boolean moverPieza(byte turno, short posicionPiezaX, short posicionPiezaY, short nuevaPosicionX, short nuevaPosicionY, Pieza[][] piezas)
    {
        Pieza piezaPosicionInicial = piezas[posicionPiezaX][posicionPiezaY];
        Pieza piezaEliminada;
        boolean resultado;

        // Validar que no se salga del tablero
        if(posicionPiezaX > 7 || posicionPiezaY > 7 || nuevaPosicionX > 7 || nuevaPosicionY > 7 ||
                posicionPiezaX < 0 || posicionPiezaY < 0 || nuevaPosicionX < 0 || nuevaPosicionY < 0)
        {
            System.out.println("No te puedes salir de los limites.");
            return false;
        }

        if(!(piezas[posicionPiezaX][posicionPiezaY].validacionBasica(turno, posicionPiezaX, posicionPiezaY,
                nuevaPosicionX, nuevaPosicionY, piezas[nuevaPosicionX][nuevaPosicionY])))
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
            piezaEliminada = atacarPieza(piezas, nuevaPosicionX, nuevaPosicionY, posicionPiezaX, posicionPiezaY);
            resultado = true;

            if (this == tablero.jugadores[0])
            {
                tablero.jugadores[1].estaEnJaque = piezas[nuevaPosicionX][nuevaPosicionY].estaJaqueando(turno, piezas, tablero);
            } else if (this == tablero.jugadores[1]) {
                tablero.jugadores[0].estaEnJaque = piezas[nuevaPosicionX][nuevaPosicionY].estaJaqueando(turno, piezas, tablero);
            }

            if (piezas[nuevaPosicionX][nuevaPosicionY].reyAliadoEstaEnJaque(turno, piezas, tablero))
            {
                revertirCambios(piezas, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezaPosicionInicial, piezaEliminada);
                tablero.imprimirTablero();
                return false;
            }

            return resultado;
        }
        else if (valorEjecucion && (piezas[nuevaPosicionX][nuevaPosicionY].color == 0))
        {
            piezaEliminada = cambiarPosicionPieza(piezas, nuevaPosicionX, nuevaPosicionY, posicionPiezaX, posicionPiezaY);
            resultado = true;

            if (this == tablero.jugadores[0])
            {
                tablero.jugadores[1].estaEnJaque = piezas[nuevaPosicionX][nuevaPosicionY].estaJaqueando(turno, piezas, tablero);
            } else if (this == tablero.jugadores[1]) {
                tablero.jugadores[0].estaEnJaque = piezas[nuevaPosicionX][nuevaPosicionY].estaJaqueando(turno, piezas, tablero);
            }

            if (piezas[nuevaPosicionX][nuevaPosicionY].reyAliadoEstaEnJaque(turno, piezas, tablero))
            {
                revertirCambios(piezas, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezaPosicionInicial, piezaEliminada);
                tablero.imprimirTablero();
                return false;
            }

            return resultado;
        }

        return valorEjecucion;
    }

    public Pieza cambiarPosicionPieza (Pieza[][] piezas, int nuevaPosicionX, int nuevaPosicionY,
                                         int posicionPiezaX, int posicionPiezaY)
    {
        Pieza posicionOriginal = piezas[posicionPiezaX][posicionPiezaY];
        Pieza nuevaPosicion = piezas[nuevaPosicionX][nuevaPosicionY];

        piezas[nuevaPosicionX][nuevaPosicionY]=posicionOriginal;
        piezas[posicionPiezaX][posicionPiezaY]=nuevaPosicion;

        piezas[nuevaPosicionX][nuevaPosicionY].asignarCoordenadas(nuevaPosicionX, nuevaPosicionY);
        piezas[posicionPiezaX][posicionPiezaY].asignarCoordenadas(posicionPiezaX, posicionPiezaY);

        return nuevaPosicion;
    }

    public Pieza atacarPieza (Pieza[][] piezas, int nuevaPosicionX, int nuevaPosicionY,
                                int posicionPiezaX, int posicionPiezaY)
    {
        Pieza piezaQueSeVaAMover = piezas[posicionPiezaX][posicionPiezaY];
        Pieza piezaEliminada = piezas[nuevaPosicionX][nuevaPosicionY];

        piezas[nuevaPosicionX][nuevaPosicionY]=piezaQueSeVaAMover;
        tablero.eliminarPiezaJugador(piezaEliminada);
        piezas[posicionPiezaX][posicionPiezaY]= new Pieza(0, 0, null);

        piezas[nuevaPosicionX][nuevaPosicionY].asignarCoordenadas(nuevaPosicionX, nuevaPosicionY);
        piezas[posicionPiezaX][posicionPiezaY].asignarCoordenadas(posicionPiezaX, posicionPiezaY);

        return piezaEliminada;
    }

    private void revertirCambios(Pieza[][] piezas, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX, int nuevaPosicionY, Pieza piezaPosicionInicial, Pieza piezaEliminada)
    {
        piezas[posicionPiezaX][posicionPiezaY]=piezaPosicionInicial;
        piezas[nuevaPosicionX][nuevaPosicionY]=piezaEliminada;

        piezaEliminada.piezaMuerta = false;
    }
}
