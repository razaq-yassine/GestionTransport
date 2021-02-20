package Kernel;

import Models.Marchandise;
import Models.Menu;
import Repository.DB;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyFile implements Serializable{
    private String Path;
    public MyFile(String path){
        Path= path;
    }
    public String Read(){
        try {
            File myObj = new File(this.Path);
            Scanner myReader = new Scanner(myObj);
            String data = "";
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() +"\n";
            }
            myReader.close();
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while finding file.");
            e.printStackTrace();
        }
        return "";
    }
    public ArrayList<String> ReadLines(){
        ArrayList<String> Lines = new ArrayList<>();
        try {
            File myObj = new File(this.Path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                Lines.add(myReader.nextLine());
            }
            myReader.close();
            return Lines;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while finding file.");
            e.printStackTrace();
        }
        return Lines;
    }
    public void OverWriteBy(String OverWritingText){

        try {
            FileWriter f2 = new FileWriter(new File(Path), false);
            f2.write(OverWritingText);
            f2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void OverWriteByObject(Object object){
        try {

            FileOutputStream fos = new FileOutputStream(Path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void Append(String Text) {
        try{
            FileWriter fw = new FileWriter(Path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Text);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<ArrayList> ReadArrayList(){
        try{
            FileInputStream fis = new FileInputStream(Path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<ArrayList> MyArrayList = (ArrayList<ArrayList>) ois.readObject();
            ois.close();
            return MyArrayList;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {


    }
}
