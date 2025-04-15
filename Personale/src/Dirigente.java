public class Dirigente extends Dipendente{
    private static int retribuzioneOraria = 100;

    public Dirigente(){
        super();
    }

    public Dirigente(int oreLavorate, String codice, String nome, String cognome, int annoAssunzione){
        super(oreLavorate, codice, nome, cognome, annoAssunzione);
    }

    public Dirigente(Dirigente other){
        super(other);
    }

    @Override
    public int costoOrario(){
        return retribuzioneOraria;
    }

    public static int getRetribuzioneOraria() {
        return retribuzioneOraria;
    }

    public String toString(){
        String out = super.toString();
        out += "RETRIBUZIONE ORARIA: " + getRetribuzioneOraria();
        return out;
    }

    
}
