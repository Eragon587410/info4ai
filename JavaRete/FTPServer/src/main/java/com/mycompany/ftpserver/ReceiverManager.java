/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ftpserver;

/**
 *
 * @author francesco.roccabruna
 */
import java.io.File;
import java.net.Socket;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class ReceiverManager implements Runnable {

    private final String SAVE_DIR = "c:/lavoro-temp/download";
    private final Socket socket;

    public ReceiverManager(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            System.out.println("Richiesta trasferimento file ricevuta da" + socket);

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            File inFile = (File) inputStream.readObject();
            File outFile = new File(SAVE_DIR + "/" + inFile.getName());

            saveFile(inFile, outFile);

        } catch (Exception a) {
            a.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException a) {
            }

        }
    }

    public void saveFile(File in, File out) throws IOException {
        System.out.println("Ricezione file " + in.getName() + " in corso...");
        System.out.println("Dimensione file " + in.getName() + " = " + in.length() + "byte");
        FileInputStream inStream = new FileInputStream(in);
        FileOutputStream outStream = new FileOutputStream(out);
        byte[] buf = new byte[1024];
        int i;
        while ((i = inStream.read(buf)) != -1) {
            outStream.write(buf, 0, i);
        }
        inStream.close();
        outStream.close();
        System.out.println("...ricezione completa");
    }
}
