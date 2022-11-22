import java.util.Objects;

public class Alfil extends Pieza{
    public Alfil(int simbolo, int color, Jugador jugador)
    {
        super(simbolo, color, jugador);
    }

    public Alfil(int simbolo, int color, Jugador jugador, int coordenadaX, int coordenadaY)
    {
        super(simbolo, color, jugador, coordenadaX, coordenadaY);
    }

    public Alfil(Alfil piezaOriginal){
        super(piezaOriginal);
    }

    public boolean moverANuevaPosicion (byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, Tablero tablero, boolean mostrarMensaje)
    {
        Pieza temporalAlfil = piezas[posicionPiezaX][posicionPiezaY];
        int posicionOriginalX = posicionPiezaX;
        int posicionOriginalY = posicionPiezaY;

        try {
            while (temporalAlfil != piezas[nuevaPosicionX][nuevaPosicionY]) {
                // Arriba izquierda
                if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY - 1].color == 0
                        || piezas[posicionPiezaX - 1][posicionPiezaY - 1].color != turno)) {
                    temporalAlfil = piezas[posicionPiezaX -= 1][posicionPiezaY -= 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalAlfil, piezas, nuevaPosicionX, nuevaPosicionY, mostrarMensaje))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY - 1].color == turno)) {
                    if (mostrarMensaje)
                    {
                        System.out.println("Este alfil no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    }
                    return false;
                }
                // Abajo derecha
                if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY + 1].color == 0
                        || piezas[posicionPiezaX + 1][posicionPiezaY + 1].color != turno)) {
                    temporalAlfil = piezas[posicionPiezaX += 1][posicionPiezaY += 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalAlfil, piezas, nuevaPosicionX, nuevaPosicionY, mostrarMensaje))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY + 1].color == turno)) {
                    if (mostrarMensaje)
                    {
                        System.out.println("Este alfil no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    }
                    return false;
                }
                // Arriba derecha
                if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY + 1].color == 0
                        || piezas[posicionPiezaX - 1][posicionPiezaY + 1].color != turno)) {
                    temporalAlfil = piezas[posicionPiezaX -= 1][posicionPiezaY += 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalAlfil, piezas, nuevaPosicionX, nuevaPosicionY, mostrarMensaje))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY + 1].color == turno)) {
                    if (mostrarMensaje)
                    {
                        System.out.println("Este alfil no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    }
                    return false;
                }
                // Abajo Izquierda
                if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY - 1].color == 0
                        || piezas[posicionPiezaX + 1][posicionPiezaY - 1].color != turno)) {
                    temporalAlfil = piezas[posicionPiezaX += 1][posicionPiezaY -= 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalAlfil, piezas, nuevaPosicionX, nuevaPosicionY, mostrarMensaje))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY - 1].color == turno)) {
                    if (mostrarMensaje)
                    {
                        System.out.println("Este alfil no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    }
                    return false;
                }
                if (posicionPiezaX == nuevaPosicionX && posicionPiezaY != nuevaPosicionY
                        || posicionPiezaX != nuevaPosicionX && posicionPiezaY == nuevaPosicionY)
                {
                    // Es para evitar que no entre en los otros if y forme un bucle
                    break;
                }
//                if (temporalAlfil.color == turno && temporalAlfil != piezas[nuevaPosicionX][nuevaPosicionY])
//                {
//                    System.out.println("Este alfil no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
//                    return false;
//                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            if (mostrarMensaje)
            {
                System.out.println("El objetivo no es alcanzable para el alfil. (out of bounds)");
            }
            return false;
        }

        if (piezas[posicionPiezaX][posicionPiezaY] == piezas[nuevaPosicionX][nuevaPosicionY])
        {
            return true;
        }

        if (mostrarMensaje)
        {
            System.out.println("El objetivo no es alcanzable para el alfil.");
        }

        return false;
    }

    public boolean validarSiPiezaNoEsAlcanzable(byte turno, Pieza temporalAlfil, Pieza[][] piezas, int nuevaPosicionX, int nuevaPosicionY, boolean mostrarMensaje)
    {
        if ((temporalAlfil.color != turno && temporalAlfil.color != 0) && temporalAlfil != piezas[nuevaPosicionX][nuevaPosicionY])
        {
            if (mostrarMensaje)
            {
                System.out.println("Este alfil no puede seguir este camino porque está siendo bloqueada por una pieza enemiga.");
            }
            return false;
        }
        return true;
    }

    public boolean estaJaqueando(byte turno, Pieza[][] piezas, Tablero tablero, boolean mostrarMensaje)
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
                reyEnemigo.obtenerCoordenadaY(), piezas, reyEnemigo, tablero, mostrarMensaje);

        if (mostrarMensaje)
        {
            System.out.println("¿Es jaque? " + jaque);
        }

        return jaque;
    }

    public boolean reyAliadoEstaEnJaque(byte turno, Pieza[][] piezas, Tablero tablero, boolean mostrarMensaje)
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
            try {
                if (piezaEnemiga.valor == Pieza.simbolos[6] || piezaEnemiga.valor == Pieza.simbolos[12])
                {
                    distanciaMovimientoPeon = ((Peon)piezaEnemiga).obtenerDistanciaMovimiento();
                }

                if (!piezaEnemiga.piezaMuerta && piezaEnemiga.estaJaqueando(turno, piezas, tablero, mostrarMensaje))
                {
                    if (mostrarMensaje)
                    {
                        System.out.println("No puedes moverte aquí porque están jaqueando a aliado.");
                    }
                    return true;
                }

                if (piezaEnemiga.valor == Pieza.simbolos[6] || piezaEnemiga.valor == Pieza.simbolos[12])
                {
                    ((Peon)piezaEnemiga).darDistanciaMovimiento(distanciaMovimientoPeon);
                }
            } catch (NullPointerException ignored)
            {

            }
        }

        if (mostrarMensaje)
        {
            System.out.println("No se esta jaqueando a aliado.");
        }
        return false;
    }
}
