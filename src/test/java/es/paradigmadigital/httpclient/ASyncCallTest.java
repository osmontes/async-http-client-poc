package es.paradigmadigital.httpclient;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Al ser llamadas asíncronas, no recibimos ninguna respuesta para testear
 */
class ASyncCallTest {

    @Test
    public void getWithBoundTest() throws IOException {
        ASyncCall.getWithBound("http://www.google.es");
    }

    @Test
    public void getWithUnboundTest() throws IOException {
        ASyncCall.getWithUnbound("http://www.google.es");
    }

}