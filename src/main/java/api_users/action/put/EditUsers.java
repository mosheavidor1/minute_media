package api_users.action.put;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EditUsers {




        public static void main(String[] args) {
            try {

                URI uri = new URI("http://localhost:5000/users/3");


                String jsonBody = "{\"Name\":\"moshe\"}";


                HttpClient httpClient = HttpClient.newHttpClient();


                HttpRequest putRequest = HttpRequest.newBuilder()
                        .uri(uri)
                        .header("Content-Type", "application/json")
                        .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
                        .build();


                HttpResponse<String> putResponse = httpClient.send(putRequest, HttpResponse.BodyHandlers.ofString());


                String responseData = putResponse.body();
                System.out.println("PUT Response: " + responseData);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


