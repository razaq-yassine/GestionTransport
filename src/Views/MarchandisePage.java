package Views;

import Kernel.MySession;
import Models.Marchandise;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MarchandisePage implements ActionListener {

    MarchandisePage(){};

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
    static private JLabel Title,label, message, label13;
    //text field
    static private JTextField text1;
    //table
    static private JTable dataTableC;
    static private DefaultTableModel model;
    //panel
    static private JPanel contentPanel = new JPanel();

    private void initButtons()
    {
        btnSearch = new JButton("Search");
        btnSearch.setFont(Btnfont);
        btnSearch.setBounds(290, 50, 100, 25);
        btnSearch.addActionListener(new MarchandisePage());

        btnBack = new JButton("Retour");
        btnBack.setBounds(490, 430, 80, 25);
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

        label13 = new JLabel("EMSI © 2020-2021 All rights reserved ;)");
        label13.setBounds(10, 440, 350, 25);
        label13.setFont(LabelC);
        label13.setForeground(Color.BLACK);

    }

    // function permet d'eviter les doublants

    static private void check()
    {
        ArrayList<Marchandise> m = SocieteTransport.GetAllMarchandises();
        if (text1.getText().length() == 0 && SocieteTransport.NombreTotaleMarchandises() > model.getRowCount())
        {
            // Append a row
            for (Marchandise mar : m) {
                if ( check2(mar.getId_Cargaison()) )
                {
                    model.addRow(new Object[]{"" + mar.getId_Marchandise(), "" + mar.getPoids_Marchandise(), "" + mar.getVolume_Marchandie(), "" + mar.getId_Cargaison(), "Supprimer"});
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
        ArrayList<Marchandise> m = SocieteTransport.GetAllMarchandises();

        model = new DefaultTableModel();
        dataTableC = new JTable(model) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 3)
                    return false;
                return MySession.User().getType_User() == -1;
            };
        };;
        // Create a couple of columns
        model.addColumn("ID");
        model.addColumn("Poids");
        model.addColumn("Volume");
        model.addColumn("Id_Cargaison");
        model.addColumn("Action");
        // Append a row
        for (Marchandise mar : m) {
            model.addRow(new Object[]{"" + mar.getId_Marchandise(), "" + mar.getPoids_Marchandise(), "" + mar.getVolume_Marchandie(), "" + mar.getId_Cargaison(), "Supprimer"});
        }
        DefaultTableCellRenderer rendar1 = new DefaultTableCellRenderer();
        rendar1.setForeground(Color.red);

        dataTableC.getColumnModel().getColumn(4).setCellRenderer(rendar1);
        dataTableC.putClientProperty("terminateEditOnFocusLost", true);
        dataTableC.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                int row = dataTableC.getSelectedRow();
                int column = dataTableC.getSelectedColumn();
                try {
                    // new value
                    float poid = Float.parseFloat(dataTableC.getValueAt(row, 1).toString());
                    float volume = Float.parseFloat(dataTableC.getValueAt(row, 2).toString());
                    int id_Cargaison = Integer.parseInt(dataTableC.getValueAt(row, 0).toString());
                    // id is the primary key of my DB
                    int id = Integer.parseInt(dataTableC.getValueAt(row, 0).toString());
                    if (dataTableC.isColumnSelected(1))
                    {
                        if (dataTableC.isCellSelected(row,column))
                        {
                            // update
                            if ( SocieteTransport.EditMarchandise(id, poid, volume, id_Cargaison) )
                            {
                                JOptionPane.showMessageDialog(null, "Marchandise a été modifier avec succès !!","Success",JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                reset();
                                check();
                                JOptionPane.showMessageDialog(null, "Error !!","Error",JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    } else if (dataTableC.isColumnSelected(4)) {
                        if (MySession.User().getType_User() == -1)
                        {
                            int rep = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir supprimer Marchandise : " + dataTableC.getValueAt(row, 0).toString());
                            if (rep == 0)
                            {
                                if (SocieteTransport.DeleteMarchandise(id))
                                {
                                    model.removeRow(row);
                                    JOptionPane.showMessageDialog(null, "Bravo !!","Success",JOptionPane.INFORMATION_MESSAGE);
                                    text1.setText("");
                                    reset();
                                    check();
                                } else JOptionPane.showMessageDialog(null, "Erreur !!","Error",JOptionPane.ERROR_MESSAGE);

                            }
                        }
                        else JOptionPane.showMessageDialog(null, "Vous n'avez pas le previlege pour ceci !!","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        if (model.getRowCount() == m.size())
                        {
                            reset();
                            check();
                        }

                    }
                    dataTableC.clearSelection();

                } catch (Exception ignored){
                    if (model.getRowCount() != 1)
                    {
                        reset();
                        check();
                    }

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
        contentPanel.add(label13);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
        tablePanel.setBounds(20, 100, 550, 280);
        tablePanel.add(new JScrollPane(dataTableC));

        contentPanel.add(tablePanel);
        contentPanel.setBorder(BorderFactory.createTitledBorder("Marchandise"));

        return contentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch)
        {
            try {
                check();
                int id = Integer.parseInt(text1.getText());
                boolean verify = false;
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
                        verify = true;
                    }
                    model.removeRow(0);
                }
                if (verify)
                    model.addRow(new Object[]{"" + data.get(0), "" + data.get(1), "" + data.get(2),
                            "" + data.get(3), "" + data.get(4), "Supprimer"});
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
            Layout.getInstance("test").switchPanel(homeP.initPanels(), HomePage.width, HomePage.height);
        }
    }
}
