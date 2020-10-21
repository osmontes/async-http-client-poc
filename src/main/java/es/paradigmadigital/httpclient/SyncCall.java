package es.paradigmadigital.httpclient;

import es.paradigmadigital.httpclient.util.HttpClient;
import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.Response;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Llamadas síncronas de tipo GET
 * Podemos elegir entre utilizar el request con el API Bound o el Unbound, con los
 * dos obtenemos lo mismo, solo son distintas formas de obtener el Response
 */
@Slf4j
public class SyncCall {

    public static Response getWithBoundResponse(String url) throws ExecutionException, InterruptedException, IOException {
        Future<Response> responseFuture = HttpClient.getBoundRequest(url).execute();
        Response response = responseFuture.get();
        printLogs(response);
        return responseFuture.get();
    }

    public static Response getWithUnboundResponse(String url) throws ExecutionException, InterruptedException {
        Future<Response> responseFuture = HttpClient.getClient().executeRequest(HttpClient.getUnbound(url));
        Response response = responseFuture.get();
        printLogs(response);
        return response;
    }

    private static void printLogs(Response response) {
        log.info("RESPONSE STATUS {}", response.getStatusCode());
        log.info("RESPONSE BODY {}", response.getResponseBody());
    }

}
