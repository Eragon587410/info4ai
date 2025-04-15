public class FunzionarioJunior extends Funzionario{
    private static int retribuzioneOraria = 75;


    public FunzionarioJunior(int oreLavorate, String codice, String nome, String cognome, int annoAssunzione){
        super(oreLavorate, codice, nome, cognome, annoAssunzione);
    }

    public FunzionarioJunior(FunzionarioJunior other){
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
        out += "RETRIBUZIONE ORARIA: " + costoOrario();
        return out;
    }
}
