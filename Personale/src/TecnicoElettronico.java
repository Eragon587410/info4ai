import java.time.LocalDate;

public class TecnicoElettronico extends Tecnico{
    private static int retribuzioneOraria = 60;

    TecnicoElettronico(){
        super();
    }

    TecnicoElettronico(int oreLavorate, String codice, String nome, String cognome, int annoAssunzione, boolean interno){
        super(oreLavorate, codice, nome, cognome, annoAssunzione, interno);
    }

    public TecnicoElettronico(TecnicoElettronico other){
        super(other);
    }

    @Override
    public int costoOrario(){
        int out = 0;
        out = getRetribuzioneOraria() * getOreLavorate();
        if (getInterno()){
            out += (LocalDate.now().getYear() - getAnnoAssunzione());
        }
        return out;
    }

    public static int getRetribuzioneOraria() {
        return retribuzioneOraria;
    }

    public static void setRetribuzioneOraria(int retribuzioneOraria) {
        TecnicoElettronico.retribuzioneOraria = retribuzioneOraria;
    }

    @Override
    public String toString(){
        String out = super.toString();
        out += "RETRIBUZIONE ORARIA: " + costoOrario();
        return out;
    }
}
