import java.util.ArrayList;

public class Progetto {
    ArrayList<Dipendente> listaDipendenti;


    public Progetto(){
        listaDipendenti = new ArrayList<Dipendente>(10);
    }

    public Progetto(int n){
        listaDipendenti = new ArrayList<Dipendente>(n);
    }

    public Progetto(Progetto other){
        if (other != null){
            listaDipendenti = new ArrayList<Dipendente>(other.getListaDipendenti().size());
            for (int i = 0; i < other.getListaDipendenti().size(); i++){
                listaDipendenti.add(other.getListaDipendenti().get(i));
            }
        }
    }

    public ArrayList<Dipendente> getListaDipendenti() {
        return new ArrayList<Dipendente>(listaDipendenti);
    }

    public void addDipendente(Dipendente d){
        try{
            listaDipendenti.add(d.clone());
        }
        catch(CloneNotSupportedException a){
        }
        
    }

    public Dipendente getDipendente(int p){
        Dipendente out = null;
        if (p >= 0 && p < getListaDipendenti().size()){
            try{
                out = getListaDipendenti().get(p).clone();
            }
            catch(CloneNotSupportedException a){
            }
            
        }

        return out;
    }

    public void removDipendente(int i){
        if (i >= 0 && i < getListaDipendenti().size()){
            listaDipendenti.remove(i);   
        }
    }

    public int getCostoProgetto(){
        int out = 0;

        for (int i = 0; i < listaDipendenti.size(); i++){
            out += listaDipendenti.get(i).costoTotale();
        }
        return out;
    }

    public String toString(){
        String out = "PROGETTO: \n";
        for (int i = 0; i < listaDipendenti.size(); i++){
            out += getDipendente(i).toString();
        }
        return out;
    }
}