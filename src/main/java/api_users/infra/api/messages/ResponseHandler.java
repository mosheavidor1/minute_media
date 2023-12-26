package api_users.infra.api.messages;

import java.net.http.HttpResponse;

public class ResponseHandler {


        public static void handleResponse(HttpResponse<String> response) {
            try {
                int statusCode = response.statusCode();
                String responseData = response.body();

                if (statusCode != 200) {
                    String reason = extractReasonFromResponse(response);
                    String errorMessage = ApiErrorMessages.getErrorMessage(statusCode, reason);

                    System.out.println("Error: " + response.body());
                    System.out.println("Error: " + errorMessage);
                } else {
                    System.out.println("Response: " + responseData);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static String extractReasonFromResponse(HttpResponse<String> response) {
            return response.body();
        }
    }


