package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class AddMarchandisePage implements ActionListener {

    AddMarchandisePage(){};

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
    static private JLabel Title,message, label1, label2, label3, label4;
    //text field
    static private JTextField text1, text2;
    //list
    static private JComboBox listC;

    private void initButtons()
    {
        btnAdd = new JButton("Ajouter");
        btnAdd.setFont(Btnfont);
        btnAdd.setBounds(130, 250, 100, 25);
        btnAdd.addActionListener(new AddMarchandisePage());

        btnBack = new JButton("Retour");
        btnBack.setBounds(300, 330, 80, 25);
        btnBack.addActionListener(new AddMarchandisePage());

    }

    private void initLabels()
    {
        Title = new JLabel("Ajouter Marchandise");
        Title.setBounds(100, 30, 300, 25);
        Title.setFont(Titlefont);


        message = new JLabel();
        message.setBounds(30, 100, 180, 25);
        message.setFont(Labelfont);
        message.setForeground(Color.red);


        label1 = new JLabel("Poids* :");
        label1.setBounds(30, 80, 150, 25);
        label1.setFont(Labelinfo);

        label3 = new JLabel("Volume* :");
        label3.setBounds(30, 130, 150, 25);
        label3.setFont(Labelinfo);

        label4 = new JLabel("Cargaison :");
        label4.setBounds(30, 180, 150, 25);
        label4.setFont(Labelinfo);

        label2 = new JLabel("EMSI © 2020-2021 All rights reserved ;)");
        label2.setBounds(10, 338, 340, 25);
        label2.setFont(Labelinfo);
        label2.setForeground(Color.BLACK);


    }

    private void initComboBox()
    {
        listC = new JComboBox(new String[]{"1", "2"});
        listC.setBounds(100, 180, 165, 25);
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
                    message.setText("");
                } else {
                    text1.setText("");
                    message.setText("* Champs numeric obligatoire (0-9)");
                }
            }
        });

        text2 = new JTextField(10);
        text2.setBounds(100, 130, 165, 25);
        text2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = text2.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    message.setText("");
                } else {
                    text2.setText("");
                    message.setText("* Champs numeric obligatoire (0-9)");
                }
            }
        });
    }

    JPanel initPanels()
    {
        initLabels();
        initTextField();
        initButtons();
        initComboBox();

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.add(Title);
        contentPanel.add(message);
        contentPanel.add(btnBack);
        contentPanel.add(text1);
        contentPanel.add(text2);
        contentPanel.add(label1);
        contentPanel.add(label2);
        contentPanel.add(label3);
        contentPanel.add(btnAdd);
        contentPanel.add(label4);
        contentPanel.add(listC);

        contentPanel.setBorder(BorderFactory.createTitledBorder("Nouvelle Marchandise"));

        return contentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd)
        {
            try {
                if (text1.getText().length() > 0)
                {
                    float d = Float.parseFloat(text1.getText());
                    float v = Float.parseFloat(text2.getText());
                    int c = Integer.parseInt((String) Objects.requireNonNull(listC.getSelectedItem()));
                    if (SocieteTransport.AjouterMarchandise(d,v,c))
                    {
                        text1.setText("");
                        text2.setText("");
                        listC.setSelectedIndex(0);
                        JOptionPane.showMessageDialog(null, "Ajout avec succès !!","Success",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        message.setText("Diastance ou Volume invalide !!");
                    }
                }
            } catch (Exception E){
                message.setText("Diastance ou Volume invalide !!");
            }

        }
        if (e.getSource() == btnBack)
        {
            HomePage homeP = new HomePage();
            Layout.getInstance("Home").switchPanel(homeP.initPanels(), HomePage.width, HomePage.height);
        }
    }
}
