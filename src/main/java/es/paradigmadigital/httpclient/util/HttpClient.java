package es.paradigmadigital.httpclient.util;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Request;
import org.asynchttpclient.proxy.ProxyServer;

import java.io.IOException;

public class HttpClient {

    public static AsyncHttpClient getClient() {
        DefaultAsyncHttpClientConfig.Builder clientBuilder = Dsl.config()
                .setConnectTimeout(500);
        return Dsl.asyncHttpClient(clientBuilder);
    }

    public static BoundRequestBuilder getBoundRequest(String url) throws IOException {
        AsyncHttpClient client = getClient();
        BoundRequestBuilder boundRequestBuilder = getClient().prepareGet(url);
        client.close();
        return boundRequestBuilder;
    }

    public static Request getUnBoundRequest(String url) {
        return Dsl.get(url).build();
    }

}
