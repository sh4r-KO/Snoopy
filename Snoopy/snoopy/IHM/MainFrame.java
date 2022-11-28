package IHM;
import javax.swing.JFrame;

import controller.Tmp;


public class MainFrame extends JFrame{

    public int width;
    public int height;

    public ScoresPanel SP;
    public MenuPanel MP;
    public LoadGamePanel LGP;
    public PasswordPanel PP;
    public GamePanel GP;


    public MainFrame(){
        super("Snoppy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(java.awt.Color.GREEN);
        //this.setIconImage(getIconImage());
        this.setLocation(EXIT_ON_CLOSE, ABORT);
        this.setResizable(false);
        this.setSize(1000,800);
        setLocationRelativeTo(null);

        
        //JPanel[] panels = {SP = new ScoresPanel(), MP = new MenuPanel(), LGP = new LoadGamePanel(), PP = new PasswordPanel()};
        
        Tmp t = new Tmp(this);
        SP = new ScoresPanel(t); 
        MP = new MenuPanel(t);
        LGP = new LoadGamePanel(t);
        PP = new PasswordPanel(t);
        GP = new GamePanel(t);

        /* 
        for (JPanel panel123 : panels) {
            panel123.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        }
        */

        this.add(MP);
        setVisible(true);
    }
    

    public void scoresCliked(){
        this.remove(MP);
        this.add(SP);
        this.repaint();
        this.validate();
    }
    public void retourCliked(){
        
        this.getContentPane().removeAll();
        this.add(MP);
        this.repaint();
    }
    public void mdpClicked(){
        this.remove(MP);
        this.add(PP);
        this.repaint();
        this.validate();

    }
    public void chargerPClicked(){
        this.remove(MP);
        this.add(LGP);
        this.repaint();
        this.validate();
    }
    public void jeuBaseClicked(){
        this.remove(MP);
        this.add(GP);
        this.repaint();
        this.validate();
    }
    public void jeuAvcClicked(){
        this.remove(MP);
        this.add(GP);
        this.repaint();
        this.validate();
    }
    public void quitterCliked(){
        this.dispose();
    }
    
}
    

