package main.java.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientSpawner {
    public static void main(String[] args) {
        int clientNumber = 100; // Hard - coded olarak 100 adet başlatılacak client sayısı belirtildi
        int maxRetries = 5; // Her client için en fazla deneme sayısı
        int retryDelayMs=100; //Her başarısız denemeden sonra beklenecek süre

        AtomicInteger succsessCount = new AtomicInteger(0);
        AtomicInteger failCount = new AtomicInteger(0);

        for (int i = 1  ; i<=clientNumber ; i ++ ){
            int clientId=i;
            new Thread(() -> {
                int retries= 0;
                while (retries<maxRetries) {
                    try {
                        Socket socket = new Socket("localhost", 5001);
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        out.println("Merhaba " + clientId);
                        socket.close();
                        succsessCount.incrementAndGet();
                        return ;

                    } catch (IOException e) {
                        retries++;
                        try {
                            Thread.sleep(retryDelayMs);
                        }catch (InterruptedException ignore){
                            ignore.printStackTrace();
                        }
                    }
                }
                failCount.incrementAndGet();
            }).start();
        }

        new Thread(() -> {
            try{
                Thread.sleep(3000);
                System.out.println("Başarılı bağlantılar : " + succsessCount.get());
                System.out.println("Başarılısız bağlantılar : " + failCount.get());
            }catch (InterruptedException ignore){
                ignore.printStackTrace();
            }
        }).start();


    }
}
