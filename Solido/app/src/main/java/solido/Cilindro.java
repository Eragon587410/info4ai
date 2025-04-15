package solido;

public class Cilindro extends Solido{
    private final double raggio;
    private final double altezza;

    public Cilindro(double pesoSpecifico,double raggio, double altezza){
        super(pesoSpecifico);
        this.raggio = raggio; 
        this.altezza = altezza;
    }

    public Cilindro(Cilindro other){
        super(other);
        raggio = other.getRaggio();
        altezza =  other.getAltezza();
    }

    public double getRaggio() {
        return raggio;
    }

    public double getAltezza() {
        return altezza;
    }
    
    @Override
    public double volume(){
        return Math.PI * Math.pow(raggio, 2) * altezza;
    }

    @Override
    public double superficie(){
        return 4 * Math.PI * Math.pow(raggio, 2);
    }
}
