package com.codebind;

public class CQThread extends Thread {

    private CommunicateQueue coQu;
    private int iterator;

    public CQThread(CommunicateQueue cQ, int beginning) {
        coQu = cQ;
        iterator = beginning;
    }

    public void run() {
        try {
            for (int i = iterator; i <= 10; i += 2) {
                coQu.send(String.valueOf(i), i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {};
    }
}
