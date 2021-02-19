package Views;

import Kernel.Settings;
import Models.*;

import java.util.List;
import java.util.Set;

public class SocieteTransport {

    public static boolean login(String username, String Password){
        return true;
    }
    public static boolean register(String username, String Password, String Type){
        return true;
    } // You can add Password confirmation in method of GUI Class
    public static Cargaison ConsulterCargaison(int id_Cargaison){
        return new Ca_Aerienne(13);
    }
    public static Marchandise ConsulterMarchandose(int id_Marchandise){
        return new Marchandise(12,12);
    }
    public static boolean AjouterCargaison(double disrance_Cargaison, String Type){
        return true;
    }
    public static boolean AjouterMarchandise(double poids, double volume, int id_Cargason){
        return true;
    }
    public static boolean AjouterMarchandiseDansCargaison(int id_Marchandise, int id_Cargaison){
        return true;
    }
    public static int NombreTotaleCargaisons(){
        return 10;
    }
    public static int NombreTotaleMarchandises(){
        return 10;
    }
    public static boolean EditCargaison(int id_Cargaison, double disrance_Cargaison, String Type){
        return true;
    }
    public static boolean EditMarchandise(int id_Marchandise, double poids, double volume, int id_Cargason){
        return true;
    }
    public static List<Marchandise> GetAllMarchandises(){
        List<Marchandise> L1 = null;
        L1.add(new Marchandise(13,12));
        return L1;
    }
    public static List<Cargaison> GetAllCargaisons(){
        List<Cargaison> L1 = null;
        L1.add(new Ca_Routieere(12));
        return L1;
    }
    public static String DB_Type(){
        return Settings.DB_Type();
    }
    public String DB_File(){
        return Settings.DB_FilePath();
    }
    public boolean setDB_Type(String Type){
        return Settings.setDB_Type(Type);
    }
    public boolean setDB_FilePath(String FilePath){
        return Settings.setDB_FilePath(FilePath);
    }

}