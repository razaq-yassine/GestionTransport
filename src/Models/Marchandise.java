package Models;

import java.io.Serializable;

public class Marchandise implements Serializable {
    static private int count = 1000;
    private int id_Marchandise;
    private float Poids_Marchandise;
    private float Volume_Marchandie;
    private int id_Cargaison=0;

    public static void setNumberOfInstances(int numberOfInstances) {
        Marchandise.numberOfInstances = numberOfInstances;
    }

    static  int numberOfInstances = 0;

    public Marchandise(float poids_Marchandise, float volume_Marchandie) {
        id_Marchandise = ++count;
        Poids_Marchandise = poids_Marchandise;
        Volume_Marchandie = volume_Marchandie;
    }

    // Getters and setters
    public int getId_Marchandise() {
        return id_Marchandise;
    }

    public float getPoids_Marchandise() {
        return Poids_Marchandise;
    }

    public void setPoids_Marchandise(float poids_Marchandise) {
        Poids_Marchandise = poids_Marchandise;
    }

    public float getVolume_Marchandie() {
        return Volume_Marchandie;
    }

    public void setVolume_Marchandie(float volume_Marchandie) {
        Volume_Marchandie = volume_Marchandie;
    }

    public int getId_Cargaison() {
        return id_Cargaison;
    }

    public void setId_Cargaison(int id_Cargaison) {
        this.id_Cargaison = id_Cargaison;
    }

    public static int getNumberOfInstances(){
        return numberOfInstances;
    }
    // methods
    public void Afficher(){
        Menu.warnning1("-Id: ");
        System.out.println(Integer.toString(id_Cargaison));
        Menu.warnning1("-Poid: ");
        System.out.println(Double.toString(Poids_Marchandise));
        Menu.warnning1("-Volume: ");
        System.out.println(Double.toString(Volume_Marchandie));
    }
}
