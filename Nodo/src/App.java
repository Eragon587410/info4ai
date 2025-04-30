public class App {
    public static void main(String[] args) throws Exception {
        
        Tipo tipo1 = new Tipo("Integer");
        Tipo tipo2 = new Tipo("String");
        Tipo tipo3 = new Tipo("Boolean");

        Pila test1 = new Pila();
        test1.push(tipo1);
        test1.push(tipo2);
        test1.push(tipo3);

        System.out.println(test1.pop());
        System.out.println(test1.pop());

        System.out.println(test1.top());
        System.out.println(test1.top());

        System.out.println(test1.pop());
        System.out.println(test1.pop());

        Coda test2 = new Coda();
        test2.enqueue(tipo1);
        test2.enqueue(tipo2);
        
        System.out.println(test2.dequeue());
        System.out.println(test2.dequeue());
        System.out.println(test2.dequeue());
    }
}
