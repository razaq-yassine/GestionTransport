package Model;

public class Ca_Routieere extends Cargaison {
    static private int numberOfInstancesRoutiere = 0;
    public Ca_Routieere(double distance_Cargaison) {
        super(distance_Cargaison);
    }

    public static void setNumberOfInstancesRoutiere(int numberOfInstancesRoutiere) {
        Ca_Routieere.numberOfInstancesRoutiere = numberOfInstancesRoutiere;
    }

    public static int getNumberOfInstancesRoutiere() {
        return numberOfInstancesRoutiere;
    }

    public double Cout(){
        if (super.VolumeTotale() < 380000){
            return 4*super.getDistance_Cargaison()*PoidsTotale();
        }
        else {
            return 6*super.getDistance_Cargaison()*PoidsTotale();
        }
    }
}
