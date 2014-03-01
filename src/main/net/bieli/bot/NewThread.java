package net.bieli.bot;

// Create a new thread.
class NewThread implements Runnable {
    Thread t;

    private int start = 1;

    private int stop = 10;

    public void setStart(int start) {
        this.start = start;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

   NewThread(int i) {
        // Create a new, second thread
        this.setStart((i * 10));
        this.setStop(10);

        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + t);
        t.start(); // Start the thread
   }

   // This is the entry point for the second thread.
   public void run() {
      try {
         for(int i = start; i < start + stop + 1; i++) {
             System.out.println("Child Thread: " + i);

             String ip = String.format("212.77.100.%d", i);
             System.out.println(">>>>> IP: " + ip);

             IpBot.getRawHeaderByIpAddress(ip);

             // Let the thread sleep for a while.
             Thread.sleep(1000);
         }
     } catch (InterruptedException e) {
         System.out.println("Child interrupted.");
     }

     System.out.println("Exiting child thread.");
   }
}
