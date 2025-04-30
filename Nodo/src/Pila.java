public class Pila {
    private Nodo head;

    public Pila(){
    }

    private Nodo creaNodo(Tipo tipo, Nodo link){
        Nodo p;
        p = new Nodo(tipo);
        p.setLink(link);
        return p;
    }

    public void push(Tipo tipo){

        head = creaNodo(tipo, head);
    }

    public Tipo pop(){
        Tipo out = null;
        if (head != null){
            out = head.getInfo();
            head = head.getLink();
        }

        return out;
    }

    public Tipo top(){
        Tipo out = null;
        if (head != null){
            out = head.getInfo();
        }

        return out;
    }


}
