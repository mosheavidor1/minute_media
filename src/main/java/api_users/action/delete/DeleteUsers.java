package api_users.action.delete;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DeleteUsers {




        public static void main(String[] args) {
            try {

                URI uri = new URI("http://localhost:5000/users/3");


                HttpClient httpClient = HttpClient.newHttpClient();


                HttpRequest deleteRequest = HttpRequest.newBuilder()
                        .uri(uri)
                        .DELETE()
                        .build();


                HttpResponse<String> deleteResponse = httpClient.send(deleteRequest, HttpResponse.BodyHandlers.ofString());


                String responseData = deleteResponse.body();
                System.out.println("DELETE Response: " + responseData);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


