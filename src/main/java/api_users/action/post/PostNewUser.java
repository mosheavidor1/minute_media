package api_users.action.post;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class PostNewUser {


        public static void main(String[] args) {
            try {

                URI uri = new URI("http://localhost:5000/users");


                String jsonBody = "{\"Name\":\"John Doe\",\"Id\":\"3\"}";


                HttpClient httpClient = HttpClient.newHttpClient();


                HttpRequest postRequest = HttpRequest.newBuilder()
                        .uri(uri)
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                        .build();


                HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());


                String responseData = postResponse.body();
                System.out.println("Response: " + responseData);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


