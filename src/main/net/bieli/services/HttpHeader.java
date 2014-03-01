package net.bieli.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class HttpHeader {
    private final static int PORT = 80;
    private final static String USER_AGENT = "User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:27.0) Gecko/20100101 Firefox/27.0";

    public String getRawHeaders(String hostname) throws IOException {
        String output = "";
        Socket socket = null;
        PrintWriter writer = null;
        BufferedReader reader = null;

        try {
            socket = new Socket(hostname, PORT);
            socket.setSoTimeout(2000);
            socket.setReceiveBufferSize(5000);
            socket.setTcpNoDelay(true);
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            writer.println("GET / HTTP/1.1");
            writer.println("Host: " + hostname);
            writer.println("Accept: */*");
            writer.println(USER_AGENT);
            writer.println(""); // Important, else the server will expect that there's more into the request.
            writer.flush();

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            for (String line; (line = reader.readLine()) != null; ) {
                if (line.isEmpty()) {
                    break; // Stop when headers are completed. We're not interested in all the HTML.
                }
                //output.concat(line);
                output += line + "\n";
                //System.out.println(line);
            }
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException logOrIgnore) {
                    //TODO: add log4j error messages
                }
            }
            if (writer != null) {
                writer.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException logOrIgnore) {
                    //TODO: add log4j error messages
                }
            }
        }

        return output;
    }
}

