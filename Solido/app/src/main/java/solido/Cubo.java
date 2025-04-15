package solido;

public class Cubo extends Solido{
    private final double lato;

    public Cubo(double pesoSpecifico,double lato){
        super(pesoSpecifico);
        this.lato = lato; 
    }

    public Cubo(Cubo other){
        super(other);
        lato = other.getLato();
    }

    public double getLato() {
        return lato;
    }

    @Override
    public double volume(){
        return Math.pow(lato, 3);
    }

    @Override
    public double superficie(){
        return 6 * Math.pow(lato, 2);
    }
}
