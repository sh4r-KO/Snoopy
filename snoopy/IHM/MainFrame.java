package IHM;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class MainFrame extends JFrame{

    public MainFrame(){
        super("Snoppy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //default color is black   
        getContentPane().setBackground(java.awt.Color.GREEN);
       

        //this.setIconImage(getIconImage());
        this.setLocation(EXIT_ON_CLOSE, ABORT);
        this.setResizable(false);
        this.setSize(1000,800);
        setLocationRelativeTo(null);

        JPanel panel = new ScoresPanel();
        JPanel panel2 = new MenuPanel();
        JPanel panel3 = new LoadGamePanel();
        JPanel panel4 = new PasswordPanel();
        JPanel[] panels = {panel, panel2, panel3, panel4};
        for (JPanel panel123 : panels) {
            panel123.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        }

        //this.setLayout(new GridLayout(2,2));
        this.add(panel);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);



        setVisible(true);
    }
    
}
    

