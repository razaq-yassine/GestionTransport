package Model;

import Repository.MyDatabase;

public class Cargaison {
    private static int count = 1000;
    private int id_Cargaison;
    private double distance_Cargaison;
    private double cout_Cargaison;
    static private int numberOfInstancesCargaison = 0;

    Cargaison(double distance_Cargaison) {
        id_Cargaison=++count;
        this.distance_Cargaison = distance_Cargaison;
    }

    public static void setNumberOfInstancesCargaison(int numberOfInstancesCargaison) {
        Cargaison.numberOfInstancesCargaison = numberOfInstancesCargaison;
    }

    public static int getNumberOfInstancesCargaison() {
        return numberOfInstancesCargaison;
    }

    public int getId_Cargaison() {
        return id_Cargaison;
    }

    public void setId_Cargaison(int id_Cargaison) {
        this.id_Cargaison = id_Cargaison;
    }

    public static int getNumberOfInstances() {
        return numberOfInstancesCargaison;
    }

    public static void setNumberOfInstances(int numberOfInstances) {
        Cargaison.numberOfInstancesCargaison = numberOfInstances;
    }

    static int getCount() {
        return count;
    }


    public double getDistance_Cargaison() {
        return distance_Cargaison;
    }

    public void setDistance_Cargaison(double distance_Cargaison) {
        this.distance_Cargaison = distance_Cargaison;
    }

    public double getCout_Cargaison() {
        return cout_Cargaison;
    }

    public void setCout_Cargaison(double cout_Cargaison) {
        this.cout_Cargaison = cout_Cargaison;
    }

    // Methods
    public void AjouterMarchandise(int id_Marchandise){
        MyDatabase.findMarchandise(id_Marchandise).setId_Cargaison(this.id_Cargaison);
    }
    public void SupprimerMarchandise(int id_Marchandise){
        MyDatabase.findMarchandise(id_Marchandise).setId_Cargaison(0);
    }
    public void ConsulterMarchandise(int id_Marchandise){
        MyDatabase.findMarchandise(id_Marchandise).Afficher();
    }
    public void ConsulterTouteLesMarchandise(){
        Marchandise marchandises[] = MyDatabase.getMarchandises();
        for(int i=0; i<Marchandise.getNumberOfInstances(); i++){
           if (marchandises[i].getId_Cargaison() == id_Cargaison)
               marchandises[i].Afficher();
        }
    }
    public double PoidsTotale(){
        Marchandise[] marchandises = MyDatabase.getMarchandises();
        double PoidsTotale = 0;
        for(int i = 0; i<Marchandise.getNumberOfInstances() -1; i++){
           if (marchandises[i].getId_Cargaison() == this.getId_Cargaison()){
               PoidsTotale+=marchandises[i].getPoids_Marchandise();
           }
        }
        return PoidsTotale;
    }
    public double VolumeTotale(){
        Marchandise[] marchandises = MyDatabase.getMarchandises();
        double VolumeTotale = 0;
        for(int i = 0; i<Marchandise.getNumberOfInstances() -1 ; i++){
            if (marchandises[i].getId_Cargaison() == this.getId_Cargaison()){
                VolumeTotale+=marchandises[i].getVolume_Marchandie();
            }
        }
        return VolumeTotale;
    }

    public double Cout() {
        return 0;
    }

    public int NumberOfMarchandises(){
        Marchandise[] marchandises = MyDatabase.getMarchandises();
        int counter = 0;
        for (int i=0; i<Marchandise.numberOfInstances ;i++)
            if (marchandises[i].getId_Cargaison() == id_Cargaison)
                counter++;
        return counter;
    }
    public void Afficher() {
        Menu.warnning1("-Id: ");
        System.out.println(Integer.toString(id_Cargaison));
        Menu.warnning1("-Distance: ");
        System.out.println(Double.toString(distance_Cargaison));
        Menu.warnning1("-Cout: ");
        System.out.println(Double.toString(cout_Cargaison));
        Menu.warnning1("-Nombre de marchandise: ");
        System.out.println(Double.toString(NumberOfMarchandises()));
    }
}
