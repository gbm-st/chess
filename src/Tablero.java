import java.util.ArrayList;

public class Tablero {
    //Variable para el arreglo de las piezas
    private final Pieza[][] piezas;

    Jugador[] jugadores;

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

    //Método para imprimir el Tablero
    public void imprimirTablero() {
        for (int x = 0; x < 8; x++) {
            System.out.print("\n" + ejeY[x] + "\t");
            for (int y = 0; y < 8; y++) {
                String valor = piezas[x][y].getValor();
                String formato = piezas[x][y].getFormato();
                System.out.print(formato + "\t");
            }
        }
        System.out.println("");
        System.out.print("\t");

        for (int x = 0; x < 8; x++) {
            System.out.print(ejeX[x] + "\t");
        }
        System.out.println();
    }

    //Método para definir el estado inicial del tablero
    public void inicializarTablero(){

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

        //Piezas de la fila 7
        for(int x = 0, y = 8; x < 8; x++, y++) {
            piezas[1][x] = piezasJugadorNegro[y];
        }

        //Espacios vacíos
        for(int x = 2; x < 6; x++){
            for(int y = 0; y < 8; y++){
                piezas[x][y] = new Pieza(0, 0);
            }
        }

        //*************BLANCOS*****************
        //Piezas de la fila 2
        for(int x = 0, y = 8; x < 8; x++, y++) {
            piezas[6][x] = piezasJugadorBlanco[y];
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
    }

    public void cambiarTurno(int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX, int nuevaPosicionY)
    {
        // Si se cometió un error, cancela el turno y el jugador vuelve a repetir.
        if (!(jugadores[turno - 1].moverPieza(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY, piezas)))
        {
            if(turno == 1)
                System.out.println("Turno Blanco");
            if(turno == 2)
                System.out.println("Turno Negro");
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
                    jugadores[i].piezasJugador[j] = null;
                }
            }
        }
    }

    public void terminarPartida()
    {

    }
}