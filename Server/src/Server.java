import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class Server {

    public static void main(String[] args) {

        // Porta del Server: utilzzare una porta maggiore di 1023
        int portS = 2000;
        // Porta del Client: utilizzare una porta maggiore di 1023
        int portC = 3000;
        // indirizzo del client TCP;
        InetAddress clientAddress;
        // Socket TCP
        ServerSocket sSocket;
        // Oggetto da utlizzare per la comunicazione:
        Socket connection;
        // Stream per gestire il flusso di input:
        InputStream inSocket;
        Scanner streamln;
        String messageln;
        // Stream per gestire il flussi di output:
        OutputStream outSocket;
        PrintWriter streamOut;
        String messageOut;
        System.out.print("Aperttura porta in corso");
        try {
            sSocket = new ServerSocket(portS);
            while (true) {
                System.out.println("Server in ascolto sulla porta" + portS + "\n");
                connection = sSocket.accept();
                System.out.println("Connessione stabilita");
                // Estrae il messaggio ricevuto, lo mostra e poi chiude lo stream;
                //outSocket = connection.getOutputStream();
                //streamOut = new PrintWriter(outSocket);
                //portS = (int)Math.random()*1023+1025;
                //streamOut.println(portS);
                //streamOut.close();
                //connection.close();
                //sSocket = new ServerSocket(portS);
                //connection = sSocket.accept();
                inSocket = connection.getInputStream();
                streamln = new Scanner(inSocket);
                messageln = streamln.nextLine();
                streamln.close();
                System.out.println("URL ricevuto: ");
                System.out.println(messageln);

                try {
                    // Creare un oggetto della classe URL:
                    URL indirizzoWeb = new URL(messageln);
                    // Salva il contenuto della pagina web in un file locale del Server:
                    InputStream in = new BufferedInputStream(indirizzoWeb.openStream());
                    OutputStream out = new BufferedOutputStream(new FileOutputStream("C:/lavoro-temp/url.htm"));
                    int readbyte = in.read();
                    while (readbyte >= 0) {
                        out.write(readbyte);
                        readbyte = in.read();
                    }
                    in.close();
                    out.close();
                    // Prepara un messaggio di risposta per il Client:
                    messageOut = "Pagins scaricata correttamente e salvata in c:lavoro-temp";
                } catch (IOException e) {
                    System.out.println(e);
                    // Prepara un messaggio di risposta per il Client
                    messageOut = "indirizzo inesistente";
                }
                // Invio messaggio di risposta al Client:
                // Usare getLocalHost() se il Client è sulla stessa mecchina del Sever
                // altrimenti occorre conescere l'IP del Client
                clientAddress = InetAddress.getLocalHost();
                connection = new Socket(clientAddress, portC);
                outSocket = connection.getOutputStream();
                streamOut = new PrintWriter(outSocket);
                streamOut.println(messageOut);
                streamOut.close();
                connection.close();
            } // Fine while
        } catch (IOException e) {
            System.out.println(e);
        }
    }// Fine main
}// Fine classe serverURL
