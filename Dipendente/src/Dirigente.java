class Dirigente extends Dipendente {
    private String orarioDiLavoro;

    public Dirigente(String nome, int stipendio, int matricola, String dataDiNascita, String dataDiAssunzione, String orarioDiLavoro) {
        super(nome, stipendio, matricola, dataDiNascita, dataDiAssunzione);
        this.orarioDiLavoro = orarioDiLavoro;
    }
}