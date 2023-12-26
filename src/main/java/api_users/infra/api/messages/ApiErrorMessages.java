package api_users.infra.api.messages;


public class ApiErrorMessages {

    public static String getErrorMessage(int statusCode, String reason) {
        String errorMessage=" ";

        switch (statusCode) {
            case 400:
                if ("non String object".equals(reason)) {
                    errorMessage = "400 Bad Request - please use key<String> : Value <String> when setting non String object.";
                }
                break;
            case 404:
                if ("incorrect URL format".equals(reason)) {
                    errorMessage = "404 Not Found - Please check URL.";
                } else if ("empty body String".equals(reason)
                        || "user not found".equals(reason)
                        || "non existing id for delete".equals(reason)) {
                    errorMessage = "404 Not Found - The requested URL was not found on the server. If you entered the URL manually please check your spelling and try.";
                }
                break;
            case 500:
                errorMessage = "500 Internal Server Error - The server encountered an internal error and was unable to complete your request. Either the server is overloaded or there is an error in the application.";
                break;
            default:
                errorMessage = "Unknown Error";
        }

        return errorMessage;
    }

}
