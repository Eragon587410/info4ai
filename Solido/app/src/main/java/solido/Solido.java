package solido;

public abstract class Solido {
    private final double pesoSpecifico;

    public Solido(double pesoSpecifico){
        this.pesoSpecifico = pesoSpecifico;
    }

    public Solido(Solido other){
        this.pesoSpecifico = other.pesoSpecifico;
    }

    public double getPesoSpecifico() {
        return pesoSpecifico;
    }

    public abstract double volume();

    public abstract double superficie();

    public double peso(){
        return volume() * getPesoSpecifico();
    }

}
