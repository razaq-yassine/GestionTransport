package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddMarchandiseToCargaison implements ActionListener {

    AddMarchandiseToCargaison(){};

    //size
    static int width = 400;
    static int height = 400;
    //Fonts
    static private Font Btnfont = new Font("Candra", Font.ITALIC, 12);
    static private Font Titlefont = new Font("Candara", Font.PLAIN, 20);
    static private Font Labelfont = new Font("Candara", Font.BOLD, 10);
    static private Font Labelinfo = new Font("Candara", Font.ITALIC, 14);
    //Buttons
    static private JButton btnAdd, btnBack;
    //Labels
    static private JLabel Title,message, label1, label2, label3;
    //text field
    static private JComboBox listC, listM;

    private void initButtons()
    {
        btnAdd = new JButton("Ajouter");
        btnAdd.setFont(Btnfont);
        btnAdd.setBounds(130, 200, 100, 25);
        btnAdd.addActionListener(new AddMarchandiseToCargaison());

        btnBack = new JButton("Retour");
        btnBack.setBounds(300, 330, 80, 25);
        btnBack.addActionListener(new AddMarchandiseToCargaison());

    }

    private void initLabels()
    {
        Title = new JLabel("Ajouter Marchandise à une Cargaison");
        Title.setBounds(40, 30, 350, 25);
        Title.setFont(Titlefont);


        message = new JLabel();
        message.setBounds(30, 100, 180, 25);
        message.setFont(Labelfont);
        message.setForeground(Color.red);


        label1 = new JLabel("Cargaisons         :");
        label1.setBounds(30, 80, 150, 25);
        label1.setFont(Labelinfo);

        label3 = new JLabel("Marchandises   :");
        label3.setBounds(30, 130, 150, 25);
        label3.setFont(Labelinfo);

        label2 = new JLabel("EMSI © 2020-2021 All rights reserved ;)");
        label2.setBounds(10, 338, 340, 25);
        label2.setFont(Labelinfo);
        label2.setForeground(Color.BLACK);


    }

    private void initComboBox()
    {
        listC = new JComboBox();
        listC.setBounds(130, 80, 165, 25);

        listM = new JComboBox();
        listM.setBounds(130, 130, 165, 25);
    }

    JPanel initPanels()
    {
        initLabels();
        initComboBox();
        initButtons();

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.add(Title);
        contentPanel.add(message);
        contentPanel.add(btnBack);
        contentPanel.add(listC);
        contentPanel.add(listM);
        contentPanel.add(label1);
        contentPanel.add(label2);
        contentPanel.add(label3);
        contentPanel.add(btnAdd);

        contentPanel.setBorder(BorderFactory.createTitledBorder("Gestion"));

        return contentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack)
        {
            HomePage homeP = new HomePage();
            Layout.getInstance("Home").switchPanel(homeP.initPanels(), HomePage.width, HomePage.height);
        }
    }
}
