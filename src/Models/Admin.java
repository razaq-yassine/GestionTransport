package Models;

import Repository.MyDatabase;

import java.io.Serializable;

public class Admin extends Client implements Serializable {

    public Admin(String username_User, String password_User) {
        super(username_User, password_User);
    }

    @Override
    public int getType_User() {
        return -1;
    }
}
