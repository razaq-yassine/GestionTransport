package Models;

import java.io.Serializable;

public class Ca_Aerienne extends Cargaison implements Serializable {

    public Ca_Aerienne(double distance_Cargaison) {
        super(distance_Cargaison);
    }


    public double Cout(){
        if (super.VolumeTotale() < 8000){
            return 10*super.getDistance_Cargaison()*PoidsTotale();
        }
        else {
            return 12*super.getDistance_Cargaison()*PoidsTotale();
        }
    }
    public String Type() {
        return "Aerienne";
    }
}
