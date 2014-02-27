package net.bieli.bot;

import net.bieli.services.DnsLookup;
import net.bieli.services.HttpHeader;

import java.io.IOException;

public class IpBot {
    public static void main(String[] args) throws IOException {
        String ipAddress = "212.77.100.101";
        String hostname;

        System.out.println("ipAddress: " + ipAddress);

        DnsLookup dnsLookup = new DnsLookup();
        hostname = dnsLookup.getHostName(ipAddress);

        System.out.println("hostname: " + hostname);

        HttpHeader httpHeader = new HttpHeader();
        String rawHeaders = httpHeader.getRawHeaders(hostname);

        System.out.println("rawHeaders: \n" + rawHeaders);

    }
}
