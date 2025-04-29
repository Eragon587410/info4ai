public class Nodo {
    private Tipo info;
    private Nodo link;

    public Nodo(){
    }

    public Nodo(Tipo info){
        this.info = info;
    }

    public void setLink(Nodo link){
        this.link = link;
    }

    public Tipo getInfo() {
        return info;
    }

    public Nodo getLink() {
        return link;
    }
}
