package net.bieli.services;

import java.net.InetAddress;
import java.net.UnknownHostException;

public final class DnsLookup {
    public String getHostName(String ipAddress) throws UnknownHostException {
        String hostName = new String("");

        try {
            InetAddress host;

            host = InetAddress.getByName(ipAddress);

            if (!host.getHostAddress().equals(host.getHostName())) {
                //System.out.println(">>>>>> IP: " + host.getHostAddress());
                //System.out.println("-- HOST: " + host.getHostName());
                hostName = host.getHostName();
            }
        } catch (UnknownHostException e) {
            hostName = "";
            e.printStackTrace();
        }

        return hostName;
    }
}
