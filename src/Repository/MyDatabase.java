package Repository;
import Models.*;

public class MyDatabase {
//
//    private static int n =100;
//    private static  Marchandise[] marchandises = new Marchandise[n];
//    private static  Ca_Aerienne[] ca_aeriennes = new Ca_Aerienne[n];
//    private static  Ca_Routieere[] ca_routieeres = new Ca_Routieere[n];
//    private static  Client[] clients = new Client[n];
//    private static  Admin[] admins = new Admin[n];
//
//    public static Marchandise[] getMarchandises() {
//        return marchandises;
//    }
//
//    public static Ca_Aerienne[] getCa_aeriennes() {
//        return ca_aeriennes;
//    }
//
//    public static Ca_Routieere[] getCa_routieeres() {
//        return ca_routieeres;
//    }
//
//    public static Client[] getClients() {
//        return clients;
//    }
//
//    public static Admin[] getAdmins() {
//        return admins;
//    }
//
//    public static void main(String [] args){
//        AddClient("cyassine", "yassine");
//        AddClient("cahmed", "ahmed");
//        AddAdmin("ayassine", "yassine");
//        AddAdmin("aahmed", "ahmed");
//        AddCa_Routiere(13);
//        AddCa_Routiere(1113);
//        AddCa_Aerienne(12);
//        AddCa_Aerienne(1112);
//        AddMarchandise(15,30);
//        AddMarchandise(30,40);
//        AddMarchandise(35,32);
//        AddMarchandise(10,40);
//        AddMarchandise(65,32);
//        AddMarchandise(20,47);
//        AddMarchandise(5,39);
//        AddMarchandise(56,40);
////        Client.ConsulterCargaison(1000);
//        marchandises[0].setId_Cargaison(1001);
//        marchandises[7].setId_Cargaison(1001);
//        Menu.Welcome();
//    }
//    public static Admin findAdmin(int id_Admin){
//        boolean found = false;
//        for (int i = 0; i < 10; i++) {
//            if (admins[i].getId_User() == id_Admin) {
//                found = true;
//                return admins[i];
//            }
//        }
//        Menu.error("Model.Admin with id: " + Integer.toString(id_Admin) + " not found");
//        System.exit(0);
//        return admins[0];
//    }
//    public static Client findClient(int id_Client){
//        boolean found = false;
//        for (int i = 0; i < 10; i++) {
//            if (clients[i].getId_User() == id_Client) {
//                found = true;
//                return clients[i];
//            }
//        }
//
//        Menu.error("Model.Client with id: " + Integer.toString(id_Client) + " not found");
//        System.exit(0);
//        return clients[0];
//    }
//    public static Marchandise findMarchandise(int id_Marchandise) {
//        boolean found = false;
//        for (int i = 0; i < Marchandise.getNumberOfInstances(); i++) {
//            if (marchandises[i].getId_Marchandise() == id_Marchandise) {
//                found = true;
//                return marchandises[i];
//            }
//        }
//        Menu.error("Model.Marchandise with id: " + Integer.toString(id_Marchandise) + " not found");
//        System.exit(0);
//        return marchandises[0];
//    }
//    public static Cargaison findCargaisonById(int Id_Cargaison) {
//        for (int i=0; i<Ca_Routieere.getNumberOfInstancesRoutiere(); i++){
//            if (ca_routieeres[i].getId_Cargaison() == Id_Cargaison){
//                return ca_routieeres[i];
//            }
//        }
//        for (int i=0; i<Ca_Aerienne.getNumberOfInstancesAerienne(); i++){
//            if (ca_aeriennes[i].getId_Cargaison() == Id_Cargaison){
//                return ca_aeriennes[i];
//            }
//        }
//        Menu.error("Model.Cargaison with id: " + Integer.toString(Id_Cargaison) + " not found");
//        System.exit(0);
//        return ca_aeriennes[1];
//    }
//    public static void AddMarchandise(float poids_Marchandise, float volume_Marchandie){
//        marchandises[Marchandise.getNumberOfInstances()] = new Marchandise(poids_Marchandise, volume_Marchandie);
//        Marchandise.setNumberOfInstances(Marchandise.getNumberOfInstances()+1);
//    }
//    public static void AddAdmin(String username_User, String password_User){
//        admins[Admin.getNumberAdmin()] = new Admin(username_User,password_User);
//        Admin.setNumberAdmin(Admin.getNumberAdmin()+1);
//    }
//    public static void AddClient(String username_User, String password_User){
//        clients[Client.getNumberClient()] = new Client(username_User, password_User);
//        Client.setNumberClient(Client.getNumberClient()+1);
//    }
//    public static void AddCa_Aerienne(double distance_Cargaison){
//        ca_aeriennes[Ca_Aerienne.getNumberOfInstancesAerienne()] = new Ca_Aerienne(distance_Cargaison);
//        Ca_Aerienne.setNumberOfInstancesAerienne(Ca_Aerienne.getNumberOfInstancesAerienne()+1);
//    }
//    public static void AddCa_Routiere(double distance_Cargaison){
//        ca_routieeres[Ca_Routieere.getNumberOfInstancesRoutiere()] = new Ca_Routieere(distance_Cargaison);
//        Ca_Routieere.setNumberOfInstancesRoutiere(Ca_Routieere.getNumberOfInstancesRoutiere()+1);
//    }
//
//    public static void SupprimerCargaison(int id_cargaison) {
//        for (int i=0; i<Ca_Routieere.getNumberOfInstancesRoutiere();i++){
//            if (ca_routieeres[i].getId_Cargaison() == id_cargaison){
//               for (int j=i;j<Ca_Routieere.getNumberOfInstancesRoutiere();j++){
//                   ca_routieeres[j] = ca_routieeres[j+1];
//                   Ca_Routieere.setNumberOfInstances(Ca_Routieere.getNumberOfInstancesRoutiere()-1);
//                   Cargaison.setNumberOfInstances(Cargaison.getNumberOfInstancesCargaison()-1);
//               }
//               ca_routieeres[Ca_Routieere.getNumberOfInstancesRoutiere()] = null;
//            }
//        }
//        for (int i=0; i<Ca_Aerienne.getNumberOfInstancesAerienne();i++){
//            if (ca_aeriennes[i].getId_Cargaison() == id_cargaison){
//                for (int j=i;j<Ca_Aerienne.getNumberOfInstancesAerienne();j++){
//                    ca_aeriennes[j] = ca_aeriennes[j+1];
//                    Ca_Aerienne.setNumberOfInstances(Ca_Aerienne.getNumberOfInstancesAerienne()-1);
//                    Cargaison.setNumberOfInstances(Cargaison.getNumberOfInstancesCargaison()-1);
//                }
//                ca_aeriennes[Ca_Aerienne.getNumberOfInstancesAerienne()] = null;
//            }
//        }
//    }

}
