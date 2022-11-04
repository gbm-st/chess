import java.util.ArrayList;

public class Alfil extends Pieza{
    public Alfil(int simbolo, int color)
    {
        super(simbolo, color);
    }

    public boolean moverANuevaPosicion (int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, ArrayList<String> piezasMuertas)
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
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalAlfil, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY - 1].color == turno)) {
                    System.out.println("Este alfil no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    return false;
                }
                // Abajo derecha
                if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY + 1].color == 0
                        || piezas[posicionPiezaX + 1][posicionPiezaY + 1].color != turno)) {
                    temporalAlfil = piezas[posicionPiezaX += 1][posicionPiezaY += 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalAlfil, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY + 1].color == turno)) {
                    System.out.println("Este alfil no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    return false;
                }
                // Arriba derecha
                if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY + 1].color == 0
                        || piezas[posicionPiezaX - 1][posicionPiezaY + 1].color != turno)) {
                    temporalAlfil = piezas[posicionPiezaX -= 1][posicionPiezaY += 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalAlfil, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY + 1].color == turno)) {
                    System.out.println("Este alfil no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    return false;
                }
                // Abajo Izquierda
                if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY - 1].color == 0
                        || piezas[posicionPiezaX + 1][posicionPiezaY - 1].color != turno)) {
                    temporalAlfil = piezas[posicionPiezaX += 1][posicionPiezaY -= 1];
                    if (!validarSiPiezaNoEsAlcanzable(turno, temporalAlfil, piezas, nuevaPosicionX, nuevaPosicionY))
                    {
                        return false;
                    }
                } else if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY - 1].color == turno)) {
                    System.out.println("Este alfil no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
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
            System.out.println("El objetivo no es alcanzable para el alfil. (out of bounds)");
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

        System.out.println("El objetivo no es alcanzable para el alfil.");

        return false;
    }

    public boolean validarSiPiezaNoEsAlcanzable(int turno, Pieza temporalAlfil, Pieza[][] piezas, int nuevaPosicionX, int nuevaPosicionY)
    {
        if ((temporalAlfil.color != turno && temporalAlfil.color != 0) && temporalAlfil != piezas[nuevaPosicionX][nuevaPosicionY])
        {
            System.out.println("Este alfil no puede seguir este camino porque está siendo bloqueada por una pieza enemiga.");
            return false;
        }
        return true;
    }
}
