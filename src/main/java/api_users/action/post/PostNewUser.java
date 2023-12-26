
package api_users.action.post;

import api_users.infra.api.ApiRequestsPage;
import api_users.infra.api.ApiStrings;
import api_users.infra.api.messages.ResponseHandler;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class PostNewUser {

public static void createNewUserFunction() {
    try {
        ApiStrings apiStrings = new ApiStrings();

        URI uri = new URI(ApiStrings.URI + ApiStrings.PORT + "/" + ApiStrings.USERS_PATH);

        String userName = apiStrings.setUserName("john");
        String userId = apiStrings.setUserID("54");

        Map<String, String> jsonBody = new HashMap<>();
        jsonBody.put(ApiStrings.NAME, userName);
        jsonBody.put(ApiStrings.ID, userId);

        Gson gson = new Gson();
        String requestBody = gson.toJson(jsonBody);

        ApiRequestsPage apiRequestsPage = new ApiRequestsPage();
        HttpResponse<String> response = apiRequestsPage.performPostRequest(uri, requestBody);

        ResponseHandler.handleResponse(response);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
