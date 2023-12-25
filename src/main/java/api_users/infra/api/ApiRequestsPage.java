package api_users.infra.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ApiRequestsPage implements ApiMethods {

    private final HttpClient httpClient;

    public ApiRequestsPage() {
        this.httpClient = HttpClient.newHttpClient();
    }


    @Override
    public HttpResponse<String> performPostRequest(URI uri,String jsonString) throws Exception {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();

        return httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
    }


    @Override
    public HttpResponse<String> performGetRequest(URI uri) throws Exception {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        return httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
    }


    @Override
    public HttpResponse<String> performPutRequest(URI uri, String jsonBody) throws Exception {
        HttpRequest putRequest = HttpRequest.newBuilder()
                .uri(uri).header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonBody)).build();

        return httpClient.send(putRequest, HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public HttpResponse<String> performDeleteRequest(URI uri) throws Exception {
        HttpRequest deleteRequest = HttpRequest.newBuilder()
                .uri(uri)
                .DELETE()
                .build();

        return httpClient.send(deleteRequest, HttpResponse.BodyHandlers.ofString());
    }

}

