
package api_users.action.put;

import api_users.infra.api.ApiRequestsPage;
import api_users.infra.api.ApiStrings;
import api_users.infra.api.messages.ResponseHandler;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class EditUsers {

public static void editUserFunction() {
    try {
        ApiStrings apiStrings = new ApiStrings();

        String editedId = apiStrings.setUserID("55");

        URI uri = new URI(ApiStrings.URI + ApiStrings.PORT + "/" + ApiStrings.USERS_PATH + "/"
                + editedId);

        String updatedUserName = apiStrings.setUserName("Mike");

        Map<String, String> jsonBody = new HashMap<>();
        jsonBody.put(ApiStrings.NAME, updatedUserName);
        jsonBody.put(ApiStrings.ID, editedId);

        Gson gson = new Gson();
        String requestBody = gson.toJson(jsonBody);

        ApiRequestsPage apiRequestsPage = new ApiRequestsPage();

        HttpResponse<String> response = apiRequestsPage.performPutRequest(uri, requestBody);

        ResponseHandler.handleResponse(response);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

