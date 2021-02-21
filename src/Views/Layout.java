package Views;

import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {

    private static Layout instance;


    private Container mainPane ;
    private LoginPage loginP = new LoginPage();
//    private HomePage homeP = new HomePage();
//    private CargaisonPage carP = new CargaisonPage();

    public Layout(String Title){
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = (int) screenSize.getWidth();
//        int height = (int) screenSize.getHeight();
        this.setSize(LoginPage.width, LoginPage.height);
        setResizable(false);
        this.setTitle(Title);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);

        mainPane = this.getContentPane();
        mainPane.add(loginP.initPanels());

//        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //full screen
        this.setVisible(true);
    }

    static Layout getInstance(String Title) {
        if (instance == null) {
            instance = new Layout(Title);
        }
        return instance;
    }

    public static void main(String[] args) throws Exception{

        new Layout("test");

    }
    void switchPanel(JPanel newPanel,int w,int h)
    {
        mainPane.removeAll();
        mainPane.revalidate();
        mainPane.repaint();
        mainPane.add(newPanel);
        this.setSize(w, h);
    }
}
