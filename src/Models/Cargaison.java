package Models;

import Repository.DB;
import Repository.MyDatabase;

public abstract class Cargaison {
    private static int count = 1000;
    private int id_Cargaison;
    private double distance_Cargaison;

    public Cargaison(double distance_Cargaison) {
        id_Cargaison=++count;
        this.distance_Cargaison = distance_Cargaison;
    }


    public int getId_Cargaison() {
        return id_Cargaison;
    }

    public double getDistance_Cargaison() {
        return distance_Cargaison;
    }

    public void setDistance_Cargaison(double distance_Cargaison) {
        this.distance_Cargaison = distance_Cargaison;
    }

    // Methods
    public boolean AjouterMarchandise(int id_Marchandise){
        Marchandise M = DB.FindMarchandise(id_Marchandise);
        if (M != null){
           M.setId_Cargaison(this.id_Cargaison);
           return true;
        }
        return false;
    }
    public boolean SupprimerMarchandise(int id_Marchandise){
        Marchandise M = DB.FindMarchandise(id_Marchandise);
        if (M != null){
            M.setId_Cargaison(0);
            return true;
        }
        return false;
    }
    public abstract double Cout();
    public abstract String Type();

    public int NumberOfMarchandises(){
        int counter = 0;
        for( int i = 0; i< DB.getMarchandises().size(); i++){
            if (DB.getMarchandises().get(i).getId_Cargaison() == this.id_Cargaison){
                counter++;
            }
        }
        return counter;
    }
    public double PoidsTotale(){
        double PoidsTotale = 0;
        for( int i = 0; i< DB.getMarchandises().size(); i++){
            if (DB.getMarchandises().get(i).getId_Cargaison() == this.id_Cargaison){
                PoidsTotale += DB.getMarchandises().get(i).getPoids_Marchandise();
            }
        }
        return PoidsTotale;
    }
    public double VolumeTotale(){

        double VolumeTotale = 0;
        for( int i = 0; i< DB.getMarchandises().size(); i++){
            if (DB.getMarchandises().get(i).getId_Cargaison() == this.id_Cargaison){
                VolumeTotale += DB.getMarchandises().get(i).getVolume_Marchandie();
            }
        }
        return VolumeTotale;
    }
}
