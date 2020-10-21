package es.paradigmadigital.httpclient;

import es.paradigmadigital.httpclient.util.HttpClient;
import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;

import java.io.IOException;

/**
 * Llamadas asíncronas de tipo GET
 *
 * Se añade una llamada a sleep para dar tiempo a completarse la ejecución.
 * Podemos elegir entre utilizar el request con el API Bound o el Unbound, con los
 * dos obtenemos lo mismo, solo son distintas formas de obtener el Response
 */
@Slf4j
public class ASyncCall {

    public static void getWithBound(String url) throws IOException {
        BoundRequestBuilder request = HttpClient.getBoundRequest(url);
        request.execute(new AsyncCompletionHandler<Object>() {
            @Override
            public Object onCompleted(Response response) throws Exception {
                printLogs(response);
                return response;
            }
        });

        //Para probarlo lo dejo dormir 5000 milisegundos
        goToSleepPlease();
    }

    public static void getWithUnbound(String url) throws IOException {
        Request unBoundRequest = HttpClient.getUnbound(url);
        AsyncHttpClient client = HttpClient.getClient();
        client.executeRequest(unBoundRequest, new AsyncCompletionHandler<Object>() {
            @Override
            public Object onCompleted(Response response) throws Exception {
                printLogs(response);
                return response;
            }
        });

        //Para probarlo lo dejo dormir 5000 milisegundos
        goToSleepPlease();
    }

    private static void goToSleepPlease() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printLogs(Response response) {
        log.info("RESPONSE STATUS {}", response.getStatusCode());
        log.info("RESPONSE BODY {}", response.getResponseBody());
    }
}
