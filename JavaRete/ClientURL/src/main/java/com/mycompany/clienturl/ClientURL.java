
package com.mycompany.clienturl;

import java.net.*;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientURL {
    public static void main(String[] arg) {
        // Porta del Server: utilizzare una porta maggiore di 1023 int portS=2000;
        int portS = 2000;
        // Porta del Client: utilizzare una porta maggiore di 1023 int portC-3000;
        int portC = 3000;
        // Socket TCP
        ServerSocket sSocket;
        // Oggetto da utilizzare per la comunicazione
        Socket connection;
        // Indirizzo del Server TCP
        InetAddress serverAddress;
        InputStream inSocket;
        OutputStream outSocket;
        // Stream per gestire il flusso di input InputStream inSocket
        // Stream per gestire il flusso di output OutputStream outSocket;
        PrintWriter streamOut;
        String tastiera, response;
        Scanner streamin;
        try {
            // Usare getLocalHost() se il Server è sulla stessa macchina del Client
            // altrimenti occorre conoscere l'IP del Server"/
            serverAddress = InetAddress.getLocalHost();
            System.out.println("Indirizzo del Server trovato");
            connection = new Socket(serverAddress, portS);
            System.out.println("Connessione aperta");
            outSocket = connection.getOutputStream();
            streamOut = new PrintWriter(outSocket);
            System.out.println("Introduci l'URL: (ESEMPIO http://java.sun.com)"); // Introduce da tastiera il testo e lo
                                                                                  // invia al Server:
            Scanner scanString = new Scanner(System.in);
            tastiera = "";
            try {
                tastiera = scanString.nextLine();
                scanString.close();
            }

            catch (InputMismatchException iMex) {
                System.err.println(iMex);
            }
            streamOut.println(tastiera);
            streamOut.close();
            connection.close();
            System.out.println("Richiesta inviata");
            System.out.println("Client in attesa di risposta sulla porta" + portC + "\n");
            sSocket = new ServerSocket(portC);
            connection = sSocket.accept();
            inSocket = connection.getInputStream();
            streamin = new Scanner(inSocket);
            response = streamin.nextLine();
            //response = streamin.toString();
            streamin.close();
            connection.close();
            System.out.println(response);
            
            System.out.println("Connessione chiusa");
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}