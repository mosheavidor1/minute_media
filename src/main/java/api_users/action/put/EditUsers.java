


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

    String editedId = apiStrings.setUserID("5");

    URI uri = new URI(ApiStrings.URI + ApiStrings.PORT + "/" + ApiStrings.USERS_PATH + "/" + editedId);

    String updatedUserName = apiStrings.setUserName("Mike");

    Map<String, String> jsonBody = new HashMap<>();
    jsonBody.put(ApiStrings.NAME, updatedUserName);
    jsonBody.put(ApiStrings.ID, editedId);

    Gson gson = new Gson();
    String requestBody = gson.toJson(jsonBody);

    ApiRequestsPage apiRequestsPage = new ApiRequestsPage();

    HttpResponse<String> response = apiRequestsPage.performPutRequest(uri, requestBody);

    ResponseHandler.handleResponse(response);


    checkUserDetails(updatedUserName, editedId);

} catch (Exception e) {
    e.printStackTrace();
}
}

private static void checkUserDetails(String expectedUserName, String userId) {
try {
    ApiStrings apiStrings = new ApiStrings();

    URI uri = new URI(ApiStrings.URI + ApiStrings.PORT + "/" + ApiStrings.USERS_PATH + "/" + userId);

    ApiRequestsPage apiRequestsPage = new ApiRequestsPage();

    HttpResponse<String> response = apiRequestsPage.performGetRequest(uri);

    String responseBody = response.body();

    Gson gson = new Gson();
    Map<String, String> userDetails = gson.fromJson(responseBody, HashMap.class);

    String actualUserName = userDetails.get(ApiStrings.NAME);
    if (actualUserName.equals(expectedUserName)) {
        System.out.println("User name was updated successfully: " + actualUserName);
    } else {
        System.out.println("User name update failed!, name is not equals to the new edited name ");

    }
} catch (Exception e) {
    e.printStackTrace();
}
}
}

