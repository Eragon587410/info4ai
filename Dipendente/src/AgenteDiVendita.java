class AgenteDiVendita extends Dipendente {
    private String[] portafoglioClienti;
    private int provvigioni;

    public AgenteDiVendita(String nome, int stipendio, int matricola, String dataDiNascita, String dataDiAssunzione, String[] portafoglioClienti, int provvigioni) {
        super(nome, stipendio, matricola, dataDiNascita, dataDiAssunzione);
        this.portafoglioClienti = portafoglioClienti;
        this.provvigioni = provvigioni;
    }
}
