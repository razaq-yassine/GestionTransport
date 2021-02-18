package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddCargaisonPage implements ActionListener {

    AddCargaisonPage(){}

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
    static private JTextField text1;
    //radio buttons
    static private JRadioButton radioRoutiere, radioAerienne;
    //ButtonGroup
    static private ButtonGroup btnGrp;

    private void initButtons()
    {
        btnAdd = new JButton("Ajouter");
        btnAdd.setFont(Btnfont);
        btnAdd.setBounds(150, 200, 100, 25);
        btnAdd.addActionListener(new AddCargaisonPage());

        btnBack = new JButton("Retour");
        btnBack.setBounds(300, 330, 80, 25);
        btnBack.addActionListener(new AddCargaisonPage());

    }

    private void initLabels()
    {
        Title = new JLabel("Ajouter Cargaison");
        Title.setBounds(120, 30, 300, 25);
        Title.setFont(Titlefont);


        message = new JLabel();
        message.setBounds(30, 100, 180, 25);
        message.setFont(Labelfont);
        message.setForeground(Color.red);


        label1 = new JLabel("Distance :");
        label1.setBounds(30, 80, 150, 25);
        label1.setFont(Labelinfo);

        label3 = new JLabel("Type :");
        label3.setBounds(30, 130, 150, 25);
        label3.setFont(Labelinfo);

        label2 = new JLabel("EMSI © 2020-2021 All rights reserved ;)");
        label2.setBounds(10, 338, 340, 25);
        label2.setFont(Labelinfo);
        label2.setForeground(Color.BLACK);


    }

    private void initTextField()
    {
        text1 = new JTextField(10);
        text1.setBounds(100, 80, 165, 25);
        text1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = text1.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    text1.setEditable(true);
                    message.setText("");
                } else {
                    text1.setText("");
                    message.setText("* Champs numeric obligatoire (0-9)");
                }
            }
        });
    }

    private void initJradioButtons()
    {
        radioRoutiere = new JRadioButton("Cargaison Routiere");
        radioRoutiere.setBounds(100,130,160,25);
        radioRoutiere.addActionListener(new LoginPage());

        radioAerienne = new JRadioButton("Cargaison Aerienne");
        radioAerienne.setBounds(100,160,160,25);
        radioAerienne.addActionListener(new LoginPage());
        radioAerienne.setSelected(true);

        btnGrp = new ButtonGroup();
        btnGrp.add(radioRoutiere);
        btnGrp.add(radioAerienne);
    }

    JPanel initPanels()
    {
        initLabels();
        initTextField();
        initButtons();
        initJradioButtons();

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.add(Title);
        contentPanel.add(message);
        contentPanel.add(btnBack);
        contentPanel.add(text1);
        contentPanel.add(label1);
        contentPanel.add(label2);
        contentPanel.add(label3);
        contentPanel.add(radioAerienne);
        contentPanel.add(radioRoutiere);
        contentPanel.add(btnAdd);

        contentPanel.setBorder(BorderFactory.createTitledBorder("Nouvelle Cargaison"));

        return contentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack)
        {
            HomePage homeP = new HomePage();
            Layout.getInstance("test").switchPanel(homeP.initPanels(), HomePage.width, HomePage.height);
        }
    }
}
