import java.util.ArrayList;

public class Torre extends Pieza{
    public Torre(int simbolo, int color)
    {
        super(simbolo, color);
    }

    public boolean moverANuevaPosicion (int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX,
                                        int nuevaPosicionY, Pieza[][] piezas, Pieza variableNuevaPosicionTemporal, ArrayList<String> piezasMuertas)
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
                    if ((temporalTorre.color != turno && temporalTorre.color != 0) && temporalTorre != piezas[nuevaPosicionX][nuevaPosicionY])
                    {
                        System.out.println("Esta torre no puede seguir este camino porque está siendo bloqueada por una pieza enemiga.");
                        return false;
                    }
                }
                // Abajo
                if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY == 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY].color == 0
                        || piezas[posicionPiezaX + 1][posicionPiezaY].color != turno)) {
                    temporalTorre = piezas[posicionPiezaX += 1][posicionPiezaY];
                    if ((temporalTorre.color != turno && temporalTorre.color != 0) && temporalTorre != piezas[nuevaPosicionX][nuevaPosicionY])
                    {
                        System.out.println("Esta torre no puede seguir este camino porque está siendo bloqueada por una pieza enemiga.");
                        return false;
                    }
                }
                // Derecha
                if ((posicionPiezaX - nuevaPosicionX == 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX][posicionPiezaY + 1].color == 0
                        || piezas[posicionPiezaX][posicionPiezaY + 1].color != turno)) {
                    temporalTorre = piezas[posicionPiezaX][posicionPiezaY += 1];
                    if ((temporalTorre.color != turno && temporalTorre.color != 0) && temporalTorre != piezas[nuevaPosicionX][nuevaPosicionY])
                    {
                        System.out.println("Esta torre no puede seguir este camino porque está siendo bloqueada por una pieza enemiga.");
                        return false;
                    }
                }
                // Izquierda
                if ((posicionPiezaX - nuevaPosicionX == 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX][posicionPiezaY - 1].color == 0
                        || piezas[posicionPiezaX][posicionPiezaY - 1].color != turno)) {
                    temporalTorre = piezas[posicionPiezaX][posicionPiezaY -= 1];
                    if ((temporalTorre.color != turno && temporalTorre.color != 0) && temporalTorre != piezas[nuevaPosicionX][nuevaPosicionY])
                    {
                        System.out.println("Esta torre no puede seguir este camino porque está siendo bloqueada por una pieza enemiga.");
                        return false;
                    }
                }
//                if ((posicionPiezaX == nuevaPosicionX || posicionPiezaY != nuevaPosicionY)
//                        && (posicionPiezaX != nuevaPosicionX || posicionPiezaY == nuevaPosicionY))
//                {
//                    // Es para evitar que no entre en los otros if y forme un bucle
//                    break;
//                }
                if (temporalTorre.color == turno && temporalTorre != piezas[nuevaPosicionX][nuevaPosicionY])
                {
                    System.out.println("Esta torre no puede seguir este camino porque está siendo bloqueada por una pieza aliada.");
                    return false;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("El objetivo no es alcanzable para la torre. (out of bounds)");
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

        System.out.println("El objetivo no es alcanzable para la torre.");

        return false;
    }
}
