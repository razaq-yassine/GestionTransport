package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

final public class LoginPage implements ActionListener {

    LoginPage() {}

    //size
    static int width = 400;
    static int height = 400;
    //panels
    static private JPanel contentPanel,registerPanel = new JPanel(),text3Panel = new JPanel(),Pwtext3Panel = new JPanel(),Pwtext4Panel = new JPanel();
    //Fonts
    static private Font Btnfont = new Font("Candra", Font.ITALIC, 12);
    static private Font Titlefont = new Font("Candara", Font.PLAIN, 20);
    static private Font Labelfont = new Font("Candara", Font.BOLD, 14);
    static private Font Labelfont2 = new Font("Candara", Font.BOLD, 12);
    //Buttons
    static private JButton btnLogin, btnRegister, btnParam, btnSave, btnSaveRegister;
    //Labels
    static private JLabel label1, label2, Message, Title, labelC, label3, label4, Title2, label5, label6, label7;
    //text field
    static private JTextField text1, text2, text3;
    //password fiels
    static private JPasswordField Pwtext2, Pwtext3, Pwtext4;
    //JradioButtons
    static private JRadioButton radioRam, radioFile, radioAdmin, radioUser;
    //ButtonGroup
    static private ButtonGroup btnGrp;

    private void initButtons()
    {
        btnLogin = new JButton("Se Connecter");
        btnLogin.setFont(Btnfont);
        btnLogin.setBounds(50, 200, 120, 25);
        btnLogin.addActionListener(new LoginPage());

        btnRegister = new JButton("S'Enregistrer");
        btnRegister.setFont(Btnfont);
        btnRegister.setBounds(200, 200, 120, 25);
        btnRegister.addActionListener(new LoginPage());

        btnParam = new JButton("Parametres");
        btnParam.setFont(Btnfont);
        btnParam.setBounds(270, 330, 100, 25);
        btnParam.setName("login");
        btnParam.addActionListener(new LoginPage());
        //param
        btnSave = new JButton("Valider");
        btnSave.setFont(Btnfont);
        btnSave.setBounds(100, 180, 100, 25);
        btnSave.setName("login");
        btnSave.addActionListener(new LoginPage());
        btnSave.setVisible(false);
        //register
        btnSaveRegister = new JButton("S'inscrire");
        btnSaveRegister.setFont(Btnfont);
        btnSaveRegister.setBounds(100, 300, 100, 25);
        btnSaveRegister.addActionListener(new LoginPage());

    }

    private void initLabels()
    {
        Title = new JLabel("Gestion des Cargaisons");
        Title.setBounds(90, 20, 200, 25);
        Title.setFont(Titlefont);

        label1 = new JLabel("Nom d'utilisateur : ");
        label1.setBounds(50, 110, 120, 25);

        label2 = new JLabel("Mot de passe        : ");
        label2.setBounds(50, 140, 120, 25);

        Message = new JLabel();
        Message.setBounds(50, 170, 300, 25);
        Message.setFont(Labelfont);
        Message.setForeground(Color.red);

        labelC = new JLabel("EMSI © 2020-2021 All rights reserved ;)");
        labelC.setBounds(10, 338, 340, 25);
        labelC.setFont(Labelfont);
        labelC.setForeground(Color.BLACK);

        //parametre

        label3 = new JLabel("-Type DataBase : ");
        label3.setBounds(10, 50, 340, 25);
        label3.setFont(Labelfont);
        label3.setForeground(Color.BLACK);
        label3.setVisible(false);

        label4 = new JLabel("Database externe (path): ");
        label4.setBounds(25, 120, 160, 25);
        label4.setFont(Labelfont2);
        label4.setForeground(Color.BLACK);
        label4.setVisible(false);

        // register

        Title2 = new JLabel("Creez-votre compte ici");
        Title2.setBounds(90, 20, 200, 25);
        Title2.setFont(Titlefont);
        Title2.setVisible(false);

        label5 = new JLabel("Login                                   :");
        label5.setFont(Labelfont);
        label5.setForeground(Color.BLACK);
        label5.setVisible(false);

        label6 = new JLabel("Mot de passe                       :");
        label6.setFont(Labelfont2);
        label6.setForeground(Color.BLACK);
        label6.setVisible(false);

        label7 = new JLabel("Confirmer mot de passe    :");
        label7.setFont(Labelfont2);
        label7.setForeground(Color.BLACK);
        label7.setVisible(false);
    }

