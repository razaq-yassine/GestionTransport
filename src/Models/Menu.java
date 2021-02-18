package Models;

import Repository.MyDatabase;

import java.util.Scanner;
public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static public void purple(String text){System.out.println(ANSI_PURPLE+text+ANSI_RESET);}
    static public void success(String text){
        System.out.println(ANSI_GREEN+text+ANSI_RESET);
    }
    static public void error(String text){
        System.out.println(ANSI_RED+text+ANSI_RESET);
    }
    static public void warnning(String text){
        System.out.println(ANSI_YELLOW+text+ANSI_RESET);
    }
    static public void warnning1(String text){
        System.out.print(ANSI_YELLOW+text+ANSI_RESET);
    }
    static public void cyan(String text){
        System.out.println(ANSI_CYAN+text+ANSI_RESET);
    }
    public static void Welcome(){
        cyan("Bienvenu a l'application de gestion de transport");
        System.out.println("Veuiillez choisir votre choix");
        warnning("1: S'enregistrer");
        warnning("2: Se connecter");
        warnning("3: Quitter");
        Scanner userinput = new Scanner(System.in);
        int a= userinput.nextInt();
        switch (a){
            case 1: MenuSenregistrer(); break;
            case 2: MenuSeConnecter(); break;
            case 3: Quit(); break;
            default: warnning("Wrong input !"); Welcome(); break;
        }
    }
    public static void main(String[] args){
        Welcome();
    }

    private static void Quit() {
        System.exit(0);
    }

    private static void MenuSenregistrer() {
        cyan("Enregistrement en cours...");
        purple("1:Admin");
        purple("2:Client");
        warnning("0:Retour");
        Scanner userinput = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        int a=userinput.nextInt();
        String username,password;
        switch (a){
            case 1:
                warnning1("Username: ");
                username=input.nextLine();
                if(!User.UsernameExist(username)){
                    warnning1("Password: ");
                    password=input.nextLine();
                    MyDatabase.AddAdmin(username,password);
                    cyan("Enregistrement de \""+username+"\"");
                    Welcome();
                }
                else{ error("Username already used in DATABASE"); MenuSenregistrer();}
                break;
            case 2:
                warnning1("Username: ");
                username=input.nextLine();
                if(!User.UsernameExist(username)) {
                    warnning1("Password: ");
                    password = input.nextLine();
                    MyDatabase.AddClient(username, password);
                    cyan("Enregistrement de \""+username+"\"");
                    Welcome();
                }
                else{ error("Username already used in DATABASE"); MenuSenregistrer();}
                break;
            case 0: Welcome();
            default:
                error("INPUT ERROR. Please try again. Please Try agian"); MenuSenregistrer(); break;
        }
    }


    private static void MenuSeConnecter() {
        Scanner userinput = new Scanner(System.in);
        cyan("Entrer votre username et votre password ");
        warnning("Username: ");
        String username = userinput.nextLine();
        warnning("Password: ");
        String password = userinput.nextLine();
        Admin[] admins=MyDatabase.getAdmins();
        Client[] clients=MyDatabase.getClients();
        boolean found=false;
        for(int i = 0 ; i < Admin.getNumberAdmin(); i++){
            if(admins[i].Seconnecter(username,password)){
                found=true;
                IAdmin();
            }
        }
        for (int i=0; i< Client.getNumberClient(); i++){
            if(clients[i].Seconnecter(username,password)){
                found=true;
                IClient();
            }
        }
        if (!found)
            Menu.error("Wrong username or password"); Welcome();
    }

    private static void IClient() {
        cyan("Bienvenue a votre interface Client");
        System.out.println("Menu Client: ");
        warnning("1: Consulter une Cargaison sachant sa reference");
        warnning("2: Consulter une Marchandise sachant son numero");
        warnning("3: Lire le fichiers Cargaisons");
        warnning("4: Consulter toutes les cargaisons");
        warnning("0: Se deconnecter");
        Scanner input = new Scanner(System.in);
        int a=input.nextInt();
        switch (a){
            case 1: MenuConsulterCargaisonById(); break;
            case 2: MenuConsulterMarchandiseById(); break;
            case 3: MenuLireFichierCargaison(); break;
            case 4: MenuConsulterAllCargaison(); break;
            case 0: Welcome(); break;
            default: error("Wrong Input"); IClient(); break;
        }
    }

    private static void IAdmin() {
        cyan("Bienvenue a votre interface Admin");
        System.out.println("Menu Admin");
        warnning("1: Ajouter une nouvelle cargaison");
        warnning("2: Ajouter une marchandise a une cargaison");
        warnning("3: Suprimmer une cargaison");
        warnning("4: Enregistrer les cargaisons dans un fichier");
        warnning("0: Se deconnecter");
        Scanner input = new Scanner(System.in);
        int a=input.nextInt();
        switch (a){
            case 1: MenuAddCargaison(); break;
            case 2: MenuAddMarchandiseInCargaison(); break;
            case 3: MenuSupprimerCargaison(); break;
            case 4: MenuEnregistrerCargaisonsinFile(); break;
            case 0: Welcome(); break;
            default: error("Wrong Input"); IAdmin(); break;
        }
    }

    private static void MenuConsulterAllCargaison() {
        cyan("Consultation de toutes les cargaisons");
        Ca_Routieere[] ca_routieeres= MyDatabase.getCa_routieeres();
        Ca_Aerienne[] ca_aeriennes = MyDatabase.getCa_aeriennes();
        cyan("Cargaison Routiere: ");
        for (int i=0;i<Ca_Routieere.getNumberOfInstancesRoutiere();i++){
            Spliter();
            ca_routieeres[i].Afficher();
        }
        cyan("Cargaison Aerienne: ");
        for (int i=0;i<Ca_Aerienne.getNumberOfInstancesAerienne();i++){
            Spliter();
            ca_aeriennes[i].Afficher();
        }
        Scanner input = new Scanner(System.in);
        int a=input.nextInt();
        switch (a){
            case 0:IAdmin(); break;
        }
    }

    private static void MenuLireFichierCargaison() {

    }

    private static void MenuConsulterMarchandiseById() {
        cyan("Consultation d'une Marchandise: ");
        cyan("Donnez l'id du Marchandise: ");
        Scanner input = new Scanner(System.in);
        int a=input.nextInt();
        cyan("Affichage Marchandise");
        MyDatabase.findMarchandise(a).Afficher();
    }

    private static void MenuConsulterCargaisonById() {
        cyan("Consultation d'une Cargaison: ");
        cyan("Donnez l'id du Marchandise: ");
        Scanner input = new Scanner(System.in);
        int a=input.nextInt();
        MyDatabase.findCargaisonById(a).Afficher();
    }

    private static void MenuEnregistrerCargaisonsinFile() {
    }

    private static void MenuSupprimerCargaison() {
    }

    private static void MenuAddMarchandiseInCargaison() {

    }

    private static void MenuAddCargaison() {
        cyan("Ajout de cargaison");
        purple("Choississez le type: ");
        warnning("1: Cargaison aerienne");
        warnning("2: Cargaison routiere");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        switch (a){
            case 1: MenuAddCargaisonAerienne(); break;
            case 2: MenuAddCargaisonRoutiere(); break;
            default: error("Wrong Input"); IAdmin(); break;
        }
    }

    private static void MenuAddCargaisonRoutiere() {
        Scanner input = new Scanner(System.in);
        cyan("Ajout de cargaison ROUTIERE");
        warnning1("Distance: ");
        Double distance = input.nextDouble();
        MyDatabase.AddCa_Routiere(distance);
    }

    private static void MenuAddCargaisonAerienne() {
        Scanner input = new Scanner(System.in);
        cyan("Ajout de cargaison AERIENNE");
        warnning1("Distance: ");
        Double distance = input.nextDouble();
        MyDatabase.AddCa_Aerienne(distance);
    }

    public static void Spliter(){
        for (int i=0;i<25;i++)
        cyan("----");
    }
}
