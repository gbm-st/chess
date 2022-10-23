public class Tablero {
    //Variable para las dimensiones del tablero
    private final int dim;
    //Variable para el arreglo de las piezas
    private final Pieza[][] piezas;
    //Variable para la leyenda del eje X
    private final String[] ejeX = {"( A )", "( B )", "( C )", "( D )",
            "( E )", "( F )", "( G )", "( H )"};
    //Variable para la leyenda del eje Y
    private final String[] ejeY = {"8", "7", "6", "5", "4", "3", "2", "1"};

    public Tablero() {
        dim = 8;
        piezas = new Pieza[dim][dim];

        inicializarTablero();
        imprimirTablero();
    }

    //Método para imprimir el Tablero
    public void imprimirTablero() {
        for (int x = 0; x < dim; x++) {
            System.out.print("\n" + ejeY[x] + "\t");
            for (int y = 0; y < dim; y++) {
                String valor = piezas[x][y].getValor();
                String formato = piezas[x][y].getFormato();
                System.out.print(formato + "\t");
            }
        }
        System.out.println("");
        System.out.print("\t");

        for (int x = 0; x < dim; x++) {
            System.out.print(ejeX[x] + "\t");
        }
        System.out.println();
    }

    //Método para definir el estado inicial del tablero
    public void inicializarTablero(){
        //*************NEGROS*****************
        //Piezas de la fila 8
        piezas[0][0] = new Torre( 9, 2);
        piezas[0][1] = new Caballo( 11, 2);
        piezas[0][2] = new Alfil( 10, 2);
        piezas[0][3] = new Reina(8, 2);
        piezas[0][4] = new Rey( 7, 2);
        piezas[0][5] = new Alfil( 10, 2);
        piezas[0][6] = new Caballo( 11, 2);
        piezas[0][7] = new Torre( 9, 2);

        //Piezas de la fila 7
        for(int x = 0; x < dim; x++) {
            piezas[1][x] = new Peon(12, 2);
        }

        //Espacios vacíos
        for(int x = 2; x < dim-2; x++){
            for(int y = 0; y < dim; y++){
                piezas[x][y] = new Pieza(0, 0);
            }
        }

        //*************BLANCOS*****************
        //Piezas de la fila 2
        for(int x = 0; x < dim; x++) {
            piezas[6][x] = new Peon(6, 1);
        }

        //Piezas de la fila 1
        piezas[7][0] = new Torre( 3, 1);
        piezas[7][1] = new Caballo( 5, 1);
        piezas[7][2] = new Alfil( 4, 1);
        piezas[7][3] = new Reina( 2, 1);
        piezas[7][4] = new Rey( 1, 1);
        piezas[7][5] = new Alfil( 4, 1);
        piezas[7][6] = new Caballo( 5, 1);
        piezas[7][7] = new Torre( 3, 1);
    }

    public boolean moverPieza(int turno, int posicionPiezaX, int posicionPiezaY, int nuevaPosicionX, int nuevaPosicionY)
    {
        // Validar que no se salga del tablero
        if(posicionPiezaX > 7 || posicionPiezaY > 7 || nuevaPosicionX > 7 || nuevaPosicionY > 7 ||
                posicionPiezaX < 0 || posicionPiezaY < 0 || nuevaPosicionX < 0 || nuevaPosicionY < 0)
        {
            System.out.println("No te puedes salir de los limites.");
            return true;
        }

        Pieza variablePiezaTemporal = piezas[posicionPiezaX][posicionPiezaY];
        Pieza variableNuevaPosicionTemporal = piezas[nuevaPosicionX][nuevaPosicionY];
        System.out.println(variablePiezaTemporal.toString());
        System.out.println(variableNuevaPosicionTemporal.toString());

        // Validar que no elija vacio o color contrario, validar que se coma al color contrario
        // Validar que no se coma a pieza con el mismo color
        // Validar condicion de exito para un color (pendiente)

        if (variablePiezaTemporal.color == 0) {
            System.out.println("No puedes mover espacios vacios.");
            return true;
        }
        if ((variablePiezaTemporal.color == 1 && turno == 2) || (variablePiezaTemporal.color == 2 && turno == 1)) {
            System.out.println("No puedes mover una pieza de color distinto al tuyo.");
            return true;
        }
        if ((variablePiezaTemporal.color == 1 && variableNuevaPosicionTemporal.color == 1) ||
            (variablePiezaTemporal.color == 2 && variableNuevaPosicionTemporal.color == 2)) {
            System.out.println("No puedes comerte a una pieza del mismo color.");
            return true;
        }

        // Mandar a llamar el método que contenga las reglas de la pieza y
        // verificar que las reglas se cumplan (ej. no te puedes saltar piezas excepto caballo,
        // no puedes ir adelante como alfil o diagonal como torre, etc.)

        piezas[nuevaPosicionX][nuevaPosicionY]=variablePiezaTemporal;
        piezas[posicionPiezaX][posicionPiezaY]=variableNuevaPosicionTemporal;
        imprimirTablero();

        return false;

    }
}