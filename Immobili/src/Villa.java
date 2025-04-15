public class Villa extends Abitazione{

    private int numeroPiani;
    private double superficieGiardino;
    private boolean piscina;

    public Villa(){
        super();
        numeroPiani = 0;
        superficieGiardino = 0;
        piscina = false;
    }

    public Villa(int numeroStanze, double superficie, String indirizzo, String città, int numeroPiani, double superficieGiardino, boolean piscina){
        super(numeroStanze, superficie, indirizzo, città);
        this.numeroPiani = numeroPiani;
        this.superficieGiardino = superficieGiardino;
        this.piscina = piscina;
    }

    public Villa(Villa other){
        this(other.getNumeroStanze(), other.getSuperficie(), other.getIndirizzo(), other.getCittà(), other.getNumeroPiani(), other.getSuperficieGiardino(), other.getPiscina());
    }

    public void setNumeroPiani(int numeroPiani){
        this.numeroPiani = numeroPiani;
    }

    public int getNumeroPiani(){
        return numeroPiani;
    }

    public double getSuperficieGiardino(){
        return superficieGiardino;
    }

    public boolean getPiscina(){
        return piscina;
    }

    public void setPiscina(boolean piscina){
        this.piscina = piscina;
    }

    public void setSuperficieGiardino(double superficieGiardino){
        this.superficieGiardino = superficieGiardino;
    }

    @Override
    public String toString(){
        String out = "";
        out = super.toString();
        out += "\nnumero piani: " + getNumeroPiani();
        out += "\nsuperficie giardino: " + getSuperficieGiardino();
        out += "\npossibilità piscina: " + getPiscina();
        return out;
    }

    public boolean equals(Villa other){
        boolean out = false;

        if (other != null && super.equals(other) && other.getNumeroPiani() == getNumeroPiani() && other.getSuperficieGiardino() == getSuperficieGiardino() && other.getPiscina() == getPiscina()){
            out = true;
        }
        return out;
    }
}
