package Kernel;

import Models.Cargaison;

import java.util.ArrayList;
import java.util.Collections;

public class CarIdSorter {
    public static ArrayList<Cargaison> Sort(ArrayList<Cargaison> cargaisons){
        for (int i=0; i<cargaisons.size();i++) {
            if (i<0)
                i=0;
            if (i!= cargaisons.size()-1 && cargaisons.get(i).getId_Cargaison() > cargaisons.get(i+1).getId_Cargaison()){
                Collections.swap(cargaisons, i, i+1);
                i-=2;
            }
        }
        return cargaisons;
    }
}
