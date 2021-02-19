package Models;

import Repository.*;

import java.io.Serializable;

public class Client extends User implements Serializable {
    public Client(String username_User, String password_User) {
        super(username_User, password_User);
    }

    @Override
    public int getType_User() {
        return 1;
    }

}
