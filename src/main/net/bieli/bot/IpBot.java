package net.bieli.bot;

import net.bieli.services.DnsLookup;
import net.bieli.services.HttpHeader;

import java.io.IOException;

public class IpBot {
    public static void main(String[] args) throws IOException {
        String ipAddress = "212.77.100.101";

        System.out.println("rawHeaders: \n" + getRawHeaderByIpAddress(ipAddress));
    }

    public static String getRawHeaderByIpAddress(String ipAddress) {
        String hostname;
        String rawHeaders = "";

        System.out.println("ipAddress: " + ipAddress);

        try
        {
            DnsLookup dnsLookup = new DnsLookup();
            hostname = dnsLookup.getHostName(ipAddress);

            System.out.println("hostname: " + hostname);

            HttpHeader httpHeader = new HttpHeader();
            rawHeaders = httpHeader.getRawHeaders(hostname);

            System.out.println("rawHeaders: \n" + rawHeaders);
        } catch (IOException e) {
            System.out.println("Exiting child thread with IOException !");
            e.printStackTrace();
        }
        return rawHeaders;
    }
}
