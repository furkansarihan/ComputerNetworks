package gameserver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client{

    final String serverIp="0.0.0.0";
    final int serverPort = 7000;

    public Client(){
        beginServer();
    }

    void beginServer(){
        try{
        Socket socket = new Socket(serverIp,serverPort);
        System.out.println("Socket created");
        ObjectInputStream iStream = new ObjectInputStream(socket.getInputStream());
        System.out.println("iostream");
        ObjectOutputStream oStream = new ObjectOutputStream(socket.getOutputStream());
        oStream.flush();
        Scanner sc = new Scanner(System.in);
        String message = "";
        System.out.println("Client connected..");
        while(!message.equals("exit")){
            message = sc.next();
            oStream.writeObject(message);
        }
        System.out.println("Client exit..");
        iStream.close();
        oStream.close();
        socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main (String args[]){
        Client c = new Client();
    }
}