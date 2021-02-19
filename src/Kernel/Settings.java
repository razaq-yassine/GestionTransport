package Kernel;


public class Settings {
    private static ClassLoader classLoader = Settings.class.getClassLoader();
    public static String SettingsPath = "Kernel/Settings.txt";
    public static String DB_Type(){
        return new MyFile(classLoader.getResource(SettingsPath).getFile()).ReadLines().get(0);
    }
    public static String DB_FilePath(){
        return new MyFile(SettingsPath).ReadLines().get(1);
    }
    public static String ExternalDB_FilePath(){
        return new MyFile(SettingsPath).ReadLines().get(2);
    }
    public static void setDB_Type(String Type){
        MyFile F = new MyFile(SettingsPath);
        String SettingsTXT = F.Read();
        String[] arrOfStr = SettingsTXT.split("\n");
        arrOfStr[0] = Type;
        String NewText = String.join("\n", arrOfStr);
        F.OverWriteBy(NewText);
    }
    public static void setDB_FilePath(String FilePath){
        MyFile F = new MyFile(SettingsPath);
        String SettingsTXT = F.Read();
        String[] arrOfStr = SettingsTXT.split("\n");
        arrOfStr[1] = FilePath;
        String NewText = String.join("\n", arrOfStr);
        F.OverWriteBy(NewText);
    }
    public static void setExternalDB_FilePath(String External){
        MyFile F = new MyFile(SettingsPath);
        String SettingsTXT = F.Read();
        String[] arrOfStr = SettingsTXT.split("\n");
        arrOfStr[2] = External;
        String NewText = String.join("\n", arrOfStr);
        F.OverWriteBy(NewText);
    }

}
