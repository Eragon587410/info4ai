import java.time.LocalDate;

abstract public class Funzionario extends Dipendente{

    public Funzionario(){
        super();
    }

    public Funzionario(int oreLavorate, String codice, String nome, String cognome, int annoAssunzione){
        super(oreLavorate, codice, nome, cognome, annoAssunzione);
    }

    public Funzionario(Funzionario other){
        super(other);
    }

    public static Funzionario assegnaFunzionario(int oreLavorate, String codice, String nome, String cognome, int annoAssunzione){
        Funzionario out = null;

        if (LocalDate.now().getYear() - annoAssunzione >= 10){
            out = new FunzionarioSenior(oreLavorate, codice, nome, cognome, annoAssunzione);
        } else {
            out = new FunzionarioJunior(oreLavorate, codice, nome, cognome, annoAssunzione);
        }

        return out;
    }

    
}
