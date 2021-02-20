package Kernel;

import Models.User;

public class MySession {
    private static User currentUser;
    public static User User(){
        return currentUser;
    }
    public static void setCurrentUser(User user){
        currentUser = user;
    }
    public static void destroyCurrentUser(){
        currentUser = null;
    }
}
