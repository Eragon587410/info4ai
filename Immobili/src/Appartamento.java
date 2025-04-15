public class Appartamento extends Abitazione{
    private int piano;
    private boolean ascensore;
    private int numeroTerrazzi;

    public Appartamento(){
        super();
        piano = 0;
        ascensore = false;
        numeroTerrazzi = 0;
    }

    public Appartamento(int numeroStanze, double superficie, String indirizzo, String città, int piano, boolean ascensore, int numeroTerrazzi){
        super(numeroStanze, superficie, indirizzo, città);
        this.piano = piano;
        this.ascensore = ascensore;
        this.numeroTerrazzi = numeroTerrazzi;
    }

    public Appartamento(Appartamento other){
        this(other.getNumeroStanze(), other.getSuperficie(), other.getIndirizzo(), other.getCittà(), other.getPiano(), other.getAscensore(), other.getNumeroTerrazzi());
    }

    public int getPiano(){
        return piano;
    }
    
    public boolean getAscensore(){
        return ascensore;
    }

    public int getNumeroTerrazzi(){
        return numeroTerrazzi;
    }

    @Override
    public String toString(){
        String out = "";
        out = super.toString();
        out += "\npiano: " + getPiano();
        out += "\npossibilità ascensore: " + getAscensore();
        out += "\nnumero terrazzi: " + getNumeroTerrazzi();
        return out;
    }

    public boolean equals(Appartamento other){
        boolean out = false;

        if (other != null && super.equals(other) && other.getPiano() == getPiano() && other.getAscensore() == getAscensore() && other.getNumeroTerrazzi() == getNumeroTerrazzi()){
            out = true;
        }

        return out;
    }
}
