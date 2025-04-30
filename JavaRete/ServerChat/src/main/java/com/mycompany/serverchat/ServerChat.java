/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.serverchat;
/**
 *
 * @author francesco.roccabruna
 */
import java.net.*;
import java.io.*;

public class ServerChat {

    public static void main(String[] args) {
        int portA = 2000; //porta di ascolto del server per il client A
        int portB = 3000; //porta di ascolto del server per il client B
        
        //due socket UDP
        DatagramSocket dSocketA, dSocketB;
                //datagram udp ricevuto da CLient A e B
        DatagramPacket inPacket;
        //datagram udp da inviare al CLient a o B
        DatagramPacket outPacket;
        //buffer per il contenuto del datagram udp
        //simile a input e output Stream
        byte[] buffer;
        
        //testo dei messaggi in ingresso e uscita
        String messageIn, messageOut;
        //indirizzo IP del client A e B
        InetAddress clientAddressA, clientAddressB;
        //porte usate dal client A e B
        int clientPortA, clientPortB;
        System.out.println("Apertura della Chat lato server in corso");
        
        try{
            dSocketA = new DatagramSocket(portA);
            dSocketB = new DatagramSocket(portB);
            System.out.println("server in ascolto sulla porta " + portB + "\n");
            
            buffer = new byte[256];
            inPacket = new DatagramPacket(buffer, buffer.length);
            dSocketB.receive(inPacket);
            //si recuper dall'oggetto DatagramPacket
            //L'indirizzo Ip e la porta utilizzata dal client B
            
            clientAddressB = inPacket.getAddress();
            clientPortB = inPacket.getPort();
            
            while(true){
                System.out.println("server in ascolto sulla porta " + portA + "\n");
                buffer = new byte[256];
                inPacket = new DatagramPacket(buffer, buffer.length);
                dSocketA.receive(inPacket);
                clientAddressA = inPacket.getAddress();
                clientPortA = inPacket.getPort();
                
                
                System.out.println("IP client A " + clientAddressA + "Porta del client A " + clientPortA);
                //salva il messaggio ricevuto dal client A
                messageIn = new String(inPacket.getData(), inPacket.getLength());
                
                //si prepara il essaggio (ricevuto da A ) per B
                messageOut = messageIn;
                outPacket = new DatagramPacket(messageOut.getBytes(), messageOut.length(), clientAddressB, clientPortB);
                
                //invio del messaggio al client
                dSocketB.send(outPacket);
                System.out.println("RIsposta inviata al client B");
                System.out.println("Server in ascolto sulla porta" + portB + "\n");
                buffer = new byte[256];
                inPacket = new DatagramPacket(buffer, buffer.length);
                dSocketB.receive(inPacket);
                System.out.println("IP client B: " + clientAddressB);
                
                //salva messaggio client B
                messageIn = new String(inPacket.getData(), inPacket.getLength());
                messageOut = messageIn;
                outPacket = new DatagramPacket(messageOut.getBytes(), messageOut.length(), clientAddressA, clientPortA);
                dSocketA.send(outPacket);
                System.out.println("Risposta inviata al client A");
                
            }
        }
        catch (IOException a){
            System.err.println(a);
        }
        
    }
}
