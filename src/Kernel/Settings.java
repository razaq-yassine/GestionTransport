package Kernel;

public class Settings {
    public static String DB_Type(){
        return "RAM";
    }
    public static String DB_FilePath(){
        return "C:/DB.TXT";
    }
    public static boolean setDB_Type(String Type){
        return true;
    }
    public static boolean setDB_FilePath(String FilePath){
        return true;
    }
}
