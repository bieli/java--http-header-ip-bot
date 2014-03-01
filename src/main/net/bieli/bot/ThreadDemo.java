package net.bieli.bot;

public class ThreadDemo {
    public static void main(String args[]) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("**** Main Thread: " + i);
                new NewThread(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("*** Main thread interrupted.");
        }
        System.out.println("*** Main thread exiting.");
    }
}

