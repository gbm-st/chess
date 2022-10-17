public class Caballo extends Pieza{
    public Caballo(boolean color){
        this.color = color;
        if(color){
            valor = simbolos[5];
        } else{
            valor = simbolos[11];
        }

        formato = "[ " + valor + " ]";
    }

}
