public class Partida {
    // 1 == Blanco, 2 == Negro
    public static boolean esJaque;
    private int turno = 1;
    private Tablero tablero;

    public Partida()
    {
        iniciarPartida();
    }

    public void iniciarPartida()
    {
        this.tablero = new Tablero();
        System.out.println("Turno Blanco");
    }

    public void cambiarTurno(int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX, int nuevaPosicionY)
    {
        // Si se cometió un error, cancela el turno y el jugador vuelve a repetir.
        if (!(tablero.realizarMovimiento(turno, posicionPiezaX, posicionPiezaY, nuevaPosicionX, nuevaPosicionY)))
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
            System.out.println("Turno Negro");
        } else if (turno == 2)
        {
            turno = 1;
            System.out.println("Turno Blanco");
        }
    }

    public void terminarPartida()
    {

    }
}
