import java.util.ArrayList;

public class Tablero {
    //Variable para el arreglo de las piezas
    final Pieza[][] piezas;

    public Jugador[] jugadores;

    public boolean JaqueMate;

    public Pieza reyBlanco;

    public Pieza reyNegro;

    // 1 == Blanco, 2 == Negro
    private byte turno = 1;

    //Variable para la leyenda del eje X
    private final String[] ejeX = {"( A )", "( B )", "( C )", "( D )",
            "( E )", "( F )", "( G )", "( H )"};
    //Variable para la leyenda del eje Y
    private final String[] ejeY = {"8", "7", "6", "5", "4", "3", "2", "1"};

    public Tablero() {
        piezas = new Pieza[8][8];

        inicializarTablero();
        imprimirTablero();
        System.out.println("Turno Blanco");
    }

    public Tablero(Tablero tableroOriginal) {
        piezas = new Pieza[8][8];

        Pieza[] piezasBlancas = new Pieza[16];

        Pieza[] piezasNegras = new Pieza[16];

        int x = 0;
        int y = 0;

        for(int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (tableroOriginal.piezas[i][j] instanceof Alfil)
                {
                    piezas[i][j] = new Alfil((Alfil) tableroOriginal.piezas[i][j]);
                }
                else if (tableroOriginal.piezas[i][j] instanceof Caballo)
                {
                    piezas[i][j] = new Caballo((Caballo) tableroOriginal.piezas[i][j]);
                }
                else if (tableroOriginal.piezas[i][j] instanceof Peon)
                {
                    Peon peon = new Peon((Peon) tableroOriginal.piezas[i][j]);
                    peon.darDistanciaMovimiento(((Peon) tableroOriginal.piezas[i][j]).obtenerDistanciaMovimiento());
                    piezas[i][j] = peon;
                }
                else if (tableroOriginal.piezas[i][j] instanceof Reina)
                {
                    piezas[i][j] = new Reina((Reina)tableroOriginal.piezas[i][j]);
                }
                else if (tableroOriginal.piezas[i][j] instanceof Rey)
                {
                    piezas[i][j] = new Rey((Rey) tableroOriginal.piezas[i][j]);
                }
                else if (tableroOriginal.piezas[i][j] instanceof Torre)
                {
                    piezas[i][j] = new Torre((Torre) tableroOriginal.piezas[i][j]);
                }
                else
                {
                    piezas[i][j] = new Pieza(tableroOriginal.piezas[i][j]);
                }
                if (piezas[i][j].color == 1)
                {
                    piezasBlancas[x] = piezas[i][j];
                    x++;
                }
                if (piezas[i][j].color == 2)
                {
                    piezasNegras[y] = piezas[i][j];
                    y++;
                }
                if (piezas[i][j].valor.equals("\u001b[37m\u2654\u001b[0m"))
                {
                    reyBlanco = piezas[i][j];
                }
                if (piezas[i][j].valor.equals("\u001b[31m\u265A\u001b[0m"))
                {
                    reyNegro = piezas[i][j];
                }
            }
        }

        jugadores = new Jugador[2];

        jugadores[0] = new Jugador((byte)1, this, tableroOriginal.jugadores[0].estaEnJaque, piezasBlancas);
        jugadores[1] = new Jugador((byte)2, this, tableroOriginal.jugadores[1].estaEnJaque, piezasNegras);

        this.JaqueMate = tableroOriginal.JaqueMate;

