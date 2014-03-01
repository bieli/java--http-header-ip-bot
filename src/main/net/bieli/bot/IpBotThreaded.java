package net.bieli.bot;

public class IpBotThreaded {
    public static void main(String args[]) {
        try {
            for (int i = 1; i < 27; i++) {
//                System.out.println("**** Main Thread: " + i);
                new ThreadIpBot(i, args[0]);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("*** Main thread interrupted.");
        }
//        System.out.println("*** Main thread exiting.");
    }
}
