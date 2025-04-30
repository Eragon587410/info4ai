/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nuovoclient;
import java.io.*;
import java.net.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author arturo.galvagni
 */
public class NuovoClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int port = 2000;  // osservare la differenza con il client A
       // indirizzo del server UDP
       InetAddress serverAddress;
       // socket UDP
       DatagramSocket dSocket;
       // pacchetto UDP con il testo da inviare al server
       DatagramPacket outPacket;
       // pacchetto UDP di risposta ricevuto dal server
       DatagramPacket inPacket;
       byte[] buffer;
       String tastiera,message,response;
       String username;
       try
       {
         //usare getlocalHost() se il server è sulla stessa macchina
          // del client, altrimenti è necessario conoscere l'indirizzo
          // ip del server
          serverAddress=InetAddress.getLocalHost();
          System.out.println("Apertura CHAT lato client: specificare l'username");
          Scanner scanString=new Scanner(System.in);
          username = scanString.nextLine();
          dSocket=new DatagramSocket();
          outPacket=new DatagramPacket(
                                        username.getBytes(),
                                        username.length(),
                                        serverAddress,
                                        port);
          // invio il pacchetto
          dSocket.send(outPacket);
          System.out.print(username+ " ");
          
          // messaggio di avvio
          message=scanString.nextLine();
          outPacket=new DatagramPacket(
                                        message.getBytes(),
                                        message.length(),
                                        serverAddress,
                                        port);
          // invio il pacchetto
          dSocket.send(outPacket);
          while (true)
          {
             // preparazione alla ricezione
            buffer=new byte[256];
            // prepara il pacchetto di ricezione
            inPacket=new DatagramPacket(buffer,buffer.length);
            // accetta/riceve il pacchetto di risposta
            dSocket.receive(inPacket);
            // si estrae il messaggio ricevuto e lo si visualizza
            response= new String(inPacket.getData(),0,inPacket.getLength());
            System.out.println(response);
            
             // prepara il pacchetto da inviare
             System.out.print(username+ " ");
            // lettura del messaggio da tastiera
            
            tastiera="";
            try
            {
                tastiera=scanString.nextLine();
            }
            catch(InputMismatchException iMex)
            {
              scanString.close(); 
              System.err.println(iMex);
            }
            // preparo il messaggio da inviare al client A
            // tramite il server
            message="ClientB>> ";
            message=message.concat(tastiera);
            outPacket=new DatagramPacket(
                                     message.getBytes(),
                                     message.length(),
                                     serverAddress,
                                     port);
            dSocket.send(outPacket);
            
            if (tastiera.equals("STOP"))
            {
                System.out.println("Connessione chiusa");
                dSocket.close();
                break;
            }
           
          }//fine while
          
       }// fine try
       catch(IOException e)
       {
           System.err.println(e);
           
       }
    }// fine main
    
} // fine classe