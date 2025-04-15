import java.time.LocalDate;

abstract public class Dipendente implements Cloneable{
    private String codice;
    private String nome;
    private String cognome;
    private int annoAssunzione;
    private int oreLavorate;

    public Dipendente(){
        annoAssunzione = LocalDate.now().getYear();
    }

    public Dipendente(int oreLavorate, String codice, String nome, String cognome, int annoAssunzione){
        setCodice(codice);
        setNome(cognome);
        setCognome(cognome);
        setAnnoAssunzione(annoAssunzione);
        setOreLavorate(oreLavorate);
    }

    public Dipendente(Dipendente other){
        this(other.getOreLavorate(), other.getCodice(), other.getNome(), other.getCognome(), other.getAnnoAssunzione());
    }

    public void setOreLavorate(int oreLavorate) {
        this.oreLavorate = oreLavorate;
    }

    public int getOreLavorate() {
        return oreLavorate;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getCodice() {
        return codice;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setAnnoAssunzione(int annoAssunzione) {
        if (annoAssunzione > 1900 && annoAssunzione <= LocalDate.now().getYear()){
            this.annoAssunzione = annoAssunzione;
        }
    }

    public int getAnnoAssunzione() {
        return annoAssunzione;
    }

    abstract int costoOrario();

    public int costoTotale(){
        return costoOrario() * getOreLavorate();
    }

    public Dipendente clone() throws CloneNotSupportedException{
        Dipendente out = null;
        out = (Dipendente)super.clone();

        return out;
    }

    @Override
    public String toString(){
        String out = "";

        out += "CODICE: " + getCodice() + "\n";
        out += "NOME: " + getNome() + "\n";
        out += "COGNOME: " + getCognome() + "\n";
        out += "ANNO ASSUNZIONE: " + getAnnoAssunzione() + "\n";
        out += "ORE LAVORATE: " + getOreLavorate() + "\n";
        return out;
    }

    @Override
    public boolean equals(Object other){
        boolean out = false;
        if (other != null && other instanceof Dipendente){
            Dipendente dip = (Dipendente)other;
            if (getCodice().equals(dip.getCodice()) && getNome().equals(dip.getNome()) && getCognome().equals(dip.getCognome()) && getOreLavorate() == dip.getOreLavorate() && getAnnoAssunzione() == dip.getAnnoAssunzione()){
                out = true;
            }
        }

        return out;
    }
}
