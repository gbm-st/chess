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
        this.tablero = new Tablero();
    }

    public void cambiarTurno(int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX, int nuevaPosicionY)
    {
        if (turno == 1)
        {
            System.out.println("Blanco");
        } else if (turno == 2) {
            System.out.println("Negro");
        }

        boolean validar = tablero.moverPieza(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY);

        // Si se cometió un error, cancela el turno y el jugador vuelve a repetir.
        if (validar)
        {
            return;
        }
        if (turno == 1)
        {
            turno = 2;
        } else if (turno == 2)
        {
            turno = 1;
        }
    }

    public void terminarPartida()
    {

    }
}
