import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Mensola implements Serializable{
    private Libro[] volumi;
    private static final int NUM_MAX_VOLUMI = 15;

    public Mensola() {
        volumi = new Libro[NUM_MAX_VOLUMI];
    }

    public Mensola(Mensola other) {
        this();
        for (int i = 0; i < other.volumi.length; i++) {
            if (other.volumi[i] != null) {
                volumi[i] = new Libro(other.volumi[i]);
            }
        }
    }

    public Libro getVolume(int posizione) {
        Libro out = null;
        if (posizione >= 0 && posizione < NUM_MAX_VOLUMI && volumi[posizione] != null) {
            out = new Libro(volumi[posizione]);
        }
        return out;
    }

    public int setVolume(Libro libro, int posizione) {
        int out = -1;
        if (posizione >= 0 && posizione < NUM_MAX_VOLUMI) {
            if (volumi[posizione] == null) {
                volumi[posizione] = new Libro(libro);
                out = posizione;
            } else {
                out = -2;
            }
        }
        return out;
    }

    public static int getNumMaxVolumi() {
        return NUM_MAX_VOLUMI;
    }

    public int rimuoviVolume(int posizione) {
        int out = -1;
        if (posizione >= 0 && posizione < NUM_MAX_VOLUMI) {
            if (volumi[posizione] != null) {
                volumi[posizione] = null;
                out = posizione;
            } else {
                out = -2;
            }
        }
        return out;
    }

    public int getNumVolumi() {
        int out = 0;
        for (int i = 0; i < volumi.length; i++) {
            if (volumi[i] != null) {
                out++;
            }
        }
        return out;
    }

    public String toString() {
        String out = "";
        for (int i = 0; i < NUM_MAX_VOLUMI; i++) {
            if (volumi[i] != null) {
                out += i + ". " + volumi[i].toString() + "\n\n";
            }
        }
        return out;
    }

    public void salvaMensola() throws java.io.IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("backup.bin"));
        stream.writeObject(volumi);
        stream.close();
    }

    public void caricaMensola() throws java.io.IOException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("backup.bin"));
        try {
            this.volumi = (Libro[]) stream.readObject();
        } catch (ClassNotFoundException exception) {
        }
        stream.close();
    }

    // metodo Save ObjectStream
    public boolean save(String filename) {
        boolean b = false;
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(filename));
            output.writeObject(this);
            output.close();
            b = true;
        } catch (Exception e) {
        }
        return b;
    }

    // metodo Load ObjectStream
    public static Mensola load(String filename) {
        Mensola g = null;
        ObjectInputStream input = null;

        try {
            input = new ObjectInputStream(new FileInputStream(filename));
            g = (Mensola) input.readObject();
            input.close();
        } catch (Exception e) {
        }
        return g;
    }

    abstract public prova(){
        System.out.println("ciaoi");
    }

}
