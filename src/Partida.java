public class Partida {
    // 1 == Blanco, 2 == Negro
    private int turno = 1;
    private Tablero tablero;

    public Partida()
    {
        iniciarPartida();
    }

    public void iniciarPartida()
    {
        System.out.println("Blanco");
        this.tablero = new Tablero();
    }

    public void cambiarTurno(int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX, int nuevaPosicionY)
    {
        /*if (turno == 1)
        {
            System.out.println("Blanco");
        } else if (turno == 2) {
            System.out.println("Negro");
        }*/

        // Si se cometió un error, cancela el turno y el jugador vuelve a repetir.
        if (tablero.moverPieza(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY))
        {
            if(turno == 1)
                System.out.println("Blanco");
            if(turno == 2)
                System.out.println("Negro");
            return;
        }
        if (turno == 1)
        {
            System.out.println("Negro");
            turno = 2;
        } else if (turno == 2)
        {
            System.out.println("Blanco");
            turno = 1;
        }
    }

    public void terminarPartida()
    {

    }
}
