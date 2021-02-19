package Kernel;

import Models.Admin;
import Models.Client;
import Repository.DB;

public class Validate {

    public static boolean UsernameExists(String username) {

        for ( Admin admin: DB.getAdmins()) {
            if (admin.getUsername_User().equalsIgnoreCase(username))
                return true;
        }
        for (Client client: DB.getClients()) {
            if (client.getUsername_User().equalsIgnoreCase(username))
                return true;
        }
        return false;
    }
}
