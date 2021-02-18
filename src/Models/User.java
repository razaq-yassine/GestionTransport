package Models;

import Repository.MyDatabase;

public class User {
    private static int counter =1000;
    private int type_User;
    private int id_User;
    private String username_User;
    private String password_User;
    static int NumberUsers=0;


     User(String username_User, String password_User) {
        this.id_User = ++counter;
        this.username_User = username_User;
        this.password_User = password_User;
        ++NumberUsers;
    }

    public static int getNumberUsers() {
        return NumberUsers;
    }

    public static boolean UsernameExist(String username) {
         Admin[] admins = MyDatabase.getAdmins();
         Client[] clients = MyDatabase.getClients();
         for (int i= 0 ; i < Admin.getNumberAdmin() -1;i++){
             if (admins[i].getUsername_User().equals(username))
                 return true;
         }
         for (int i=0 ; i < Client.getNumberClient() -1;i++){
             if (clients[i].getUsername_User().equals(username))
                 return true;
         }
         return false;
    }

    public int getId_User(){
        return id_User;
    }

    public void setType_User(int type_User) {
        this.type_User = type_User;
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

    public int getType_User() {
        return this.type_User;
    }
    // methods
    public boolean Seconnecter(String username_User, String password_User){
        return (username_User.equals(this.getUsername_User()) && password_User.equals(getPassword_User()));
    }


}
