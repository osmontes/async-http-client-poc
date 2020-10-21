package es.paradigmadigital.httpclient.util;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Request;

import java.io.IOException;

/**
 * Utilidad para obtener el cliente AsyncHttpClient y los Request HTTP
 * con los dos APIS que proporciona AHC, Bound y Unbound
 * Usando el API Bound, este utiliza la configuración que hayamos puesto
 * en el AsyncHttpClient, el Unbound funciona a parte de esta configuración
 */
public class HttpClient {

    /**
     * Obtenemos el cliente AsyncHttpClient con timeout
     * @return
     */
    public static AsyncHttpClient getClient() {
        DefaultAsyncHttpClientConfig.Builder clientBuilder = Dsl.config()
                .setConnectTimeout(500);
        return Dsl.asyncHttpClient(clientBuilder);
    }

    /**
     * Creación del HTTP Request Bound
     * @param url
     * @return
     * @throws IOException
     */
    public static BoundRequestBuilder getBoundRequest(String url) throws IOException {
        AsyncHttpClient client = getClient();
        BoundRequestBuilder boundRequestBuilder = getClient().prepareGet(url);
        client.close();
        return boundRequestBuilder;
    }

    /**
     * Creación del HTTP Request Unbound
     * @param url
     * @return
     */
    public static Request getUnbound(String url) {
        return Dsl.get(url).build();
    }

}
