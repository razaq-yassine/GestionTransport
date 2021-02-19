package Repository;

import Kernel.MyFile;
import Kernel.Settings;
import Kernel.Validate;
import Models.*;

import java.util.ArrayList;


public class DB {
    private static ArrayList DataBaseList = new ArrayList();
    public DB(){
        loadDB();
    }
    private static void loadDB(){
        String Db_Type = Settings.DB_Type();
        if (Db_Type.equals("RAM")){

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
            ArrayList<ArrayList> DBList2 = new ArrayList<>();
            DBList2.add(marchandises);
            DBList2.add(ca_aeriennes);
            DBList2.add(ca_routieeres);
            DBList2.add(clients);
            DBList2.add(admins);
            DataBaseList = DBList2;
        }
        else if (Db_Type.equalsIgnoreCase("Local")){
            DataBaseList = new MyFile(Settings.getLocalDb_Path()).ReadArrayList();
        }
        else {
            DataBaseList = new MyFile(Settings.ExternalDB_FilePath()).ReadArrayList();
        }
    }
    private static void saveDB(){
        String Db_Type = Settings.DB_Type();
        if (Db_Type.equalsIgnoreCase("External")){
            new MyFile(Settings.ExternalDB_FilePath()).OverWriteByObject(DataBaseList);
        }
        else if (Db_Type.equalsIgnoreCase("Local")){
            new MyFile(Settings.getLocalDb_Path()).OverWriteByObject(DataBaseList);
        }

    }

    public static ArrayList<Marchandise> getMarchandises() {
        return (ArrayList<Marchandise>) DataBaseList.get(0);
    }

    private static ArrayList<Ca_Aerienne> getCa_aeriennes() {
        return (ArrayList<Ca_Aerienne>) DataBaseList.get(1);
    }

    private static ArrayList<Ca_Routieere> getCa_routieeres() {
        return (ArrayList<Ca_Routieere>) DataBaseList.get(2);
    }

    public static ArrayList<Client> getClients() {
        return (ArrayList<Client>) DataBaseList.get(3);
    }

    public static ArrayList<Admin> getAdmins() {
        return (ArrayList<Admin>) DataBaseList.get(4);
    }

    public static boolean AddMarchandise(float poids_Marchandise, float volume_Marchandie, int Id_Cargaison) {
        Marchandise M1 = new Marchandise(poids_Marchandise, volume_Marchandie);
        M1.setId_Cargaison(Id_Cargaison);
        getMarchandises().add(M1);
        saveDB();
        return true;
    }
    public static boolean AddAdmin(String username_User, String password_User){
        getAdmins().add(new Admin(username_User,password_User));
        saveDB();
        return true;
    }
    public static boolean AddClient(String username_User, String password_User){
        getClients().add( new Client(username_User, password_User) );
        saveDB();
        return true;
    }
    public static boolean AddCa_Aerienne(double distance_Cargaison){
        getCa_aeriennes().add(new Ca_Aerienne(distance_Cargaison));
        saveDB();
        return true;
    }
    public static boolean AddCa_Routiere(double distance_Cargaison){
        getCa_routieeres().add( new Ca_Routieere(distance_Cargaison) );
        saveDB();
        return true;
    }

    public static boolean EditCargaison(int id_cargaison, double distance_cargaison) {
        Cargaison C = FindCargaison(id_cargaison);
        if (C!=null){
            C.setDistance_Cargaison(distance_cargaison);
            saveDB();
            return true;
        }
        return false;
    }

    public static boolean EditMarchandise(int id_marchandise, float poids, float volume, int id_cargason) {
        Marchandise M = FindMarchandise(id_marchandise);
        if (M == null)
            return false;
        FindMarchandise(id_marchandise).setPoids_Marchandise(poids);
        FindMarchandise(id_marchandise).setVolume_Marchandie(volume);
        FindMarchandise(id_marchandise).setId_Cargaison(id_cargason);
        saveDB();
        return true;
    }

    public static boolean AjouterMarchandiseDansCargaison(int id_marchandise, int id_cargaison) {
        Marchandise M = DB.FindMarchandise(id_marchandise);
        if (M!=null){
            M.setId_Cargaison(id_cargaison);
            saveDB();
            return true;
        }
        return false;
    }


    public static Cargaison FindCargaison(int id_cargaison){
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
        for(int i=0; i<getMarchandises().size(); i++){
            if (getMarchandises().get(i).getId_Marchandise() == id_Marchandise){
                return getMarchandises().get(i);
            }
        }
        return null;
    }

    public static User FindUser(int id_User){
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
    public static boolean Register(String username, String password, String Type){
        if(Validate.UsernameExists(username))
            return false;
        if(Type.equalsIgnoreCase("admin"))
            return AddAdmin(username, password);
        else return AddClient(username, password);
    }
    public static int getNumberOfCargaisons() {
        return getCa_aeriennes().size() + getCa_routieeres().size();
    }

    public static int getNumberOFMarchandises() {
        return getMarchandises().size();
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

    public static ArrayList<String> getDB() {
        return DataBaseList;
    }

    public static void main(String[] args) {
        DB db = new DB();
        Menu.cyan(Double.toString(FindCargaison(1003).getDistance_Cargaison()));
        Menu.cyan(FindCargaison(1003).Type());
        EditCargaison(1003, 1);
        Menu.cyan(Double.toString(FindCargaison(1003).getDistance_Cargaison()));
        Menu.cyan(FindCargaison(1003).Type());

    }
}
