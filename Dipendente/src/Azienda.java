import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Azienda {

    //per mancanza di tempo non avevo implementato una classe aggregante, mi ero limitato a inizializzare un arrey,
    //quindi ho creato una soluzione da zero mantenendo la scelta di usare un array
    private Dipendente[] dipendenti;
    int contatore;

    public Azienda(int n){
        dipendenti = new Dipendente[n];
        contatore = 0;
    }

    public void addDipendente(Dipendente d) {
        dipendenti[contatore] = d;
        contatore++;
    }


    public void pagaDipendente(Dipendente d) {
        if (d instanceof Programmatore) {
            if (((Programmatore) d).getAnniDiEsperienza() >= 2) {
                d.setStipendio(1500);
            } else {
                d.setStipendio(1200);
            }
        } else if (d instanceof Dirigente) {
            d.setStipendio(3000);
        } else if (d instanceof AgenteDiVendita) {
            d.setStipendio(1500);
        }
    } //Questo è il metodo che svolge l'operazione corretta,
    //ero stato un po' fuorviato dal fatto che gli stipendi sono
    //costanti per ogni classe (o quasi), quindi pensavo si potesse
    //definire già in fase di creazione di un oggetto (costruttori)
    //o assegnarlo direttamente come valore di default dell'attributo.
    public void stipendiTotali(){
        for (int i = 0; i < contatore; i++){
            pagaDipendente(dipendenti[i]);
            System.out.println(dipendenti[i].getNome()+ ": "+dipendenti[i].getStipendio());
        }
    }
}