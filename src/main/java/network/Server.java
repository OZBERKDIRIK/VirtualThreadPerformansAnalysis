package main.java.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {
        System.out.println("Sunucu başlatılıyor...");
        final int PORT = 5001;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Sunucu port " + PORT + " üzerinde dinleniyor...");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Blocking I/O burada gerçekleşiyor
                System.out.println("Yeni bağlantı: " + clientSocket.getInetAddress());

                // Her bağlantı için yeni thread
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
