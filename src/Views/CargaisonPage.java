package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CargaisonPage implements ActionListener {

    CargaisonPage(){};

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
    static private JLabel Title,label, message, label0, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13;
    //text field
    static private JTextField text1;

    private void initButtons()
    {
        btnSearch = new JButton("Search");
        btnSearch.setFont(Btnfont);
        btnSearch.setBounds(290, 50, 100, 25);
        btnSearch.addActionListener(new CargaisonPage());

        btnBack = new JButton("Retour");
        btnBack.setBounds(390, 370, 80, 25);
        btnBack.addActionListener(new CargaisonPage());

    }

    private void initLabels()
    {
        Title = new JLabel("Consulter Cargaison");
        Title.setBounds(150, 20, 300, 25);
        Title.setFont(Titlefont);

        label = new JLabel("ID : ");
        label.setBounds(40, 50, 50, 25);
        label.setFont(Titlefont);

        message = new JLabel();
        message.setBounds(80, 70, 150, 25);
        message.setFont(Labelfont);
        message.setForeground(Color.red);

        label0 = new JLabel("Cargaison Info");
        label0.setBounds(110, 100, 300, 25);
        label0.setFont(Titlefont2);

        label1 = new JLabel("Id cargaison  :");
        label1.setFont(Labelinfo);

        label2 = new JLabel("////////////");
        label2.setFont(Labelinfo);

        label3 = new JLabel("Distance      :");
        label3.setFont(Labelinfo);

        label4 = new JLabel("////////////");
        label4.setFont(Labelinfo);

        label5 = new JLabel("Poid totale   :");
        label5.setFont(Labelinfo);

        label6 = new JLabel("/////////////");
        label6.setFont(Labelinfo);

        label7 = new JLabel("Volume totale :");
        label7.setFont(Labelinfo);

        label8 = new JLabel("/////////////");
        label8.setFont(Labelinfo);

        label9 = new JLabel("Cout cargaison :");
        label9.setFont(Labelinfo);

        label10 = new JLabel("/////////////");
        label10.setFont(Labelinfo);

        label11 = new JLabel("Type         :");
        label11.setFont(Labelinfo);

        label12 = new JLabel("//////////////");
        label12.setFont(Labelinfo);

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
        info.setBounds(80, 140,350,180);
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

        JPanel field3 = new JPanel();
        field3.add(label5);
        field3.add(label6);
        field3.setMaximumSize( field3.getPreferredSize() );
        info.add(field3);

        JPanel field4 = new JPanel();
        field4.add(label7);
        field4.add(label8);
        field4.setMaximumSize( field4.getPreferredSize() );
        info.add(field4);

        JPanel field5 = new JPanel();
        field5.add(label9);
        field5.add(label10);
        field5.setMaximumSize( field5.getPreferredSize() );
        info.add(field5);

        JPanel field6 = new JPanel();
        field6.add(label11);
        field6.add(label12);
        field6.setMaximumSize( field6.getPreferredSize() );
        info.add(field6);

        contentPanel.add(info);
        contentPanel.setBorder(BorderFactory.createTitledBorder("Cargaison"));

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
