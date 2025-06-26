package main.java.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Sunucuya bağlandı. Mesaj yazın:");

            String userInput;
            while ((userInput = consoleInput.readLine()) != null) {
                out.println(userInput);
                String response = serverInput.readLine();
                System.out.println("Sunucu: " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
