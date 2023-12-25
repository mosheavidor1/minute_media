package api_users.action.post;

import api_users.infra.api.ApiRequestsPage;
import api_users.infra.api.ApiStrings;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class PostNewUser {

    public static void main(String[] args) {
        try {
            ApiStrings apiStrings = new ApiStrings();

            URI uri = new URI(ApiStrings.URI + ApiStrings.PORT + "/" + ApiStrings.USERS_PATH);

            String userName = apiStrings.setUserName("John Doe");
            String userId = apiStrings.setUserID("15");

            Map<String, String> jsonBody = new HashMap<>();
            jsonBody.put(ApiStrings.NAME, userName);
            jsonBody.put(ApiStrings.ID, userId);


            Gson gson = new Gson();
            String requestBody = gson.toJson(jsonBody);


            ApiRequestsPage apiRequestsPage = new ApiRequestsPage();


            HttpResponse<String> response = apiRequestsPage.performPostRequest(uri, requestBody);

            String responseData = response.body();
            System.out.println("Response: " + responseData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}