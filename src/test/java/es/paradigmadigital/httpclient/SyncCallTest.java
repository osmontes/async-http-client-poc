package es.paradigmadigital.httpclient;

import org.asynchttpclient.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SyncCallTest {

    @Test
    public void getBoundTest() throws ExecutionException, InterruptedException, IOException {
        Response response = SyncCall.getWithBoundResponse("http://www.google.es");
        assertNotNull(response);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void getUnboundTest() throws ExecutionException, InterruptedException {
        Response response = SyncCall.getWithUnboundResponse("http://www.google.es");
        assertNotNull(response);
        assertEquals(200, response.getStatusCode());
    }

}