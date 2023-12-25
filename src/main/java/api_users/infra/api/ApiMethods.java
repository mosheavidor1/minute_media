package api_users.infra.api;

import api_users.infra.api.json.JsonBody;

import java.net.URI;
import java.net.http.HttpResponse;

public interface ApiMethods {

  //  HttpResponse<String> performPostRequest(URI uri, JsonBody jsonBody) throws Exception;

  HttpResponse<String> performPostRequest(URI uri, String jsonBody) throws Exception;

    HttpResponse<String> performGetRequest(URI uri) throws Exception;

    HttpResponse<String> performPutRequest(URI uri, String jsonBody) throws Exception;

    HttpResponse<String> performDeleteRequest(URI uri) throws Exception;
}
