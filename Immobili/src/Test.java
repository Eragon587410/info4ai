public class Test {
    public static void main(String [] args) throws Exception{
        Abitazione test1 = new Abitazione(4, 200, "Viale dei ginepri 13", "Trento");
        System.out.println(test1.toString());

        Negozio test2 = new Negozio(4, 200, "Viale dei ginepri 13", "Trento", 2, 20, false);
        System.out.println(test2);

        Negozio test3 = new Negozio(4, 200, "Viale dei ginepri 13", "Trento", 5, 21, true);

        System.out.println(test3.equals(test2));

        Negozio test4 = new Negozio(test2);

        System.out.println(test2.equals(test4));


    }
}
