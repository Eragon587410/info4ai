/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clientchat;

import java.io.*;
import java.net.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author francesco.roccabruna
 */
public class ClientChat {

    public static void main(String[] args) {
        //porta del server
        int port = 2000;
        //indirizzo server UDP
        InetAddress serverAddress;
        //socket UDP
        DatagramSocket dSocket;
        //datagram UDP con testo da inviare al server
        DatagramPacket outPacket;
        //datagram UDP con testo da ricevere dal server
        DatagramPacket inPacket;
        //buffer per il contenuto del pacchetto da ricevere
        
        byte[] buffer;
        
        String tastiera, message, response;
        
        try{
            //usare getlocalhost se server e client sono sulla stessa macchina
            serverAddress = InetAddress.getLocalHost();
            System.out.println("Apertura della chat lato CLIENT-A in corso");
            dSocket = new DatagramSocket();
            while (true){
                System.out.println("ClientA>> ");
                //leggiamo un testo
                Scanner scanString = new Scanner(System.in);
                tastiera = "";
                try{
                    tastiera = scanString.nextLine();
                    scanString.close();
                    
                    
                } 
                catch (InputMismatchException a){
                    System.out.println(a);
                }
                message = "ClientA>> ";
                message = message.concat(tastiera);
                //prepara il pacchetto da inviare al clientB attraverso il server
                
                outPacket = new DatagramPacket(message.getBytes(), message.length(), serverAddress, port);
                
                dSocket.send(outPacket);
                
                if (tastiera.equals("STOP")){
                    System.out.println("connessione chiusa");
                    dSocket.close();
                    break;
                }
                
                buffer = new byte[256];
                inPacket = new DatagramPacket(buffer, buffer.length);
                
                dSocket.receive(inPacket);
                response = new String(inPacket.getData(), inPacket.getLength());
                System.out.println(response);
            
            }
        
        }
        catch(IOException a){
            System.err.println(a);
        }
        
    }
}
