package Model;

public class Ca_Aerienne extends Cargaison{
    static private int numberOfInstancesAerienne = 0;

    public Ca_Aerienne(double distance_Cargaison) {
        super(distance_Cargaison);
    }

    public static void setNumberOfInstancesAerienne(int numberOfInstancesAerienne) {
        Ca_Aerienne.numberOfInstancesAerienne = numberOfInstancesAerienne;
    }

    public static int getNumberOfInstancesAerienne() {
        return numberOfInstancesAerienne;
    }

    public double Cout(){
        if (super.VolumeTotale() < 8000){
            return 10*super.getDistance_Cargaison()*PoidsTotale();
        }
        else {
            return 12*super.getDistance_Cargaison()*PoidsTotale();
        }
    }

}
