package api_users.test;


import api_users.action.delete.DeleteUsers;
import api_users.action.get.GetUsers;
import api_users.action.post.PostNewUser;
import api_users.action.put.EditUsers;
import api_users.infra.api_server.ServerActions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UsersTest {

    @BeforeClass
    public void ResetServer(){
        ServerActions.stopContainer();
        ServerActions.startContainer();

    }

    @Test(priority = 2)
    public void testPostNewUser() {
        PostNewUser.createNewUserFunction();
    }



    @Test(priority = 3)
    public void testGetUsers() {
        GetUsers.getUsersFunction();

    }




    @Test (priority = 4)
    public void testEditUsers() {
        EditUsers.editUserFunction();
    }




    @Test (priority = 5)
    public void testDeleteUsers() {
        DeleteUsers.deleteUserFunction();
    }
}






