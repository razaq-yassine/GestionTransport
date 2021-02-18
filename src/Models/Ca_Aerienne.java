package Models;

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
    public void Afficher() {
        Menu.error("Afficher from Aerieene");
        Menu.warnning1("-Id: ");
        System.out.println(Integer.toString(super.getId_Cargaison()));
        Menu.warnning1("-Distance: ");
        System.out.println(Double.toString(super.getDistance_Cargaison()));
        Menu.warnning1("-Cout: ");
        System.out.println(Double.toString(super.getCout_Cargaison()));
        Menu.warnning1("-Nombre de marchandise: ");
        System.out.println(Double.toString(NumberOfMarchandises()));

    }
}
