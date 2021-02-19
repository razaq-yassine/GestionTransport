package Models;

import Repository.*;

public class Client extends User {
    public Client(String username_User, String password_User) {
        super(username_User, password_User);
    }

    @Override
    public int getType_User() {
        return 1;
    }

}