        this.turno = tableroOriginal.turno;
    }

    public Tablero copiarTablero()
    {
        Tablero nuevoTablero = new Tablero(this);
        // nuevoTablero.imprimirTablero();
        return nuevoTablero;
    }

    //Método para imprimir el Tablero
    public void imprimirTablero() {
        boolean esCasillaBlanca = false; //Variable para identificar si la siguiente casilla a imprimir es blanca
        for (int x = 0; x < 8; x++) {
            esCasillaBlanca = !esCasillaBlanca; //Cambio de color para la siguiente casilla a imprimir
            System.out.print("\n" + ejeY[x] + "\t");
            for (int y = 0; y < 8; y++) {
                String valor = piezas[x][y].getValor();
                String formato = piezas[x][y].getFormato();
                if(esCasillaBlanca){
                    System.out.print("\u001b[47m" + formato + "\u001b[0m"); //Imprime casilla blanca
                } else
                {
                    System.out.print("\u001b[48;5;58m" + formato + "\u001b[0m"); //Imprime casilla oscura
                }
                esCasillaBlanca = !esCasillaBlanca; //Cambio de color para la siguiente casilla a imprimir
            }
        }
        System.out.println("");
        System.out.print("\t");

        for (int x = 0; x < 8; x++) {
            System.out.print(ejeX[x]);
        }
        System.out.println();
    }

    //Método para definir el estado inicial del tablero
    public void inicializarTablero()
    {

        jugadores = new Jugador[2];

        jugadores[0] = new Jugador((byte)1, this);
        jugadores[1] = new Jugador((byte)2, this);

        Pieza[] piezasJugadorBlanco = jugadores[0].obtenerPiezasJugador();
        Pieza[] piezasJugadorNegro = jugadores[1].obtenerPiezasJugador();

        //*************NEGROS*****************
        //Piezas de la fila 8
        piezas[0][0] = piezasJugadorNegro[0];
        piezas[0][1] = piezasJugadorNegro[1];
        piezas[0][2] = piezasJugadorNegro[2];
        piezas[0][3] = piezasJugadorNegro[3];
        piezas[0][4] = piezasJugadorNegro[4];
        piezas[0][5] = piezasJugadorNegro[5];
        piezas[0][6] = piezasJugadorNegro[6];
        piezas[0][7] = piezasJugadorNegro[7];

        piezas[0][0].asignarCoordenadas(0, 0);
        piezas[0][1].asignarCoordenadas(0, 1);
        piezas[0][2].asignarCoordenadas(0, 2);
        piezas[0][3].asignarCoordenadas(0, 3);
        piezas[0][4].asignarCoordenadas(0, 4);
        piezas[0][5].asignarCoordenadas(0, 5);
        piezas[0][6].asignarCoordenadas(0, 6);
        piezas[0][7].asignarCoordenadas(0, 7);

        //Piezas de la fila 7
        for(int x = 0, y = 8; x < 8; x++, y++) {
            piezas[1][x] = piezasJugadorNegro[y];
            piezas[1][x].asignarCoordenadas(1, x);
        }

        //Espacios vacíos
        for(int x = 2; x < 6; x++){
            for(int y = 0; y < 8; y++){
                piezas[x][y] = new Pieza(0, 0, null);
                piezas[x][y].asignarCoordenadas(x, y);
            }
        }

        //*************BLANCOS*****************
        //Piezas de la fila 2
        for(int x = 0, y = 8; x < 8; x++, y++) {
            piezas[6][x] = piezasJugadorBlanco[y];
            piezas[6][x].asignarCoordenadas(6, x);
        }

        //Piezas de la fila 1
        piezas[7][0] = piezasJugadorBlanco[0];
        piezas[7][1] = piezasJugadorBlanco[1];
        piezas[7][2] = piezasJugadorBlanco[2];
        piezas[7][3] = piezasJugadorBlanco[3];
        piezas[7][4] = piezasJugadorBlanco[4];
        piezas[7][5] = piezasJugadorBlanco[5];
        piezas[7][6] = piezasJugadorBlanco[6];
        piezas[7][7] = piezasJugadorBlanco[7];

        piezas[7][0].asignarCoordenadas(7, 0);
        piezas[7][1].asignarCoordenadas(7, 1);
        piezas[7][2].asignarCoordenadas(7, 2);
        piezas[7][3].asignarCoordenadas(7, 3);
        piezas[7][4].asignarCoordenadas(7, 4);
        piezas[7][5].asignarCoordenadas(7, 5);
        piezas[7][6].asignarCoordenadas(7, 6);
        piezas[7][7].asignarCoordenadas(7, 7);
    }

    public void cambiarTurno(short posicionPiezaX, short posicionPiezaY, short nuevaPosicionX, short nuevaPosicionY)
    {
        if((jugadores[0].estaEnJaque || jugadores[1].estaEnJaque) && terminarPartida(turno))
        {
            JaqueMate = true;
            return;
        }
//        if(JaqueMate)
//        {
//            return;
//        }
        // Si se cometió un error, cancela el turno y el jugador vuelve a repetir.
        if (!(jugadores[turno - 1].moverPieza(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas)))
        {
//            if(terminarPartida(turno))
//            {
//                JaqueMate = true;
//                return;
//            }
            if(turno == 1)
            {
                imprimirTablero();
                System.out.println("Turno Blanco");
            }
            if(turno == 2)
            {
                imprimirTablero();
                System.out.println("Turno Negro");
            }
            return;
        } // Se cambia de color/turno
        if (turno == 1)
        {
            turno = 2;
            imprimirTablero();
            System.out.println("Turno Negro");
        } else if (turno == 2)
        {
            turno = 1;
            imprimirTablero();
            System.out.println("Turno Blanco");
        }
    }

    public void eliminarPiezaJugador (Pieza piezaEliminada)
    {
        for(int i = 0; i < 2; i++)
        {
            for (int j = 0; j < jugadores[i].piezasJugador.length; j++)
            {
                if (jugadores[i].piezasJugador[j] == piezaEliminada)
                {
                    jugadores[i].piezasJugador[j].piezaMuerta = true;
                }
            }
        }
    }

    public boolean terminarPartida(byte turno)
    {
        Tablero tableroFuturo = null;

        for(int i = 0; i<16; i++)
        {
            for (int j = 0; j<8; j++)
            {
                for (int k = 0; k<8; k++)
                {
                    tableroFuturo = copiarTablero();
                    // System.out.println(tableroFuturo.jugadores[turno-1].piezasJugador[i]);
                    // System.out.println("X: " + j + "Y: " + k);

//                    if (!tableroFuturo.reyBlanco.validacionBasica(turno, tableroFuturo.reyBlanco.obtenerCoordenadaX(), tableroFuturo.reyBlanco.obtenerCoordenadaY(), i, j, tableroFuturo.piezas[i][j]))
//                    {
//                        continue;
//                    }
                    try {
                        if(tableroFuturo.jugadores[turno-1].moverPieza(turno, (short)tableroFuturo.jugadores[turno-1].piezasJugador[i].obtenerCoordenadaX(), (short)tableroFuturo.jugadores[turno-1].piezasJugador[i].obtenerCoordenadaY(), (short)j, (short)k, tableroFuturo.piezas))
                        {
                            System.out.println("Todavia quedan movimientos disponibles para Jugador " + turno);
                            return false;
                        }
                    } catch(NullPointerException ignored)
                    {

                    }
//                    if (!tableroFuturo.reyBlanco.reyAliadoEstaEnJaque(turno, tableroFuturo.piezas, tableroFuturo))
//                    {
//                        System.out.println("Todavia quedan movimientos disponibles para Jugador " + turno);
//                        return true;
//                    }
                }
            }
        }
        if (turno == 1)
        {
            System.out.println("Ya no quedan movimientos disponibles. JAQUE MATE. GANÓ EL JUGADOR NEGRO");
        }
        else
        {
            System.out.println("Ya no quedan movimientos disponibles. JAQUE MATE. GANÓ EL JUGADOR BLANCO");
        }
        return true;
    }
}