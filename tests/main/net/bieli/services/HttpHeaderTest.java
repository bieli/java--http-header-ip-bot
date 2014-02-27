package net.bieli.services;

import org.junit.Test;

import java.io.IOException;

public class HttpHeaderTest {
  @Test
  //TODO: WE NEED MOCKING  IT IS NOT UNIT TEST !!!
  public void shouldReturnRawHeadersWhenDomainWithUrlExists() throws IOException {
      String url = "bieli.net";

      HttpHeader httpHeader = new HttpHeader();
      String rawHttpHeaders = httpHeader.getRawHeaders(url);

      assert !rawHttpHeaders.isEmpty();
  }
}

