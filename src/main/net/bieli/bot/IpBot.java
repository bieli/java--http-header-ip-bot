package net.bieli.bot;

import net.bieli.services.DnsLookup;
import net.bieli.services.HttpHeader;

import java.io.IOException;

public class IpBot {
    public static void main(String[] args) throws IOException {
        String ipAddress = "212.77.100.101";

        if (args.length > 0) {
            ipAddress = args[0];
        }

        System.out.println("rawHeaders: \n" + getRawHeaderByIpAddress(ipAddress, true, true));
    }

    public static String getRawHeaderByIpAddress(
            String ipAddress,
            Boolean verbose,
            Boolean showHostname
    ) {
        String hostname;
        String rawHeaders = "";

        if (verbose) {
            System.out.println("ipAddress: " + ipAddress);
        }

        try {
            DnsLookup dnsLookup = new DnsLookup();
            hostname = dnsLookup.getHostName(ipAddress);

            if (verbose || showHostname) {
                System.out.println("-- HOST: " + hostname);
            }

            HttpHeader httpHeader = new HttpHeader();
            rawHeaders = httpHeader.getRawHeaders(hostname);

            if (verbose) {
                System.out.println("rawHeaders: \n" + rawHeaders);
            }
        } catch (IOException e) {
            System.out.println("Exiting child thread with IOException !");
            e.printStackTrace();
        }

        return rawHeaders;
    }
}
