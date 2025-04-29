public class Coda {
    private Nodo head;
    private Nodo tail;

    public Coda(){
    }

    public Nodo creaNodo(Tipo tipo){
        Nodo p = new Nodo(tipo);
        return p;
    }

    public void enqueue(Tipo tipo){
        if (tail != null){
            Nodo p = creaNodo(tipo);
            tail.setLink(p);
            tail = p;
        } else {
            Nodo p = creaNodo(tipo);
            head = p;
            tail = p;
            
        }
    }

    public Tipo dequeue(){
        Tipo out = null;
        if (head != null){
            out = head.getInfo();
            head = head.getLink();
            if (head == null){
                tail = null;
            }
        }
        
        return out;
    }
}
