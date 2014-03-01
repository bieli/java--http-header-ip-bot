package net.bieli.bot;

class ThreadIpBot implements Runnable {
    Thread t;
    private int start = 1;
    private int stop = 10;
    private String ipPrefix = "";

    ThreadIpBot(int i, String ipPrefix) {
        this.setStart((i - 1) * 10);

        if (i > 26) {
            return;
        } else if (i == 26) {
            this.setStop(5);
        } else {
            this.setStop(10);
        }

        this.setIpPrefix(ipPrefix);

//        t = new Thread(this, "Demo Thread");
        t = new Thread(this);

//        System.out.println("Child thread: " + t);

        t.start();
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

    public void setIpPrefix(String ipPrefix) {
        this.ipPrefix = ipPrefix;
    }

    public void run() {
        try {
            for (int i = start + 1; i < start + stop + 1; i++) {

//             System.out.println("@@@ Child Thread: " + i);
                String ip = String.format(ipPrefix + ".%d", i);
                System.out.println(ip);

                System.out.println(">>>>> IP: " + ip);

                String rawHeaders = IpBot.getRawHeaderByIpAddress(ip, false, true);
                System.out.println("\n" + rawHeaders);

                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("@@@ Child interrupted.");
        }

//     System.out.println("@@@ Exiting child thread.");
    }
}
