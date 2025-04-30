/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nuovoserver;

/**
 *
 * @author francesco.roccabruna
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class NuovoServer {
    
    private ArrayList<InetAddress> clientAddresses;
    private ArrayList<Integer> clientPorts;
    private HashSet<String> clientIDs;
    private ArrayList<String> clientUsername;
    
    // socket UDP
    DatagramSocket dSocket;
    DatagramPacket inPacket, outPacket;
    
    //messaggi in ingresso/uscita
    
    String messageIn, messageOut;
    InetAddress clientAddressA, clientAddressB;
    int clientPortA, clientPortB;
    
    public NuovoServer() throws IOException{
        //server in ascolto sulla porta 2000;
        //tutti i client inviano messaggi su questa porta
        dSocket = new DatagramSocket(2000);
        //elenco dei client connessi
        clientAddresses = new ArrayList();
        // elenco delle porte
        clientPorts = new ArrayList();
        // ogni client viene identificato da ID = "IndirizzoIP + porta"
        clientIDs = new HashSet();
    }
    
    public void avvio(){
        //buffer per il contenuto del datagram UDP ricevuto
        byte[] buffer = new byte[256];
        
        while (true){
            try{
                inPacket = new DatagramPacket(buffer, buffer.length);
                System.out.println("Server in ascolto in attesa:");
                dSocket.receive(inPacket);
                System.out.println("Pacchetto ricevuto");
                //ricevuto il messaggio vengono memorizzate alcune informazioni
                //il messaggio, l'indirizzo IP, l'ID e la porta del client
                messageIn = new String(inPacket.getData(),0,inPacket.getLength());
                clientAddressA = inPacket.getAddress();
                clientPortA = inPacket.getPort();
                String id = clientAddressA.toString() + ","+ clientPortA;
                //queste info vengono registrate dal server solo se 
                //il client non è già connesso
                if (!clientIDs.contains(id)){
                    clientAddresses.add(clientAddressA);
                    clientPorts.add(clientPortA);
                    clientIDs.add(id);
                    clientUsername.add(messageIn);
                } else {
                    messageOut = messageIn;
                    //per tutti i client connessi invio il messaggi
                    //in broadcast
                    for (int i = 0; i < clientAddresses.size(); i++){
                        if (!(clientIDs.toArray()[i].equals(id))){
                            clientAddressB = clientAddresses.get(i);
                            clientPortB = clientPorts.get(i);

                            outPacket = new DatagramPacket(messageOut.getBytes(), messageOut.length(),clientAddressB, clientPortB);
                            //invio il messaggio all'i-esimo client connesso
                            dSocket.send(outPacket);
                        }

                    }
                }
                
            } catch(Exception a) {
            }
        }
    }

    public static void main(String[] args) throws Exception{
        //dovendo gestire più client abbiamo necessità di memorizzare le informazioni di base
        //relative ai client connessi: indirizzo ip, porta, ID, nickname utente...
        NuovoServer s = new NuovoServer();
        s.avvio();
    }
    
}
