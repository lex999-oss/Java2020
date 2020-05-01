package com.company;

import java.io.*;
import java.net.InetAddress;
import java.util.Scanner;
import java.net.Socket;

public class GameClient {
    public static void main(String[] args) throws IOException {
        try {
            Scanner scn = new Scanner(System.in);

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            // establish the connection with server port 5486
            Socket s = new Socket(ip, 5486);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            // exchange of
            // information between client and server
            while (true) {
                String request = scn.nextLine();
                dos.writeUTF(request);

                // If client sends exit,close this connection
                // and then break from the while loop
                if (request.equals("exit")) {
                    System.out.println("Closing this connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                } else if (request.equals("stop")) { //If client sends stop, close the connection and terminat server process
                    System.out.println("Closing this connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    System.out.println("Shutting server down...");
                    break;
                }

                // printing response
                String received = dis.readUTF();
                System.out.println(received);

            }
            // closing resources
            scn.close();
            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