    private void initTextField()
    {
        text1 = new JTextField(20);
        text1.setBounds(180, 110, 165, 25);

        // parametre
        text2 = new JTextField(35);
        text2.setBounds(160, 120, 180, 25);
        text2.setVisible(false);
        text2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                btnGrp.clearSelection();
            }
        });
        //register
        text3 = new JTextField(15);
    }

    private void initPasswordField()
    {
        Pwtext2 = new JPasswordField(20);
        Pwtext2.setBounds(180, 140, 165, 25);

        // register
        Pwtext3 = new JPasswordField(15);

        Pwtext4 = new JPasswordField(15);
    }

    private void initJradioButtons()
    {
        radioRam = new JRadioButton("Ram DataBase");
        radioRam.setBounds(25,80,130,25);
        radioRam.addActionListener(new LoginPage());

        radioFile = new JRadioButton("File DataBase");
        radioFile.setBounds(150,80,130,25);
        radioFile.addActionListener(new LoginPage());
        radioFile.setSelected(true);

        btnGrp = new ButtonGroup();
        btnGrp.add(radioRam);
        btnGrp.add(radioFile);

        radioAdmin = new JRadioButton("Admin");
        radioAdmin.setBounds(25,80,130,25);
        radioAdmin.addActionListener(new LoginPage());

        radioUser = new JRadioButton("Utilisateur");
        radioUser.setBounds(150,80,130,25);
        radioUser.addActionListener(new LoginPage());
        radioUser.setSelected(true);

        ButtonGroup btnGrp2 = new ButtonGroup();
        btnGrp2.add(radioAdmin);
        btnGrp2.add(radioUser);
    }

    JPanel initPanels()
    {
        initLabels();
        initTextField();
        initPasswordField();
        initButtons();
        initJradioButtons();

        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.add(Title);
        contentPanel.add(label1);
        contentPanel.add(text1);
        contentPanel.add(label2);
        contentPanel.add(Pwtext2);
        contentPanel.add(Message);
        contentPanel.add(btnLogin);
        contentPanel.add(btnRegister);
        contentPanel.add(btnParam);
        contentPanel.add(labelC);

        contentPanel.setBorder(BorderFactory.createTitledBorder("login"));

        registerPage();

        return contentPanel;
    }

    private void parametresPage()
    {
        emptyParamComposant(true);

        contentPanel.setBorder(BorderFactory.createTitledBorder("Parametres"));
        contentPanel.add(label3);
        contentPanel.add(radioRam);
        contentPanel.add(radioFile);
        contentPanel.add(label4);
        contentPanel.add(text2);
        contentPanel.add(btnSave);
    }

    private void registerPage()
    {
        contentPanel.add(Title2);

        registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(5,2));
        registerPanel.setBounds(10, 60,380,250);
        registerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        registerPanel.add(label5);

        text3Panel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,20));
        text3Panel.add(text3);
        text3Panel.setMaximumSize( text3Panel.getPreferredSize() );
        registerPanel.add(text3Panel);

        registerPanel.add(label6);

        JPanel Pwtext3Panel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,20));
        Pwtext3Panel.add(Pwtext3);
        Pwtext3Panel.setMaximumSize( Pwtext3Panel.getPreferredSize() );
        registerPanel.add(Pwtext3Panel);

        registerPanel.add(label7);

        JPanel Pwtext4Panel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,20));
        Pwtext4Panel.add(Pwtext4);
        Pwtext4Panel.setMaximumSize( Pwtext4Panel.getPreferredSize() );

        registerPanel.add(Pwtext4Panel);
        registerPanel.add(radioAdmin);
        registerPanel.add(radioUser);
        registerPanel.add(btnSaveRegister);
        registerPanel.setVisible(false);

        contentPanel.add(registerPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin)
        {
            if (text1.getText().equals("ahmed"))
            {
                Message.setText("Success!!");
                Message.setForeground(Color.GREEN);
                HomePage homeP = new HomePage();
                Layout.getInstance("test").switchPanel(homeP.initPanels(), HomePage.width, HomePage.height);
            } else
            {
                Message.setText("Identifiant et / ou mot de passe incorrect(s) !");
                Message.setForeground(Color.RED);
            }

        }
        if (e.getSource() == btnParam)
        {
            if (btnParam.getName().equals("login"))
            {
                btnParam.setName("param");
                btnParam.setText("Retour");
                emptyLoginComposant(false);
                parametresPage();
            } else
            {
                btnParam.setName("login");
                contentPanel.setBorder(BorderFactory.createTitledBorder("Login"));
                btnParam.setText("Parametres");
                emptyParamComposant(false);
                emptyRegisterComposant(false);
                emptyLoginComposant(true);

            }

        }
        if (e.getSource() == btnRegister)
        {
            if (btnParam.getName().equals("login"))
            {
                contentPanel.setBorder(BorderFactory.createTitledBorder("S'enregistrer"));
                btnParam.setName("register");
                btnParam.setText("Retour");
                emptyLoginComposant(false);
                emptyRegisterComposant(true);
            }

        }
        if (e.getSource() == radioRam || e.getSource() == radioFile)
        {
            text2.setText("");
        }

    }

    private void emptyLoginComposant(boolean status)
    {
        try {
            btnLogin.setVisible(status);
            btnRegister.setVisible(status);
            label1.setVisible(status);
            label2.setVisible(status);
            Message.setVisible(status);
            Title.setVisible(status);
            text1.setVisible(status);
            Pwtext2.setVisible(status);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void emptyParamComposant(boolean status)
    {
        try {
            radioFile.setVisible(status);
            radioRam.setVisible(status);
            label3.setVisible(status);
            label4.setVisible(status);
            text2.setVisible(status);
            btnSave.setVisible(status);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void emptyRegisterComposant(boolean status)
    {
        try {
            Title2.setVisible(status);
            label5.setVisible(status);
            text3.setVisible(status);
            label6.setVisible(status);
            Pwtext3.setVisible(status);
            label7.setVisible(status);
            Pwtext4.setVisible(status);
            radioUser.setVisible(status);
            radioAdmin.setVisible(status);
            btnSaveRegister.setVisible(status);
            registerPanel.setVisible(status);
            text3Panel.setVisible(status);
            Pwtext3Panel.setVisible(status);
            Pwtext4Panel.setVisible(status);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
