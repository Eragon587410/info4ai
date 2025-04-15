package solido;

public class Sfera extends Solido{
    private final double raggio;

    public Sfera(double pesoSpecifico,double raggio){
        super(pesoSpecifico);
        this.raggio = raggio; 
    }

    public Sfera(Sfera other){
        super(other);
        raggio = other.getRaggio();
    }

    public double getRaggio() {
        return raggio;
    }

    @Override
    public double volume(){
        return 4/3 * Math.PI * Math.pow(raggio, 3);
    }

    @Override
    public double superficie(){
        return 4 * Math.PI * Math.pow(raggio, 2);
    }
}
