/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.serverurl;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ServerURL {

    public static void main(String[] args) {
        //porta del server (maggiore di 1024)
        int portS = 2000;
        
        //porta del client
        int portC = 3000;
        //indirizzo del client
        InetAddress clientAddress;
        //socket TCP
        ServerSocket sSocket;
        //gestione della connessione
        Socket connection;
        // Stream per gestire il flusso di input 
        InputStream inSocket;
        //Scanner per leggere il messaggio
        Scanner streamIn;
        String messageIn;
        
        //Stream per gestire il flusso di output
        OutputStream outSocket;
        PrintWriter streamOut;
        String messageOut;
        
        System.out.println("Apertura porta in corso");
        try{
            sSocket = new ServerSocket(portS);
            while (true){
                System.out.println("Server in ascolto sulla porta " + portS + "\n");
                connection = sSocket.accept(); //listener (ascoltatore) che aspetta che si colleghi qualcuno
                System.out.println("Connessione stabilita");
                //estrae il messaggio ricevuto, lo mostra e poi chiude lo stream
                inSocket = connection.getInputStream();
                streamIn = new Scanner(inSocket);
                messageIn = streamIn.nextLine();
                streamIn.close();
                System.out.println("URL RICEVUTO");
                System.out.println(messageIn);
            
                try{
                    //crea un oggetto della classe URL
                    URL indirizzoWeb = new URL(messageIn);
                    //salva il contenuto della pagina web in un file sul server
                    InputStream in = new BufferedInputStream(indirizzoWeb.openStream());
                    OutputStream out = new BufferedOutputStream(new FileOutputStream("c:/lavoro-temp/url.htm"));
                    int readbyte = in.read();
                    while (readbyte >= 0){
                        out.write(readbyte);
                        readbyte = in.read();
                    }
                    in.close();
                    out.close();
                    //prepara una risposta per il client
                    messageOut = "Pagina scaricata correttamente e salvata in c:/lavoro-temp";
                }
                catch(IOException e){
                    System.err.println(e);
                    //prepara risposta di errore per il client
                    messageOut="Indirizzo inesistente";
                }
                //invio del messaggio di risposta al client
                
                // getLocalHost() va usato solo se il client si trova sulla stessa macchina 
                //del server, altrimenti bisogna scrivere l'indirizzo ip
                clientAddress=InetAddress.getLocalHost();
                
                connection = new Socket(clientAddress, portC);
                outSocket = connection.getOutputStream();
                streamOut = new PrintWriter(outSocket);
                streamOut.println(messageOut);
                streamOut.close();
                System.out.println("RIsposta inviata");
                connection.close();
                
            }
            
            
        }
        catch(IOException e){
            System.err.println(e);
        }
        
    }
}
