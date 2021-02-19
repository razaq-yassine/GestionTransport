package Models;

import Repository.MyDatabase;

import java.io.Serializable;

public abstract class User implements Serializable {
    private static int counter =1000;
    private int id_User;
    private String username_User;
    private String password_User;


     User(String username_User, String password_User) {
        this.id_User = ++counter;
        this.username_User = username_User;
        this.password_User = password_User;

    }

    public static boolean UsernameExist(String username) {
//         Admin[] admins = MyDatabase.getAdmins();
//         Client[] clients = MyDatabase.getClients();
//         for (int i= 0 ; i < Admin.getNumberAdmin() -1;i++){
//             if (admins[i].getUsername_User().equals(username))
//                 return true;
//         }
//         for (int i=0 ; i < Client.getNumberClient() -1;i++){
//             if (clients[i].getUsername_User().equals(username))
//                 return true;
//         }
         return false;
    }

    public int getId_User(){
        return id_User;
    }


    public String getUsername_User() {
        return username_User;
    }

    public void setUsername_User(String username_User) {
        this.username_User = username_User;
    }

    public String getPassword_User() {
        return password_User;
    }

    public void setPassword_User(String password_User) {
        this.password_User = password_User;
    }

    public abstract int getType_User();

    // methods
    public boolean Seconnecter(String username_User, String password_User){
        return (username_User.equals(this.getUsername_User()) && password_User.equals(getPassword_User()));
    }


}
