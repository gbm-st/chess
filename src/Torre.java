import java.util.Objects;

public class Torre extends Pieza{
    public Torre(int simbolo, int color, Jugador jugador)
    {
        super(simbolo, color, jugador);
    }

    public Torre(Torre piezaOriginal) {
        super(piezaOriginal);
    }

    public boolean moverANuevaPosicion (byte turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, Tablero tablero)
    {
        Pieza temporalTorre = piezas[posicionPiezaX][posicionPiezaY];
        int posicionOriginalX = posicionPiezaX;
        int posicionOriginalY = posicionPiezaY;

//        System.out.println( posicionPiezaX - nuevaPosicionX );
//        System.out.println( posicionPiezaY - nuevaPosicionY );
//        System.out.println(posicionPiezaX+1);
//        System.out.println(posicionPiezaY-1);

        try {
            while (temporalTorre != piezas[nuevaPosicionX][nuevaPosicionY]) {
                if (((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0))
                        || ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY < 0))
                        || ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY > 0))
                        || ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY < 0)))
                {
                    System.out.println("Las torres no se pueden mover diagonalmente.");
                    return false;
                }
                // Arriba
                if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY == 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY].color == 0
                        || piezas[posicionPiezaX - 1][posicionPiezaY].color != turno)) {
                    temporalTorre = piezas[posicionPiezaX -= 1][posicionPiezaY];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalTorre, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY == 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY].color == turno)) {
                    System.out.println("Esta torre no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    return false;
                }
                // Abajo
                if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY == 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY].color == 0
                        || piezas[posicionPiezaX + 1][posicionPiezaY].color != turno)) {
                    temporalTorre = piezas[posicionPiezaX += 1][posicionPiezaY];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalTorre, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY == 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY].color == turno)) {
                    System.out.println("Esta torre no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    return false;
                }
                // Derecha
                if ((posicionPiezaX - nuevaPosicionX == 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX][posicionPiezaY + 1].color == 0
                        || piezas[posicionPiezaX][posicionPiezaY + 1].color != turno)) {
                    temporalTorre = piezas[posicionPiezaX][posicionPiezaY += 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalTorre, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX == 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX][posicionPiezaY + 1].color == turno)) {
                    System.out.println("Esta torre no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    return false;
                }
                // Izquierda
                if ((posicionPiezaX - nuevaPosicionX == 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX][posicionPiezaY - 1].color == 0
                        || piezas[posicionPiezaX][posicionPiezaY - 1].color != turno)) {
                    temporalTorre = piezas[posicionPiezaX][posicionPiezaY -= 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalTorre, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX == 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX][posicionPiezaY - 1].color == turno)) {
                    System.out.println("Esta torre no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    return false;
                }
//                if ((posicionPiezaX == nuevaPosicionX || posicionPiezaY != nuevaPosicionY)
//                        && (posicionPiezaX != nuevaPosicionX || posicionPiezaY == nuevaPosicionY))
//                {
//                    // Es para evitar que no entre en los otros if y forme un bucle
//                    break;
//                }
//                if (temporalTorre.color == turno && temporalTorre != piezas[nuevaPosicionX][nuevaPosicionY])
//                {
//                    System.out.println("Esta torre no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
//                    return false;
//                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("El objetivo no es alcanzable para la torre. (out of bounds)");
            return false;
        }

        if (piezas[posicionPiezaX][posicionPiezaY] == piezas[nuevaPosicionX][nuevaPosicionY])
        {
            return true;
        }

        System.out.println("El objetivo no es alcanzable para la torre.");

        return false;
    }

    public boolean validarSiPiezaNoEsAlcanzable(byte turno, Pieza temporalTorre, Pieza[][] piezas, int nuevaPosicionX, int nuevaPosicionY)
    {
        if ((temporalTorre.color != turno && temporalTorre.color != 0) && temporalTorre != piezas[nuevaPosicionX][nuevaPosicionY])
        {
            System.out.println("Esta torre no puede seguir este camino porque está siendo bloqueada por una pieza enemiga.");
            return false;
        }
        return true;
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
            try
            {
                if (piezaEnemiga.valor == Pieza.simbolos[6] || piezaEnemiga.valor == Pieza.simbolos[12])
                {
                    distanciaMovimientoPeon = ((Peon)piezaEnemiga).obtenerDistanciaMovimiento();
                }

                if (!piezaEnemiga.piezaMuerta && piezaEnemiga.estaJaqueando(turno, piezas, tablero))
                {
                    System.out.println("No puedes moverte aquí porque están jaqueando a aliado.");
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

        System.out.println("No se esta jaqueando a aliado.");
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
