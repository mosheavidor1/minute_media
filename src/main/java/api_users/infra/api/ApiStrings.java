package api_users.infra.api;

public class ApiStrings {


    public String userName;

    public String userID;

    public String setUserName(String userName) {
        this.userName = userName;

        return userName;
    }

    public String setUserID(String userID) {
        this.userID = userID;

       return userID;
    }

    //API - URL headers:

    public static String URI ="http://localhost:";
    public static String PORT ="5000";

    public static String USERS_PATH ="users";


    //API- Json Body keys :

    public static String NAME ="Name";
    public static String ID ="Id";



}
