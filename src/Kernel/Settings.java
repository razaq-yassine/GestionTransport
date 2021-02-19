package Kernel;

import Models.Menu;

import java.io.File;
import java.io.IOException;

public class Settings {
    public static String SettingsPath;

    static {
        try {
            SettingsPath = new File("src/Kernel/Settings.txt").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String DB_Type(){
        return new MyFile(SettingsPath).ReadLines().get(0).split("=")[1].trim();
    }
    public static String ExternalDB_FilePath(){
        return new MyFile(SettingsPath).ReadLines().get(1).split("=")[1].trim();
    }
    public static void setDB_Type(String type){
        MyFile F = new MyFile(SettingsPath);
        String SettingsTXT = F.Read();
        String[] arrOfStr = SettingsTXT.split("\n");
        arrOfStr[0]  = "DB_Type = " + type.trim();
        String NewText = String.join("\n", arrOfStr);
        F.OverWriteBy(NewText);
    }
    public static void setExternalDB_FilePath(String External){
        MyFile F = new MyFile(SettingsPath);
        String SettingsTXT = F.Read();
        String[] arrOfStr = SettingsTXT.split("\n");
        arrOfStr[1] = "ExternalDB_Path = "+ External.trim();
        String NewText = String.join("\n", arrOfStr);
        F.OverWriteBy(NewText);
    }
    public static String getLocalDb_Path() {
        try {
            return  new File("src/Repository/DB").getCanonicalPath();
        }
        catch (IOException e){
        }
        return "";
    }

}
