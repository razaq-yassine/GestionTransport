package Views;

import Models.Marchandise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MarchandisePage implements ActionListener {

    MarchandisePage(){};

    //size
    static int width = 500;
    static int height = 450;
    //Fonts
    static private Font Btnfont = new Font("Candra", Font.ITALIC, 12);
    static private Font Titlefont = new Font("Candara", Font.PLAIN, 20);
    static private Font Titlefont2 = new Font("Candara", Font.BOLD, 20);
    static private Font Labelfont = new Font("Candara", Font.BOLD, 10);
    static private Font Labelinfo = new Font("Candara", Font.ITALIC, 14);
    static private Font LabelC = new Font("Candara", Font.BOLD, 14);
    //Buttons
    static private JButton btnSearch, btnBack;
    //Labels
    static private JLabel Title,label, message, label0, label1, label2, label3, label4, label13;
    //text field
    static private JTextField text1;

    private void initButtons()
    {
        btnSearch = new JButton("Search");
        btnSearch.setFont(Btnfont);
        btnSearch.setBounds(290, 50, 100, 25);
        btnSearch.addActionListener(new MarchandisePage());

        btnBack = new JButton("Retour");
        btnBack.setBounds(390, 370, 80, 25);
        btnBack.addActionListener(new MarchandisePage());

    }

    private void initLabels()
    {
        Title = new JLabel("Consulter Marchandise");
        Title.setBounds(150, 20, 300, 25);
        Title.setFont(Titlefont);

        label = new JLabel("ID : ");
        label.setBounds(40, 50, 50, 25);
        label.setFont(Titlefont);

        message = new JLabel();
        message.setBounds(80, 70, 180, 25);
        message.setFont(Labelfont);
        message.setForeground(Color.red);

        label0 = new JLabel("Marchandise Info");
        label0.setBounds(110, 100, 300, 25);
        label0.setFont(Titlefont2);

        label1 = new JLabel("Poids       :");
        label1.setFont(Labelinfo);

        label2 = new JLabel("////////////");
        label2.setFont(Labelinfo);

        label3 = new JLabel("Volume      :");
        label3.setFont(Labelinfo);

        label4 = new JLabel("////////////");
        label4.setFont(Labelinfo);

        label13 = new JLabel("EMSI © 2020-2021 All rights reserved ;)");
        label13.setBounds(10, 380, 350, 25);
        label13.setFont(LabelC);
        label13.setForeground(Color.BLACK);

    }

    private void initTextField()
    {
        text1 = new JTextField(10);
        text1.setBounds(80, 50, 165, 25);
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

    JPanel initPanels()
    {
        initLabels();
        initTextField();
        initButtons();

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.add(Title);
        contentPanel.add(btnBack);
        contentPanel.add(label);
        contentPanel.add(text1);
        contentPanel.add(btnSearch);
        contentPanel.add(message);
        contentPanel.add(label0);
        contentPanel.add(label13);

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setBounds(80, 140,350,80);
        info.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel field1 = new JPanel();
        field1.add(label1);
        field1.add(label2);
        field1.setMaximumSize( field1.getPreferredSize() );
        info.add(field1);

        JPanel field2 = new JPanel();
        field2.add(label3);
        field2.add(label4);
        field2.setMaximumSize( field2.getPreferredSize() );
        info.add(field2);



        contentPanel.add(info);
        contentPanel.setBorder(BorderFactory.createTitledBorder("Marchandise"));

        return contentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch)
        {
            try {
                int id = Integer.parseInt(text1.getText());

                Marchandise m = SocieteTransport.ConsulterMarchandose(id);
                label2.setText("" + m.getPoids_Marchandise());
                label4.setText("" + m.getVolume_Marchandie());

            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "ID invalide !!","Error",JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == btnBack)
        {
            HomePage homeP = new HomePage();
            Layout.getInstance("test").switchPanel(homeP.initPanels(), HomePage.width, HomePage.height);
        }
    }
}
