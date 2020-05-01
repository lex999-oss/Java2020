package com.company;

import java.io.*;
import java.net.Socket;

class ClientThread extends Thread {
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket socket;


    public ClientThread(Socket socket, DataInputStream dis, DataOutputStream dos) {
        this.socket = socket;
        this.dis = dis;
        this.dos = dos;
    }

    public void run() {
        String request;
        String response;
        while (true) {
            try {
// Get the request from the input stream: client → server
                request = dis.readUTF();
                if (request.equals("exit")) {
                    System.out.println("Client " + this.socket + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.socket.close();
                    System.out.println("Connection closed");
                    break;
                }

                if (request.equals("stop")) {
                    System.out.println("Client " + this.socket + " sends stop...");
                    System.out.println("Closing this connection.");
                    this.socket.close();
                    System.out.println("Connection closed");
                    System.out.println("Shutting server down...");
                    System.exit(1);
                }
// Send the response to the oputput stream: server → client
                response = "Client requested: " + request + " !";
                dos.writeUTF(response);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            // closing resources
            this.dis.close();
            this.dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}