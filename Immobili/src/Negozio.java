public class Negozio extends Abitazione{

    private int numeroPiani;
    private int numeroPostiAuto;
    private boolean mezziPubblici;

    public Negozio(){
        super();
        numeroPiani = 0;
        numeroPostiAuto = 0;
        mezziPubblici = false;
    }

    public Negozio(int numeroStanze, double superficie, String indirizzo, String città, int numeroPiani, int numeroPostiAuto, boolean mezziPubblici){
        super(numeroStanze, superficie, indirizzo, città);
        this.numeroPiani = numeroPiani;
        this.numeroPostiAuto = numeroPostiAuto;
        this. mezziPubblici = mezziPubblici;
    }

    public Negozio(Negozio other){
        this(other.getNumeroStanze(), other.getSuperficie(), other.getIndirizzo(), other.getCittà(), other.getNumeroPiani(), other.getNumeroPostiAuto(), other.getMezziPubblici());
    }

    public int getNumeroPiani(){
        return numeroPiani;
    }

    public int getNumeroPostiAuto(){
        return numeroPostiAuto;
    }

    public boolean getMezziPubblici(){
        return mezziPubblici;
    }

    @Override
    public String toString(){
        String out = "";
        out = super.toString();
        out += "\nnumero piani: " + getNumeroPiani();
        out += "\nnumero posti auto: " + getNumeroPostiAuto();
        out += "\npossibilità mezzi pubblici: " + getMezziPubblici();
        return out;
    }

    
    public boolean equals(Negozio other){
        boolean out = false;
        if (other != null && super.equals(other) && other.getNumeroPiani() == getNumeroPiani() && other.getNumeroPostiAuto() == getNumeroPostiAuto() && other.getMezziPubblici() == getMezziPubblici()){
            out = true;
        }
        return out;
    }
}
