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

        for (int x = 0; x < dim; x++) System.out.print(ejeX[x] + "\t");
    }

    //Método para definir el estado inicial del tablero
    public void inicializarTablero(){
        //Piezas de la fila 8
        piezas[0][0] = new Torre(true);
        piezas[0][1] = new Caballo(true);
        piezas[0][2] = new Alfil(true);
        piezas[0][3] = new Reina(true);
        piezas[0][4] = new Rey(true);
        piezas[0][5] = new Alfil(true);
        piezas[0][6] = new Caballo(true);
        piezas[0][7] = new Torre(true);

        //Piezas de la fila 7
        for(int x = 0; x < dim; x++) piezas[1][x] = new Peon(true);

        //Espacios vacíos
        for(int x = 2; x < dim-2; x++){
            for(int y = 0; y < dim; y++){
                piezas[x][y] = new Pieza();
            }
        }

        //Piezas de la fila 2
        for(int x = 0; x < dim; x++) piezas[6][x] = new Peon(false);

        //Piezas de la fila 1
        piezas[7][0] = new Torre(false);
        piezas[7][1] = new Caballo(false);
        piezas[7][2] = new Alfil(false);
        piezas[7][3] = new Reina(false);
        piezas[7][4] = new Rey(false);
        piezas[7][5] = new Alfil(false);
        piezas[7][6] = new Caballo(false);
        piezas[7][7] = new Torre(false);
    }
}