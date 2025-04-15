public class App {
    public static void main(String[] args) throws Exception{
        
        Azienda test = new Azienda(5);

        Dipendente prova = new Programmatore("Giovanni", 2700, 1301, "2003-02-14", "20015-09-01", "Java, Python", 7);
        Dipendente prova2 = new Programmatore("Samu", 2700, 1301, "2003-02-14", "20015-09-01", "Java, Python", 1);


        System.out.println(prova.getStipendio());
        System.out.println(prova2.getStipendio());
        System.out.println("Stipendi aggiornati");
        test.pagaDipendente(prova);
        test.pagaDipendente(prova2);
        System.out.println(prova.getStipendio());
        System.out.println(prova2.getStipendio());
        Dipendente prova3 = new AgenteDiVendita("Arsen M", 1800, 1003, "1990-12-30", "2025-01-20", new String[]{"Cliente A", "Cliente B"}, 500);
        System.out.println(prova3);
        test.pagaDipendente(prova2);
        System.out.println(prova.getStipendio());
        System.out.println("Stipendi aggiornati");
        System.out.println(prova.getStipendio());

        test.addDipendente(prova);
        test.addDipendente(prova2);
        test.addDipendente(prova3);
        System.out.println("Stipendi di tutti i dipendenti");
        test.stipendiTotali();
        
    }
}
