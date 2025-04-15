abstract public class Tecnico extends Dipendente{
    private boolean interno;

    Tecnico(){
        super();
    }

    Tecnico(int oreLavorate, String codice, String nome, String cognome, int annoAssunzione, boolean interno){
        super(oreLavorate, codice, nome, cognome, annoAssunzione);
        setInterno(interno);
    }

    public Tecnico(Tecnico other){
        super(other);
        setInterno(other.getInterno());
    }

    public void setInterno(boolean interno) {
        this.interno = interno;
    }

    public boolean getInterno(){
        return interno;
    }

    @Override
    public String toString(){
        String out = super.toString();
        out += "INTERNO: " + getInterno();
        return out;
    }

}
