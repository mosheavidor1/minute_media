package api_users.action.get;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GetUsers {

        public static void main(String[] args) {
            try {

                URI uri = new URI("http://localhost:5000/users");


                HttpClient httpClient = HttpClient.newHttpClient();


                HttpRequest getRequest = HttpRequest.newBuilder()
                        .uri(uri)
                        .GET()
                        .build();


                HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());


                String responseData = getResponse.body();
                System.out.println("GET Response: " + responseData);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




