package api_users.action.post;


import api_users.infra.api.ApiRequestsPage;
import api_users.infra.api.ApiStrings;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class PostNewUser {

    public static void main(String[] args) {
        try {
            ApiStrings apiStrings = new ApiStrings();

            URI uri = new URI(ApiStrings.URI + ApiStrings.PORT + "/" + ApiStrings.USERS_PATH);

        String jsonBody = "{\"" + ApiStrings.NAME + "\":\"" + apiStrings.setUserName("John Doe") + "\",\""
                + ApiStrings.ID + "\":\""
                + apiStrings.setUserID("15") + "\"}";

            HttpClient httpClient = HttpClient.newHttpClient();

        ApiRequestsPage apiRequestsPage = new ApiRequestsPage();
            HttpResponse<String> response = apiRequestsPage.performPostRequest(uri,jsonBody);


            String responseData = response.body();
            System.out.println("Response: " + responseData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
