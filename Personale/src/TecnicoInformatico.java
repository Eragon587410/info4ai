import java.time.LocalDate;

public class TecnicoInformatico extends Tecnico{
    private static int retribuzioneOraria = 50;

    TecnicoInformatico(){
        super();
    }

    TecnicoInformatico(int oreLavorate, String codice, String nome, String cognome, int annoAssunzione, boolean interno){
        super(oreLavorate, codice, nome, cognome, annoAssunzione, interno);
    }

    public TecnicoInformatico(TecnicoInformatico other){
        super(other);
    }

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
        TecnicoInformatico.retribuzioneOraria = retribuzioneOraria;
    }

    @Override
    public String toString(){
        String out = super.toString();
        out += "RETRIBUZIONE ORARIA: " + costoOrario();
        return out;
    }
}
