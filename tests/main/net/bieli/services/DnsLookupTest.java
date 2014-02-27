package net.bieli.services;

import org.junit.Test;

import java.net.UnknownHostException;

public class DnsLookupTest {
  @Test
  //TODO: WE NEED MOCKING  IT IS NOT UNIT TEST !!!
  public void shouldReturnHostNameWhenDomainAssocciated() throws UnknownHostException {
      String ipAddress = "212.77.100.101";

      DnsLookup dnsLookup = new DnsLookup();
      String hostname = dnsLookup.getHostName(ipAddress);

      assert !hostname.isEmpty();
  }
}

