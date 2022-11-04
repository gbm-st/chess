import java.util.ArrayList;

public class Reina extends Pieza{
    public int no;
    public Reina(int simbolo, int color)
    {
        super(simbolo, color);
    }

    public boolean moverANuevaPosicion (int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, ArrayList<String> piezasMuertas)
    {
        if (((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0))
                || ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY < 0))
                || ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY > 0))
                || ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY < 0)))
        {
            return movimientosAlfil(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX,
                    nuevaPosicionY, piezas, variableNuevaPosicionTemporal, piezasMuertas);
        }
        else {
            return movimientosTorre(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX,
                    nuevaPosicionY, piezas, variableNuevaPosicionTemporal, piezasMuertas);
        }
    }

    public boolean movimientosAlfil(int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                    int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, ArrayList<String> piezasMuertas)
    {
        Pieza temporalReina = piezas[posicionPiezaX][posicionPiezaY];
        int posicionOriginalX = posicionPiezaX;
        int posicionOriginalY = posicionPiezaY;

        try {
            while (temporalReina != piezas[nuevaPosicionX][nuevaPosicionY]) {

                // Arriba izquierda
                if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY - 1].color == 0
                        || piezas[posicionPiezaX - 1][posicionPiezaY - 1].color != turno)) {
                    temporalReina = piezas[posicionPiezaX -= 1][posicionPiezaY -= 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalReina, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY - 1].color == turno)) {
                    System.out.println("Esta reina no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    return false;
                }
                // Abajo derecha
                if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY + 1].color == 0
                        || piezas[posicionPiezaX + 1][posicionPiezaY + 1].color != turno)) {
                    temporalReina = piezas[posicionPiezaX += 1][posicionPiezaY += 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalReina, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY + 1].color == turno)) {
                    System.out.println("Esta reina no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    return false;
                }
                // Arriba derecha
                if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY + 1].color == 0
                        || piezas[posicionPiezaX - 1][posicionPiezaY + 1].color != turno)) {
                    temporalReina = piezas[posicionPiezaX -= 1][posicionPiezaY += 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalReina, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY + 1].color == turno)) {
                    System.out.println("Esta reina no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    return false;
                }
                // Abajo Izquierda
                if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY - 1].color == 0
                        || piezas[posicionPiezaX + 1][posicionPiezaY - 1].color != turno)) {
                    temporalReina = piezas[posicionPiezaX += 1][posicionPiezaY -= 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalReina, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY - 1].color == turno)) {
                    System.out.println("Esta reina no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
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
            System.out.println("El objetivo no es alcanzable para la reina. (out of bounds)");
            return false;
        }

        if (piezas[posicionPiezaX][posicionPiezaY] == piezas[nuevaPosicionX][nuevaPosicionY])
        {
            piezas[nuevaPosicionX][nuevaPosicionY]=this;
            piezasMuertas.add(variableNuevaPosicionTemporal.valor);
            resetearPieza(variableNuevaPosicionTemporal);
            piezas[posicionOriginalX][posicionOriginalY]=variableNuevaPosicionTemporal;
            return true;
        }

        System.out.println("El objetivo no es alcanzable para la reina.");

        return false;
    }

    public boolean movimientosTorre(int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                    int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, ArrayList<String> piezasMuertas)
    {
        Pieza temporalReina = piezas[posicionPiezaX][posicionPiezaY];
        int posicionOriginalX = posicionPiezaX;
        int posicionOriginalY = posicionPiezaY;

        try {
            while (temporalReina != piezas[nuevaPosicionX][nuevaPosicionY]) {
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
                    temporalReina = piezas[posicionPiezaX -= 1][posicionPiezaY];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalReina, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY == 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY].color == turno)) {
                    System.out.println("Esta reina no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    return false;
                }
                // Abajo
                if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY == 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY].color == 0
                        || piezas[posicionPiezaX + 1][posicionPiezaY].color != turno)) {
                    temporalReina = piezas[posicionPiezaX += 1][posicionPiezaY];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalReina, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY == 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY].color == turno)) {
                    System.out.println("Esta reina no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    return false;
                }
                // Derecha
                if ((posicionPiezaX - nuevaPosicionX == 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX][posicionPiezaY + 1].color == 0
                        || piezas[posicionPiezaX][posicionPiezaY + 1].color != turno)) {
                    temporalReina = piezas[posicionPiezaX][posicionPiezaY += 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalReina, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX == 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX][posicionPiezaY + 1].color == turno)) {
                    System.out.println("Esta reina no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    return false;
                }
                // Izquierda
                if ((posicionPiezaX - nuevaPosicionX == 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX][posicionPiezaY - 1].color == 0
                        || piezas[posicionPiezaX][posicionPiezaY - 1].color != turno)) {
                    temporalReina = piezas[posicionPiezaX][posicionPiezaY -= 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalReina, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX == 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX][posicionPiezaY - 1].color == turno)) {
                    System.out.println("Esta reina no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
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
            System.out.println("El objetivo no es alcanzable para la reina. (out of bounds)");
            return false;
        }

        if (piezas[posicionPiezaX][posicionPiezaY] == piezas[nuevaPosicionX][nuevaPosicionY])
        {
            piezas[nuevaPosicionX][nuevaPosicionY]=this;
            piezasMuertas.add(variableNuevaPosicionTemporal.valor);
            resetearPieza(variableNuevaPosicionTemporal);
            piezas[posicionOriginalX][posicionOriginalY]=variableNuevaPosicionTemporal;
            return true;
        }

        System.out.println("El objetivo no es alcanzable para la reina.");

        return false;
    }

    public boolean validarSiPiezaNoEsAlcanzable(int turno, Pieza temporalReina, Pieza[][] piezas, int nuevaPosicionX, int nuevaPosicionY)
    {
        if ((temporalReina.color != turno && temporalReina.color != 0) && temporalReina != piezas[nuevaPosicionX][nuevaPosicionY])
        {
            System.out.println("Esta reina no puede seguir este camino porque está siendo bloqueada por una pieza enemiga.");
            return false;
        }
        return true;
    }
}
