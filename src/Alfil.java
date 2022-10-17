public class Alfil extends Pieza{
    public Alfil(boolean color){
        this.color = color;
        if(color){
            valor = simbolos[4];
        } else{
            valor = simbolos[10];
        }

        formato = "[ " + valor + " ]";
    }
}
