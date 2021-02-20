package Kernel;

import Models.Cargaison;
import Models.Marchandise;

import java.util.ArrayList;
import java.util.Collections;

public class MarIdSorter {
    public static ArrayList<Marchandise> Sort(ArrayList<Marchandise> marchandises){
        for (int i=0; i<marchandises.size();i++) {
            if (i<0)
                i=0;
            if (i!= marchandises.size()-1 && marchandises.get(i).getId_Marchandise() > marchandises.get(i+1).getId_Marchandise()){
                Collections.swap(marchandises, i, i+1);
                i-=2;
            }
        }
        return marchandises;
    }
}
