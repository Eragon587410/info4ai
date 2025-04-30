import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Abitazione implements Serializable {
    private int numeroStanze;
    private double superficie;
    private String indirizzo;
    private String città;

    public Abitazione() {
        superficie = 0;
        numeroStanze = 0;
    }

    public Abitazione(int numeroStanze, double superficie, String indirizzo, String città) {
        setNumeroStanze(numeroStanze);
        setSuperficie(superficie);
        setindirizzo(indirizzo);
        setCittà(città);
    }

    public Abitazione(Abitazione other) {
        this(other.numeroStanze, other.superficie, other.indirizzo, other.città);
    }

    public void setNumeroStanze(int numeroStanze) {
        this.numeroStanze = numeroStanze;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public void setindirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public int getNumeroStanze() {
        return numeroStanze;
    }

    public double getSuperficie() {
        return superficie;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCittà() {
        return città;
    }

    public String toString() {
        String out = "";

        out += "\nnumero stanze: " + getNumeroStanze();
        out += "\nsuperficie: " + getSuperficie();
        out += "\nindirizzo: " + getIndirizzo();
        out += "\ncittà: " + getCittà();

        return out;
    }

    public boolean equals(Abitazione other) {
        boolean out = false;

        if (other != null && other.getNumeroStanze() == getNumeroStanze() && other.getSuperficie() == getSuperficie()
                && other.getIndirizzo().equals(getIndirizzo()) && other.getCittà().equals(getCittà())) {
            out = true;
        }
        return out;
    }

    public boolean save(String file) {
        boolean b = false;
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(this);
            output.close();
            b = true;
        } catch (Exception e) {
        }
        return b;

    }

    public static Abitazione load(String file){
        Abitazione b = null;
        ObjectInputStream input = null;
        try{
            input = new ObjectInputStream(new FileInputStream(file));
            b = (Abitazione) input.readObject();
            input.close();
        } catch (Exception e){

        }
        return b;
    }

}
