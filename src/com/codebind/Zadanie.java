package com.codebind;

public class Zadanie {
    public static void main(String args[]) {
        KolejkaKomunikatow k = new KolejkaKomunikatow();
        Watek w1 = new Watek(k, 1);
        Watek w2 = new Watek(k, 2);
        w1.start();
        w2.start();

        try {
            w1.join();
//            14 Zbiór zadań do przedmiotu programowanie obiektowe
            w2.join();
        } catch (InterruptedException e) {};

        Object ob = k.odbierz();
        while (k != null && ob != null) {
            System.out.println(((Integer)ob).toString());
            ob = k.odbierz();
        }

        System.out.println("----------> HashMap <----------");

        CommunicateQueue c = new CommunicateQueue();
        CQThread t1 = new CQThread(c, 1);
        CQThread t2 = new CQThread(c, 2);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {};

        Object obj = c.receive();
        while (c != null && obj != null) {
            System.out.println(obj.toString());
            obj = c.receive();
        }
    }
}
