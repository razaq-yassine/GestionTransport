package Model;

import Repository.*;

public class Client extends User {
    static int NumberClient=0;
    public Client(String username_User, String password_User) {
        super(username_User, password_User);
        super.setType_User(1);
    }

    public static void setNumberClient(int numberClient) {
        NumberClient = numberClient;
    }

    public static int getNumberClient() {
        return NumberClient;
    }

    public static void ConsulterCargaison(int id_Cargaison){
//            Ca_Aerienne ca_aeriennes[] = MyDatabase.getCa_aeriennes();
//            Ca_Routieere ca_routieeres[] = MyDatabase.getCa_routieeres();
//            for (int i = 0; i< ca_aeriennes[0].getCount() -1001; i++){
//                try {
//                    if (ca_aeriennes[i].getId_Cargaison() == id_Cargaison)
//                    {
//                    Menu.cyan("Id: "+Integer.toString(ca_aeriennes[i].getId_Cargaison()));
//                    Menu.cyan("Distance: : "+Double.toString(ca_aeriennes[i].getDistance_Cargaison()));
//                    Menu.cyan("Cout: "+Double.toString(ca_aeriennes[i].getCount()));
//                    break;}
//                }
//                catch (Exception e){}
//                try {
//                    if (ca_routieeres[i].getId_Cargaison() == id_Cargaison)
//                    {
//                        Menu.cyan("Id: "+Integer.toString(ca_routieeres[i].getId_Cargaison()));
//                        Menu.cyan("Distance: : "+Double.toString(ca_routieeres[i].getDistance_Cargaison()));
//                        Menu.cyan("Cout: "+Double.toString(ca_routieeres[i].getCount()));
//                        break;}
//                }
//                catch (Exception e){}
//
//            }
//

    }
    public void ConsulterMarchandise(int id_Marchandise){
        MyDatabase.findMarchandise(id_Marchandise).Afficher();
    }
    public void LireFichierCargaison(){

    }
    public void ConsulterToutesLesCargaison(){
        Ca_Routieere ca_routieeres[] = MyDatabase.getCa_routieeres();
        Ca_Aerienne ca_aerienne[] = MyDatabase.getCa_aeriennes();
        Menu.error("Cargaison Routiere");
        Menu.error("Number: "+ Integer.toString(Ca_Routieere.getNumberOfInstancesRoutiere()));
        Menu.Spliter();
        for (int i=0;i<Ca_Routieere.getNumberOfInstancesRoutiere();i++)
            ca_routieeres[i].Afficher();
        Menu.error("Cargaison Aerienne");
        Menu.error("Number: "+ Integer.toString(Ca_Aerienne.getNumberOfInstancesAerienne()));
        Menu.Spliter();
        for (int i=0;i<Ca_Aerienne.getNumberOfInstancesAerienne();i++)
            ca_aerienne[i].Afficher();
    }

}
