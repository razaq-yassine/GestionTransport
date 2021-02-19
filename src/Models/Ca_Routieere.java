package Models;

public class Ca_Routieere extends Cargaison {

    public Ca_Routieere(double distance_Cargaison) {
        super(distance_Cargaison);
    }

    public double Cout(){
        if (super.VolumeTotale() < 380000){
            return 4*super.getDistance_Cargaison()*PoidsTotale();
        }
        else {
            return 6*super.getDistance_Cargaison()*PoidsTotale();
        }
    }

    @Override
    public String Type() {
        return "Cargaison Routiere";
    }
}
