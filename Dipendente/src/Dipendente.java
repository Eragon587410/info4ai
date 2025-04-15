class Dipendente {
    private String nome;
    private int stipendio;
    private int matricola;
    private String dataDiNascita;
    private String dataDiAssunzione;

    public Dipendente(String nome, int stipendio, int matricola, String dataDiNascita, String dataDiAssunzione) {
        this.nome = nome;
        this.stipendio = stipendio;
        this.matricola = matricola;
        this.dataDiNascita = dataDiNascita;
        this.dataDiAssunzione = dataDiAssunzione;
    }

    //public int pagaDipendente(){
    //    return stipendio;
    //} 
    //Avevo capito che il metodo dovesse restituire quanto il dipendente 
    // venisse pagato (un getter) e non che dovesse assegnare il valore allo stipendio.

    public int getStipendio() {
        return stipendio;
    }

    public String getNome() {
        return nome;
    }

    public void setStipendio(int stipendio) {
        this.stipendio = stipendio;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setDataDiAssunzione(String dataDiAssunzione) {
        this.dataDiAssunzione = dataDiAssunzione;
    }

    public String getDataDiAssunzione() {
        return dataDiAssunzione;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }
    
}
