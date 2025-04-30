import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.security.spec.ECFieldF2m;
import java.util.Scanner;

public class ClientEs1 {
    private DatagramSocket socket;
    private int port;
    private DatagramPacket inPacket;
    private DatagramPacket outPacket;
    private InetAddress address;

    public ClientEs1(){
        port = 1234;
    }

    public void start(){
        try{
            while(true){
                socket = new DatagramSocket();
                System.out.println("Inserire la temperatura");
                double temp = new Scanner(System.in).nextDouble();
                if (temp == 999){
                    break;
                } else {
                    String messageOut = String.valueOf(temp);
                    address = InetAddress.getLocalHost();
                    //System.out.println(messageOut);
                    outPacket = new DatagramPacket(messageOut.getBytes(), messageOut.length(), address, port);
                    socket.send(outPacket);
    
                    byte[] buffer = new byte[256];
                    inPacket = new DatagramPacket(buffer, buffer.length);
                    socket.receive(inPacket);
                    String messageIn = new String(inPacket.getData(),0, inPacket.getLength());
                    System.out.println("Valore in Fahrenheit: " + messageIn);
                }
                
            }


        }catch(Exception a){}
    }

    public static void main(String[] args) throws Exception{
        ClientEs1 client = new ClientEs1();
        client.start();
    }
}
