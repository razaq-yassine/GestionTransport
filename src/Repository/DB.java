package Repository;

import Kernel.Settings;
import Models.*;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private static ArrayList DataBaseList = new ArrayList();
    private static void loadDB(){

        if (Settings.DB_Type().equals("RAM")){

            ArrayList<Marchandise> marchandises = new ArrayList<>();
            ArrayList<Ca_Aerienne> ca_aeriennes = new ArrayList<>();
            ArrayList<Ca_Routieere> ca_routieeres = new ArrayList<>();
            ArrayList<Client> clients = new ArrayList<>();
            ArrayList<Admin> admins = new ArrayList<>();
            // Adding Lists inside DB List

            // Adding initial instances
            clients.add(new Client("cyassine", "yassine"));
            clients.add(new Client("cahmed", "ahmed"));
            admins.add(new Admin("ayassine", "yassine"));
            admins.add(new Admin("aahmed", "ahmed"));
            ca_routieeres.add(new Ca_Routieere(13));
            ca_routieeres.add(new Ca_Routieere(112));
            ca_aeriennes.add(new Ca_Aerienne(13));
            ca_aeriennes.add(new Ca_Aerienne(55));

            marchandises.add(new Marchandise(15,14));
            marchandises.add(new Marchandise(415,23));
            marchandises.add(new Marchandise(11,122));
            marchandises.add(new Marchandise(113,19));
            marchandises.add(new Marchandise(13,47));
            marchandises.add(new Marchandise(20,199));

            DataBaseList.add(marchandises);
            DataBaseList.add(ca_aeriennes);
            DataBaseList.add(ca_routieeres);
            DataBaseList.add(clients);
            DataBaseList.add(admins);
        }
        else {

        }
    }

    public static ArrayList<Marchandise> getMarchandises() {
        loadDB();
        return (ArrayList<Marchandise>) DataBaseList.get(0);
    }

    public static ArrayList<Ca_Aerienne> getCa_aeriennes() {
        loadDB();
        return (ArrayList<Ca_Aerienne>) DataBaseList.get(1);
    }

    public static ArrayList<Ca_Routieere> getCa_routieeres() {
        loadDB();
        return (ArrayList<Ca_Routieere>) DataBaseList.get(2);
    }

    private static ArrayList<Client> getClients() {
        loadDB();
        return (ArrayList<Client>) DataBaseList.get(3);
    }

    private static ArrayList<Admin> getAdmins() {
        loadDB();
        return (ArrayList<Admin>) DataBaseList.get(4);
    }

    public static boolean AddMarchandise(float poids_Marchandise, float volume_Marchandie, int Id_Cargaison) {
        loadDB();
        Marchandise M1 = new Marchandise(poids_Marchandise, volume_Marchandie);
        M1.setId_Cargaison(Id_Cargaison);
        return getMarchandises().add(M1);
    }
    public static boolean AddAdmin(String username_User, String password_User){
        loadDB();
        return getAdmins().add(new Admin(username_User,password_User));
    }
    public static boolean AddClient(String username_User, String password_User){
        loadDB();
        return getClients().add( new Client(username_User, password_User) );
    }
    public static boolean AddCa_Aerienne(double distance_Cargaison){
        loadDB();
        return getCa_aeriennes().add(new Ca_Aerienne(distance_Cargaison));
    }
    public static boolean AddCa_Routiere(double distance_Cargaison){
        loadDB();
        return getCa_routieeres().add( new Ca_Routieere(distance_Cargaison) );
    }

    public static boolean EditCargaison(int id_cargaison, double distance_cargaison, String type) {
        Cargaison C = FindCargaison(id_cargaison);
        if (C!=null){
            C.setDistance_Cargaison(distance_cargaison);
            if (type.equalsIgnoreCase(C.Type()) )
            {
                if (type.equalsIgnoreCase("Cargaison Aerienne")) {
                    getCa_aeriennes().remove(C);
                    getCa_routieeres().add((Ca_Routieere) C);
                }
                if (type.equalsIgnoreCase("Cargaison Routiere")){
                    getCa_routieeres().remove(C);
                    getCa_aeriennes().add((Ca_Aerienne) C);
                }
            }
            return true;
        }
        return false;
    }
    
    
    
    
    public static Cargaison FindCargaison(int id_cargaison){
        loadDB();
        for (int i=0; i<getCa_routieeres().size(); i++)
        {
            if (getCa_routieeres().get(i).getId_Cargaison() == id_cargaison){
                return getCa_routieeres().get(i);
            }
        }
        for (int i=0; i<getCa_aeriennes().size(); i++)
        {
            if (getCa_aeriennes().get(i).getId_Cargaison() == id_cargaison){
                return getCa_aeriennes().get(i);
            }
        }
        return null;
    }
    public static Marchandise FindMarchandise(int id_Marchandise){
        loadDB();
        for(int i=0; i<getMarchandises().size(); i++){
            if (getMarchandises().get(i).getId_Marchandise() == id_Marchandise){
                return getMarchandises().get(i);
            }
        }
        return null;
    }
    public static User FindUser(int id_User){
        loadDB();
        for (int i=0; i<getClients().size(); i++){
            if (getClients().get(i).getId_User() == id_User)
                return getClients().get(i);
        }
        for (int i=0; i<getAdmins().size(); i++){
            if (getAdmins().get(i).getId_User() == id_User)
                return getAdmins().get(i);
        }
        return null;
    }

    
    
    
    public static User LoginAttempt(String username, String password) {
        loadDB();
        for (int i=0; i<getClients().size(); i++){
            if (getClients().get(i).getUsername_User().equals(username))
                if (getClients().get(i).getPassword_User().equals(password)){
                    return getClients().get(i);
                }
        }
        for (int i=0; i<getAdmins().size(); i++){
            if (getAdmins().get(i).getUsername_User().equals(username))
                if (getAdmins().get(i).getPassword_User().equals(password)){
                    return getAdmins().get(i);
                }
        }
        return null;
    }
    public static int getNumberOfCargaisons() {
        return getCa_aeriennes().size() + getCa_routieeres().size();
    }
    public static int getNumberOFMarchandises() {
        return getMarchandises().size();
    }

    public static boolean EditMarchandise(int id_marchandise, float poids, float volume, int id_cargason) {
        Marchandise M = FindMarchandise(id_marchandise);
        if (M == null)
            return false;
        FindMarchandise(id_marchandise).setPoids_Marchandise(poids);
        FindMarchandise(id_marchandise).setVolume_Marchandie(volume);
        FindMarchandise(id_marchandise).setId_Cargaison(id_cargason);
        return true;
    }

    public static ArrayList<Cargaison> getAllCargaisons() {
        ArrayList<Cargaison> Cargaisons = new ArrayList<>();

        for (int i=0; i<getCa_aeriennes().size(); i++){
            Cargaisons.add((Cargaison) getCa_aeriennes().get(i));
        }
        for (int i=0; i<getCa_routieeres().size(); i++){
            Cargaisons.add((Cargaison) getCa_routieeres().get(i));
        }
        return Cargaisons;
    }
}