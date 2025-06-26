package main.java.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable{
    private final Socket clientSocket;

    public Client(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String message;
            while ((message = input.readLine()) != null) {
                System.out.println("Client'tan gelen: " + message);
                output.println("Sunucu cevabı: " + message.toUpperCase()); // basit cevap mekanizması
            }
        } catch (Exception e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
    }
}
