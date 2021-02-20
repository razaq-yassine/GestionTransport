package Views;

import Kernel.MySession;
import Kernel.Settings;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage implements ActionListener {
    HomePage() {}

    //size
    static int width = 450;
    static int height = 400;
    //Fonts
    static private Font Btnfont = new Font("Candra", Font.ITALIC, 12);
    static private Font Titlefont = new Font("Candara", Font.PLAIN, 20);
    static private Font Labelfont = new Font("Candara", Font.BOLD, 14);

    //Buttons
    static private JButton btnCargaison, btnMarchandise, btnAddCargaison, btnAddMarchandise, btnMarchandiseToCargaison, btnLogout;
    //Labels
    static private JLabel Title, labelC;


    private void initButtons()
    {
        btnCargaison = new JButton("Consulter Cargaison");
        btnCargaison.setFont(Btnfont);
        btnCargaison.setBounds(50, 70, 160, 50);
        btnCargaison.addActionListener(new HomePage());

        btnMarchandise = new JButton("Consulter Marchandise");
        btnMarchandise.setFont(Btnfont);
        btnMarchandise.setBounds(220, 70, 160, 50);
        btnMarchandise.addActionListener(new HomePage());

        btnAddCargaison = new JButton("Ajouter Cargaison");
        btnAddCargaison.setFont(Btnfont);
        btnAddCargaison.setBounds(50, 150, 160, 50);
        btnAddCargaison.addActionListener(new HomePage());

        btnAddMarchandise = new JButton("Ajouter Marchandise");
        btnAddMarchandise.setFont(Btnfont);
        btnAddMarchandise.setBounds(220, 150, 160, 50);
        btnAddMarchandise.addActionListener(new HomePage());

        btnMarchandiseToCargaison = new JButton("Ajouter Marchandise à Cargaison");
        btnMarchandiseToCargaison.setFont(Btnfont);
        btnMarchandiseToCargaison.setBounds(100, 230, 240, 50);
        btnMarchandiseToCargaison.addActionListener(new HomePage());

        btnLogout = new JButton("Logout");
        btnLogout.setFont(Btnfont);
        btnLogout.setBounds(290, 330, 100, 25);
        btnLogout.addActionListener(new HomePage());
    }

    private void initLabels()
    {
        String userType;
        if (MySession.User().getType_User() == -1)
             userType = "Admin";
        else userType = "Client";

        Title = new JLabel("Bienvenue à votre interface "+ userType);
        Title.setBounds(70, 20, 300, 25);
        Title.setFont(Titlefont);

        labelC = new JLabel("EMSI © 2020-2021 All rights reserved ;)");
        labelC.setBounds(10, 338, 340, 25);
        labelC.setFont(Labelfont);
        labelC.setForeground(Color.BLACK);
    }

    JPanel initPanels()
    {
        initLabels();
        initButtons();

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.add(Title);
        contentPanel.add(btnCargaison);
        contentPanel.add(btnMarchandise);
        if (MySession.User().getType_User() == -1)
        {
            contentPanel.add(btnAddCargaison);
            contentPanel.add(btnAddMarchandise);
            contentPanel.add(btnMarchandiseToCargaison);
        }
        contentPanel.add(labelC);
        contentPanel.add(btnLogout);

        contentPanel.setBorder(BorderFactory.createTitledBorder("Home"));

        return contentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCargaison) {
            CargaisonPage carP = new CargaisonPage();
            Layout.getInstance("Consulter Cargaison").switchPanel(carP.initPanels(), CargaisonPage.width, CargaisonPage.height);
        }
        if (e.getSource() == btnMarchandise) {
            MarchandisePage marP = new MarchandisePage();
            Layout.getInstance("Consulter Marchandise").switchPanel(marP.initPanels(), MarchandisePage.width, MarchandisePage.height);
        }
        if (e.getSource() == btnAddCargaison) {
            AddCargaisonPage addC = new AddCargaisonPage();
            Layout.getInstance("Ajouter Cargaison").switchPanel(addC.initPanels(), AddCargaisonPage.width, AddCargaisonPage.height);
        }
        if (e.getSource() == btnAddMarchandise) {
            AddMarchandisePage addM = new AddMarchandisePage();
            Layout.getInstance("Ajouter Marchandise").switchPanel(addM.initPanels(), AddMarchandisePage.width, AddMarchandisePage.height);
        }
        if (e.getSource() == btnMarchandiseToCargaison) {
            AddMarchandiseToCargaison addMC = new AddMarchandiseToCargaison();
            Layout.getInstance("Ajouter Marchandise à Cargaison").switchPanel(addMC.initPanels(), AddMarchandiseToCargaison.width, AddMarchandiseToCargaison.height);
        }
        if (e.getSource() == btnLogout){
            MySession.destroyCurrentUser();
            LoginPage loginPage = new LoginPage();
            Layout.getInstance("test").switchPanel(loginPage.initPanels(), LoginPage.width, LoginPage.height);
        }
    }
}
