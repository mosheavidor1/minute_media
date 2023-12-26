package api_users.action.get;//package api_users.action.get;


import api_users.infra.api.ApiRequestsPage;
import api_users.infra.api.ApiStrings;
import api_users.infra.api.messages.ResponseHandler;

import java.net.URI;
import java.net.http.HttpResponse;

public class GetUsers {

public static void getUsersFunction() {
    try {
        ApiStrings apiStrings = new ApiStrings();

        //Get specific user:
        // URI uri = new URI(ApiStrings.URI + ApiStrings.PORT + "/" + ApiStrings.USERS_PATH + "/" + apiStrings.setUserID("5"));


        //Get all users:
        URI uri = new URI(ApiStrings.URI + ApiStrings.PORT + "/" + ApiStrings.USERS_PATH);

        ApiRequestsPage apiRequestsPage = new ApiRequestsPage();
        HttpResponse<String> response = apiRequestsPage.performGetRequest(uri);

        ResponseHandler.handleResponse(response);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

