import java.time.LocalDate;

class Programmatore extends Dipendente {
    private String linguaggiConosciuti;
    private int anniDiEsperienza;

    public Programmatore(String nome, int stipendio, int matricola, String dataDiNascita, String dataDiAssunzione, String linguaggiConosciuti, int anniDiEsperienza) {
        super(nome, stipendio, matricola, dataDiNascita, dataDiAssunzione);
        this.linguaggiConosciuti = linguaggiConosciuti;
        this.anniDiEsperienza = anniDiEsperienza;
    }
    /*@Override
    public int pagaDipendente(){
        if (getDataDiAssunzione()-LocalDate.now() >= 2){
            return 1200;
        } else {
            return 1500;
        }
    }*/ //Portando avanti la mia idea ho implementato una soluzione che si basa
    //sull'utilizzo della data di assunzione (per funzionare avrebbe dovuto essere
    //un oggetto di classe LocalDate) e la data di quando viene eseguito il codice (LocalDate.now())
    //per capire in quale range di stipendio lo sviluppatore appartenesse,
    //invece avrei dovuto usare l'attributo anniDiEsperienza (e comunque tutta l'idea era
    //sbagliata dal principio).
    public void setLinguaggiConosciuti(String linguaggiConosciuti) {
        this.linguaggiConosciuti = linguaggiConosciuti;
    }

    public String getLinguaggiConosciuti() {
        return linguaggiConosciuti;
    }

    public void setAnniDiEsperienza(int anniDiEsperienza) {
        this.anniDiEsperienza = anniDiEsperienza;
    }

    public int getAnniDiEsperienza() {
        return anniDiEsperienza;
    }
}
