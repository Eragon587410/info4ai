import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        Funzionario prova = Funzionario.assegnaFunzionario(10, null, null, null, 1999);
        Funzionario prova2 = Funzionario.assegnaFunzionario(10, null, null, null, 2024);

        System.out.println(prova.costoOrario());
        System.out.println(prova2.costoOrario());

        TecnicoElettronico prova3 = new TecnicoElettronico(10, "23BR", "Samuele", "Girlandi", 1999, true);
        TecnicoElettronico prova4 = new TecnicoElettronico(10, "23BR", "Samuele", "Girlandi", 1999, false);

        TecnicoInformatico prova5 = new TecnicoInformatico(10, "23BR", "Samuele", "Girlandi", 1999, true);

        System.out.println(prova3.toString());
        System.out.println(prova4.toString());
        System.out.println(prova5.toString());

        Progetto progetto1 = new Progetto(10);
        progetto1.addDipendente(prova5);
        progetto1.addDipendente(prova);
        progetto1.addDipendente(prova3);
        System.out.println(progetto1.toString());
        System.out.println(progetto1.getCostoProgetto());
    }

    
    
}
