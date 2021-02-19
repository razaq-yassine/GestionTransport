package Views;

import Kernel.Settings;
import Models.*;
import Repository.DB;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SocieteTransport {
    static public DB d = new DB();
    public static User login(String username, String Password){
        return DB.LoginAttempt(username,Password);
        // test if User is null in gui means login-error
    }
    public static boolean register(String username, String Password, String Type){
        return DB.Register(username, Password, Type);
        // You can add Password confirmation in method of GUI Class
    }
    public static Cargaison ConsulterCargaison(int id_Cargaison){
        return DB.FindCargaison(id_Cargaison);
    }
    public static Marchandise ConsulterMarchandise(int id_Marchandise){
        return DB.FindMarchandise(id_Marchandise);
    }
    public static boolean AjouterCargaison(double disrance_Cargaison, String Type){
        if (Type.equals("Cargaison Aerienne")){
            return DB.AddCa_Aerienne(disrance_Cargaison);
        }
        return DB.AddCa_Routiere(disrance_Cargaison);
    }
    public static boolean AjouterMarchandise(float poids, float volume, int id_Cargason){
        return DB.AddMarchandise(poids,volume,id_Cargason);
    }
    public static boolean AjouterMarchandiseDansCargaison(int id_Marchandise, int id_Cargaison){
        return DB.AjouterMarchandiseDansCargaison(id_Marchandise, id_Cargaison);
    }
    public static int NombreTotaleCargaisons(){
        return DB.getNumberOfCargaisons();
    }
    public static int NombreTotaleMarchandises(){
        return DB.getNumberOFMarchandises();
    }
    public static boolean EditCargaison(int id_Cargaison, double distance_Cargaison){
        return DB.EditCargaison(id_Cargaison, distance_Cargaison);
    }

    public static boolean EditMarchandise(int id_Marchandise, float poids, float volume, int id_Cargason){
        return DB.EditMarchandise(id_Marchandise, poids, volume, id_Cargason);
    }
    public static ArrayList<Marchandise> GetAllMarchandises(){
        return DB.getMarchandises();
    }
    public static ArrayList<Cargaison> GetAllCargaisons(){
        return DB.getAllCargaisons();

    }
    public static String DB_Type(){
        return Settings.DB_Type();
    }
    public String DB_File(){
        return Settings.ExternalDB_FilePath();
    }
    public boolean setDB_Type(String type){
        Settings.setDB_Type(type);
        return true;
    }
    public boolean setExternalDB(String ExternalDBPath){
        Settings.setExternalDB_FilePath(ExternalDBPath);
        return true;
    }

    public static void main(String[] args) {
        // test something here to check if problem from back end
        Menu.cyan(Boolean.toString(register("anaadmin", "admin", "admin")));
    }
}