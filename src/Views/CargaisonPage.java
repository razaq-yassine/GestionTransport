package Views;

import Models.Cargaison;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

public class CargaisonPage implements ActionListener {

    CargaisonPage(){};

    //size
    static int width = 600;
    static int height = 500;
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
    //table
    static private JTable dataTableC;
    static private DefaultTableModel model;
    //panel
    static private JPanel info = new JPanel();
    static private JPanel contentPanel = new JPanel();


    private void initButtons()
    {
        btnSearch = new JButton("Search");
        btnSearch.setFont(Btnfont);
        btnSearch.setBounds(290, 50, 100, 25);
        btnSearch.addActionListener(new CargaisonPage());

        btnBack = new JButton("Retour");
        btnBack.setBounds(490, 430, 80, 25);
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
        message.setBounds(80, 70, 180, 25);
        message.setFont(Labelfont);
        message.setForeground(Color.red);

//        label0 = new JLabel("Cargaison Info");
//        label0.setBounds(110, 100, 300, 25);
//        label0.setFont(Titlefont2);

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

        label11 = new JLabel("Type :");
        label11.setFont(Labelinfo);

        label12 = new JLabel("//////////////");
        label12.setFont(Labelinfo);

        label13 = new JLabel("EMSI © 2020-2021 All rights reserved ;)");
        label13.setBounds(10, 440, 350, 25);
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
                check();

            }
        });
    }
    // function permet d'eviter les doublants

    static private void check()
    {
        ArrayList<Cargaison> c = SocieteTransport.GetAllCargaisons();
        if (text1.getText().length() == 0 && SocieteTransport.NombreTotaleCargaisons() > model.getRowCount())
        {
            // Append a row
            for (Cargaison car : c) {
                if ( check2(car.getId_Cargaison()) )
                {
                    model.addRow(new Object[]{"" + car.getId_Cargaison(), "" + car.getDistance_Cargaison(), "" + car.PoidsTotale(), "" + car.VolumeTotale(), "" + car.Cout(), "" + car.Type(), "Supprimer"});
                }
            }
        }
    }
    static private boolean check2(int val)
    {
        for (int i = 0; i < model.getRowCount(); i++)
        {
            String f = model.getValueAt(i,0).toString();
            int v = Integer.parseInt(f);
            if(v == val)
                return false;
        }
        return true;
    }

    private void initTables(){
        ArrayList<Cargaison> c = SocieteTransport.GetAllCargaisons();

        model = new DefaultTableModel();
        dataTableC = new JTable(model) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 2 || column == 3 || column == 4 || column == 5 )
                    return false;
                else
                    return true;
            };
        };;
        // Create a couple of columns
        model.addColumn("ID");
        model.addColumn("Distance");
        model.addColumn("Poid");
        model.addColumn("Volume");
        model.addColumn("Cout");
        model.addColumn("Type");
        model.addColumn("Action");

        // Append a row
        for (Cargaison car : c) {
            model.addRow(new Object[]{"" + car.getId_Cargaison(), "" + car.getDistance_Cargaison(), "" + car.PoidsTotale(),
                    "" + car.VolumeTotale(), "" + car.Cout(), "" + car.Type(), "Supprimer"});
        }
        DefaultTableCellRenderer rendar1 = new DefaultTableCellRenderer();
        rendar1.setForeground(Color.red);

        dataTableC.getColumnModel().getColumn(6).setCellRenderer(rendar1);
        dataTableC.putClientProperty("terminateEditOnFocusLost", true);
        dataTableC.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                int row = dataTableC.getSelectedRow();
                int column = dataTableC.getSelectedColumn();
                ArrayList<Object> data = new ArrayList<Object>();;
                try {
                    if (dataTableC.isColumnSelected(1))
                    {
                        if (dataTableC.isCellSelected(row,column))
                        {
                            // new value
                            double distance = Double.parseDouble(dataTableC.getValueAt(row, 1).toString());
                            String type = dataTableC.getValueAt(row, 5).toString();
                            // id is the primary key of my DB
                            int id = Integer.parseInt(dataTableC.getValueAt(row, 0).toString());
                            System.out.println(id + " / " + distance + "/" +type);
                            // update
                            if ( SocieteTransport.EditCargaison(id, distance) )
                            {
                                JOptionPane.showMessageDialog(null, "Cargaison a été modifier avec succès !!","Success",JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                reset();
                                check();
                                JOptionPane.showMessageDialog(null, "Error !!","Error",JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    } else if (dataTableC.isColumnSelected(6)) {

                       int rep = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir supprimer Cargaison : " + dataTableC.getValueAt(row, 0).toString());
                       if (rep == 0)
                       {
                           JOptionPane.showMessageDialog(null, "Bravo !!","Success",JOptionPane.INFORMATION_MESSAGE);
                       }
                    }
                    else {
                        if (model.getRowCount() == c.size())
                        {
                            reset();
                            check();
                        }

                    }
                    dataTableC.clearSelection();

                } catch (Exception ignored){
                    reset();
                    check();
                }
            }
        });
    }

    private void reset()
    {
        while (true)
        {
            try{
                model.removeRow(0);
            } catch (Exception e){
                break;
            }

        }
    }

    JPanel initPanels()
    {
        initLabels();
        initTextField();
        initButtons();
        initTables();

        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.add(Title);
        contentPanel.add(btnBack);
        contentPanel.add(label);
        contentPanel.add(text1);
        contentPanel.add(btnSearch);
        contentPanel.add(message);
//        contentPanel.add(label0);
        contentPanel.add(label13);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
        tablePanel.setBounds(20, 100, 550, 280);
        tablePanel.add(new JScrollPane(dataTableC));

        contentPanel.add(tablePanel);

        info = new JPanel();
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
//        info.setVisible(false);

//        contentPanel.add(info);
        contentPanel.setBorder(BorderFactory.createTitledBorder("Cargaison"));

        return contentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch)
        {
            try {
                check();
                int id = Integer.parseInt(text1.getText());

                ArrayList<Object> data = new ArrayList<Object>();
                while (true)
                {
                    String f = null;
                    try {
                        f = model.getValueAt(0,0).toString();
                    } catch (Exception ignored){ break;}

                    int val = Integer.parseInt(f);
                    if (val == id)
                    {
                        data.add(model.getValueAt(0,0));
                        data.add(model.getValueAt(0,1));
                        data.add(model.getValueAt(0,2));
                        data.add(model.getValueAt(0,3));
                        data.add(model.getValueAt(0,4));
                        data.add(model.getValueAt(0,5));
                    }
                    model.removeRow(0);
                }
                if (data.size()>0)
                model.addRow(new Object[]{"" + data.get(0), "" + data.get(1), "" + data.get(2),
                        "" + data.get(3), "" + data.get(4), "" + data.get(5), "Supprimer"});
                else
                {
                    JOptionPane.showMessageDialog(null, "ID invalide !!","Error",JOptionPane.ERROR_MESSAGE);
                    text1.setText("");
                    check();
                }
            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, "ID invalide !!","Error",JOptionPane.ERROR_MESSAGE);
                text1.setText("");
                check();
            }

        }
        if (e.getSource() == btnBack)
            {
                HomePage homeP = new HomePage();
                Layout.getInstance("Home").switchPanel(homeP.initPanels(), HomePage.width, HomePage.height);
            }
    }
}
