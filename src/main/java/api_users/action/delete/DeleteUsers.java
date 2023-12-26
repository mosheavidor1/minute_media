
package api_users.action.delete;

import api_users.infra.api.ApiRequestsPage;
import api_users.infra.api.ApiStrings;
import api_users.infra.api.messages.ResponseHandler;

import java.net.URI;
import java.net.http.HttpResponse;

public class DeleteUsers {

public static void deleteUserFunction() {
    try {
        ApiStrings apiStrings = new ApiStrings();

        URI uri = new URI(ApiStrings.URI + ApiStrings.PORT +
                "/" + ApiStrings.USERS_PATH + "/" + apiStrings.setUserID("55"));

        ApiRequestsPage apiRequestsPage = new ApiRequestsPage();

        HttpResponse<String> response = apiRequestsPage.performDeleteRequest(uri);

        ResponseHandler.handleResponse(response);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

