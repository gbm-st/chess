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

//        System.out.println( posicionPiezaX - nuevaPosicionX );
//        System.out.println( posicionPiezaY - nuevaPosicionY );
//        System.out.println(posicionPiezaX+1);
//        System.out.println(posicionPiezaY-1);

        try {
            while (temporalAlfil != piezas[nuevaPosicionX][nuevaPosicionY]) {
                if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY - 1].color == 0
                        || piezas[posicionPiezaX - 1][posicionPiezaY - 1].color != turno)) {
                    temporalAlfil = piezas[posicionPiezaX -= 1][posicionPiezaY -= 1];
                    if ((temporalAlfil.color != turno && temporalAlfil.color != 0) && temporalAlfil != piezas[nuevaPosicionX][nuevaPosicionY])
                    {
                        System.out.println("Esta pieza no puede seguir este camino porque está siendo bloqueada.");
                        return true;
                    }
                }
                if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY + 1].color == 0
                        || piezas[posicionPiezaX + 1][posicionPiezaY + 1].color != turno)) {
                    temporalAlfil = piezas[posicionPiezaX += 1][posicionPiezaY += 1];
                    if ((temporalAlfil.color != turno && temporalAlfil.color != 0) && temporalAlfil != piezas[nuevaPosicionX][nuevaPosicionY])
                    {
                        System.out.println("Esta pieza no puede seguir este camino porque está siendo bloqueada.");
                        return true;
                    }
                }
                if ((posicionPiezaX - nuevaPosicionX > 0) && (posicionPiezaY - nuevaPosicionY < 0)
                        && (piezas[posicionPiezaX - 1][posicionPiezaY + 1].color == 0
                        || piezas[posicionPiezaX - 1][posicionPiezaY + 1].color != turno)) {
                    temporalAlfil = piezas[posicionPiezaX -= 1][posicionPiezaY += 1];
                    if ((temporalAlfil.color != turno && temporalAlfil.color != 0) && temporalAlfil != piezas[nuevaPosicionX][nuevaPosicionY])
                    {
                        System.out.println("Esta pieza no puede seguir este camino porque está siendo bloqueada.");
                        return true;
                    }
                }
                if ((posicionPiezaX - nuevaPosicionX < 0) && (posicionPiezaY - nuevaPosicionY > 0)
                        && (piezas[posicionPiezaX + 1][posicionPiezaY - 1].color == 0
                        || piezas[posicionPiezaX + 1][posicionPiezaY - 1].color != turno)) {
                    temporalAlfil = piezas[posicionPiezaX += 1][posicionPiezaY -= 1];
                    if ((temporalAlfil.color != turno && temporalAlfil.color != 0) && temporalAlfil != piezas[nuevaPosicionX][nuevaPosicionY])
                    {
                        System.out.println("Esta pieza no puede seguir este camino porque está siendo bloqueada.");
                        return true;
                    }
                }
                if (posicionPiezaX == nuevaPosicionX && posicionPiezaY != nuevaPosicionY
                        || posicionPiezaX != nuevaPosicionX && posicionPiezaY == nuevaPosicionY)
                {
                    // Es para evitar que no entre en los otros if y forme un bucle
                    break;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("El objetivo no es alcanzable para el alfil.");
            return true;
        }

        if (piezas[posicionPiezaX][posicionPiezaY] == piezas[nuevaPosicionX][nuevaPosicionY])
        {
            piezas[nuevaPosicionX][nuevaPosicionY]=this;
            piezasMuertas.add(variableNuevaPosicionTemporal.valor);
            resetearPieza(variableNuevaPosicionTemporal);
            piezas[posicionOriginalX][posicionOriginalY]=variableNuevaPosicionTemporal;
            return false;
        }

        System.out.println("El objetivo no es alcanzable para el alfil.");

        return true;
    }
}
