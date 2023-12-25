package api_users.infra.api;

import api_users.infra.api.json.JsonBody;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ApiRequestsPage implements ApiMethods {

    private final HttpClient httpClient;

    public ApiRequestsPage() {
        this.httpClient = HttpClient.newHttpClient();
    }

    @Override
    public HttpResponse<String> performPostRequest(URI uri, JsonBody jsonBody) throws Exception {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(uri)
                .POST(buildJsonBody(jsonBody));

        HttpRequest postRequest = requestBuilder.build();
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
    public HttpResponse<String> performPutRequest(URI uri, JsonBody jsonBody) throws Exception {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(uri)
                .PUT(buildJsonBody(jsonBody));

        HttpRequest putRequest = requestBuilder.build();
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


    private HttpRequest.BodyPublisher buildJsonBody(JsonBody jsonBody) {
        if (jsonBody == null || jsonBody.getJsonMap().isEmpty()) {
            return HttpRequest.BodyPublishers.noBody();
        }

        StringBuilder jsonString = new StringBuilder("{");
        for (Map.Entry<String, String> entry : jsonBody.getJsonMap().entrySet()) {
            jsonString.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\",");
        }
        jsonString.deleteCharAt(jsonString.length() - 1);
        jsonString.append("}");

        return HttpRequest.BodyPublishers.ofString(jsonString.toString());
    }
}
