package Models;

import Repository.MyDatabase;

public class Admin extends Client {
    static int NumberAdmin = 0;

    public static int getNumberAdmin() {
         return NumberAdmin;
    }

    public Admin(String username_User, String password_User) {
        super(username_User, password_User);
         super.setType_User(-1);
    }

    public static void setNumberAdmin(int numberAdmin) {
        NumberAdmin = numberAdmin;
    }

    public void AjouterCargaison(float poids_Marchandise, float volume_Marchandie){
        MyDatabase.AddMarchandise(poids_Marchandise, volume_Marchandie);
    }
    public void AjouterMarchandiseACargaison(int id_Marchandise, int id_Cargaison){
        MyDatabase.findMarchandise(id_Marchandise).setId_Cargaison(id_Cargaison);
    }
    public void SupprimerCargaison(int id_Cargaison){
        MyDatabase.SupprimerCargaison(id_Cargaison);
    }
    public void EnregistrerCargaisonFichier(){

    }
}
